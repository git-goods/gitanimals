# 펫에 Emotion 애니메이션 추가하기

## 개요

펫에 emotion 애니메이션을 추가하면, `loadSvg` 호출 시 랜덤한 타이밍에 emotion이 재생됩니다.
emotion이 재생되는 동안 base 펫은 숨겨지고, emotion SVG가 대신 표시됩니다.
이동(act)과 방향전환(flip)은 emotion 중에도 유지됩니다.

## 파일 구조

```
src/main/resources/persona/animal/
├── {pet-name}.svg                          # base 펫 SVG 템플릿
└── emotion/{pet-short-name}/               # emotion SVG 디렉토리
    ├── error.svg
    ├── happy.svg
    ├── idle-follow.svg
    ├── notification.svg
    ├── thinking.svg
    └── typing.svg

src/main/kotlin/org/gitanimals/core/
├── PersonaType.kt        # 펫 enum (loadSvg, act, addEmotions)
├── PersonaEmotionType.kt # emotion 타입 enum (ERROR, HAPPY, IDLE_FOLLOW, NOTIFICATION, THINKING, TYPING)
└── Svgs.kt               # SVG 파일 로딩
```

## 단계별 구현

### 1. Emotion SVG 파일 작성

`src/main/resources/persona/animal/emotion/{pet-short-name}/` 디렉토리에 6개의 emotion SVG를 작성합니다.

**필수 규칙:**

- viewBox: 펫 본체 + props(느낌표, 스파클, 말풍선 등)가 모두 포함되도록 설정
- ID 패턴: `{pet-name}-*{id}-{emotion}-{part}` (예: `dessert-fox-*{id}-error-shadow`)
- `*{id}`는 런타임에 `animationId`로 치환됩니다
- 각 SVG는 독립적으로 동작하는 완전한 애니메이션이어야 합니다 (style + 구조 포함)

**SVG 내부 구조:**

```xml
<svg xmlns="http://www.w3.org/2000/svg" viewBox="-15 -25 45 45">
  <style>
    @keyframes {pet-name}-*{id}-{emotion}-shadow { ... }
    @keyframes {pet-name}-*{id}-{emotion}-obj { ... }
    /* 기타 keyframes */

    #{pet-name}-*{id}-{emotion}-shadow { animation: ... }
    #{pet-name}-*{id}-{emotion}-obj { animation: ... }
  </style>

  <!-- Shadow -->
  <g id="{pet-name}-*{id}-{emotion}-shadow" transform="translate(3, 7)">...</g>

  <!-- obj: legs + body + head -->
  <g id="{pet-name}-*{id}-{emotion}-obj">
    <!-- Legs -->
    <g id="{pet-name}-*{id}-{emotion}-leg-left" transform="translate(5, 5)">...</g>
    <g id="{pet-name}-*{id}-{emotion}-leg-right" transform="translate(8, 5)">...</g>
    <!-- Body -->
    <g transform="translate(-2, 2)">...</g>
    <!-- Head -->
    <g transform="translate(0, -5)">
      <g id="{pet-name}-*{id}-{emotion}-head-nod">...</g>
    </g>
  </g>

  <!-- Props (!, sparkles 등 — obj 바깥에 배치) -->
  <g id="{pet-name}-*{id}-{emotion}-exclam" transform="translate(15, -13)">...</g>
</svg>
```

**emotion별 특징:**

| emotion | 포즈 | 특수 효과 |
|---------|------|-----------|
| error | standing | X X 눈, 좌우 흔들림, 빨간 ! 깜빡임 |
| happy | standing | ^^ 눈, 점프 바운스, 스파클 |
| idle-follow | standing | 일반 눈, 부드러운 바운스 |
| notification | standing | 일반 눈, 놀람 점프, 노란 ! 팝인 |
| thinking | standing | 일반 눈, 말풍선 + 로딩 dots |
| typing | **sitting** | 일반 눈, 노트북 prop, 고개 끄덕임 |

### 2. Svgs.kt에 SVG 로딩 추가

```kotlin
// src/main/kotlin/org/gitanimals/core/Svgs.kt

val {petName}ErrorEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/error.svg")
    .getContentAsString(Charset.defaultCharset())

val {petName}HappyEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/happy.svg")
    .getContentAsString(Charset.defaultCharset())

val {petName}IdleFollowEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/idle-follow.svg")
    .getContentAsString(Charset.defaultCharset())

val {petName}NotificationEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/notification.svg")
    .getContentAsString(Charset.defaultCharset())

val {petName}ThinkingEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/thinking.svg")
    .getContentAsString(Charset.defaultCharset())

val {petName}TypingEmotionSvg: String = ClassPathResource("persona/animal/emotion/{pet-short-name}/typing.svg")
    .getContentAsString(Charset.defaultCharset())
```

### 3. Base 펫 SVG 템플릿 수정

base SVG에 3가지 플레이스홀더를 추가합니다.

**3-1. `*{emotion-style}` 플레이스홀더 추가**

`<style>` 블록 안에 `*{emotion-style}`을 추가합니다:

```xml
<style>
  *{act}
  *{emotion-style}

  @keyframes {pet-name}-*{id}-leg-left-move { ... }
  ...
</style>
```

**3-2. base 펫 콘텐츠를 `<g id="{pet-name}-*{id}-base">`로 감싸기**

emotion 재생 시 base를 숨기기 위해 wrapper 그룹을 추가합니다:

```xml
<svg width="600" height="300" viewBox="0 0 200 100" fill="none" overflow="visible">
  <g id="{pet-name}-*{id}-base">
    <!-- 기존 shadow, obj, body, head 등 모든 base 콘텐츠 -->
  </g>
  *{emotions}
</svg>
```

**3-3. `*{emotions}` 플레이스홀더 추가**

base 콘텐츠 `</g>` 닫힘 태그 바로 뒤, `</svg>` 앞에 추가합니다.

### 4. PersonaType.kt에서 loadSvg 구현

`buildEmotionAnimation()` 공통 메서드를 사용합니다.

```kotlin
{PET_NAME}(weight) {
    override fun loadSvg(name: String, animationId: Long, level: Long, mode: Mode): String {
        val emotion = buildEmotionAnimation(
            idPrefix = "{pet-name}",          // base SVG의 ID prefix와 동일해야 함
            animationId = animationId,
            totalDuration = 180.0,            // 전체 애니메이션 사이클 (초)
            emotionDuration = 3.0,            // 각 emotion 재생 시간 (초)
            emotionSvgs = listOf(
                {petName}ErrorEmotionSvg,        // index 0
                {petName}HappyEmotionSvg,        // index 1
                {petName}IdleFollowEmotionSvg,   // index 2
                {petName}NotificationEmotionSvg, // index 3
                {petName}ThinkingEmotionSvg,     // index 4
                {petName}TypingEmotionSvg,       // index 5
            ),
            emotionYOffsets = listOf(
                5.0,  // error     (standing)
                5.0,  // happy     (standing)
                5.0,  // idle      (standing)
                5.0,  // notif     (standing)
                5.0,  // thinking  (standing)
                2.5,  // typing    (sitting — 앉아있으므로 Y 보정이 다름)
            ),
            minGap = 5.0,                     // emotion 사이 최소 간격 (초)
            maxGap = 30.0,                    // emotion 사이 최대 간격 (초)
        )

        return {petName}Svg
            .replace("*{act}", act(animationId))
            .replace("*{emotion-style}", emotion.css)
            .replace("*{emotions}", emotion.content)
            .replace("*{id}", animationId.toString())
            .replace("*{level}", level.toSvg(14.0, 2.0))
            .replace("*{levelx}", (-3 + (-1 * (level.toString().length))).toString())
            .replace("*{username}", name.toSvg(14.0, 25.0))
            .replace("*{usernamex}", (23 + (-3 * name.length)).toString())
    }

    override fun addEmotions(emotionType: PersonaEmotionType): String {
        return when (emotionType) {
            ERROR -> {petName}ErrorEmotionSvg
            HAPPY -> {petName}HappyEmotionSvg
            IDLE_FOLLOW -> {petName}IdleFollowEmotionSvg
            NOTIFICATION -> {petName}NotificationEmotionSvg
            THINKING -> {petName}ThinkingEmotionSvg
            TYPING -> {petName}TypingEmotionSvg
        }
    }
}
```

### 5. emotionYOffsets 결정하기

`emotionYOffsets`는 emotion SVG를 base 펫 위치에 정렬하기 위한 Y축 보정값입니다.
base SVG와 emotion SVG의 좌표계가 다르기 때문에 필요하며, 정확한 값은 서버를 직접 띄워서 확인하며 조정해야 합니다.
Agent가 아래 요건에 따라서 스스로 서버를 띄우고 테스트하여 정확한 값을 조정하세요. 

**서버 띄우기:**

```bash
./gradlew bootRun --args="--spring.profiles.active=local"
```

**테스트 데이터 설정:**

local MySQL에 접속하여 테스트할 펫 타입으로 변경합니다:

```sql
USE gitanimalsrender;
UPDATE persona SET type = '{PET_NAME}';
```

**확인:**

브라우저에서 `localhost:8080/lines/{username}` 으로 조회하면 SVG가 응답됩니다.
emotion이 base 펫과 동일한 위치에 나타나도록 `emotionYOffsets` 값을 조정하세요.

- 디버깅 시 `minGap`과 `maxGap`을 `1.0`으로 설정하면 1초마다 emotion이 나타나서 위치 확인이 쉬움
- standing 포즈와 sitting 포즈는 보정값이 다를 수 있음 (DESSERT_FOX 기준: standing `5.0`, sitting `2.5`)

### 6. PersonaEmotionType 구현하기
org.gitanimals.render.app.PersonaEmotionAssets에 PersonaEmotionAssets.dessertFox를 참고하여 새롭게 추가한 emotion의 PersonaEmotionAssets을 추가하세요. 

## buildEmotionAnimation 파라미터

| 파라미터 | 타입 | 설명 |
|----------|------|------|
| `idPrefix` | String | CSS ID prefix. base SVG의 `*{id}` 앞 부분과 동일해야 함 |
| `animationId` | Long | 펫 인스턴스 고유 ID. ID 충돌 방지용 |
| `totalDuration` | Double | 전체 애니메이션 사이클 길이 (초) |
| `emotionDuration` | Double | 각 emotion이 표시되는 시간 (초) |
| `emotionSvgs` | List\<String\> | emotion SVG 문자열 리스트 |
| `emotionYOffsets` | List\<Double\> | 각 emotion의 Y축 보정값. emotionSvgs와 같은 순서 |
| `minGap` | Double | emotion 사이 최소 간격 (초). 기본값 5.0 |
| `maxGap` | Double | emotion 사이 최대 간격 (초). 기본값 30.0 |

## 동작 원리

1. `Random(animationId)` 시드로 결정론적 스케줄 생성
2. base 펫에 `opacity` 토글 CSS 적용 → emotion 구간에서 base 숨김
3. 각 emotion에도 `opacity` 토글 CSS 적용 → 해당 구간에서만 표시
4. `steps(1, end)` timing function으로 즉시 전환 (페이드 없음)
5. emotion SVG 내부의 자체 애니메이션 (바운스, 흔들림 등)은 독립적으로 동작
6. `*{id}`는 최종 `.replace("*{id}", animationId.toString())`에서 일괄 치환

## 디버깅 팁

- `minGap`과 `maxGap`을 `1.0`으로 설정하면 1초마다 emotion이 나타남
- `localhost:8080/lines/{username}`으로 결과 확인
- emotion이 안 보이면: CSS `animation` shorthand 대신 longhand 사용 확인
- 위치가 맞지 않으면: `emotionYOffsets` 값 조정

## 참고 구현

DESSERT_FOX 구현을 참고하세요:
- base SVG: `src/main/resources/persona/animal/dessert-fox.svg`
- emotion SVGs: `src/main/resources/persona/animal/emotion/fox/`
- PersonaType: `PersonaType.kt` DESSERT_FOX 항목
- SVG 로딩: `Svgs.kt` dessertFox*EmotionSvg 변수들
