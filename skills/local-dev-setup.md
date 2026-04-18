# 로컬 개발 및 테스트 환경 설정 (H2 & Redis)

## 개요

이 스킬은 `gitanimals` 서버를 로컬에서 H2 데이터베이스와 Redis를 사용하여 실행하고, 테스트 데이터를 채워 넣는 과정을 안내합니다. 이 과정을 통해 실제 DB(MySQL) 없이도 API 동작을 로컬에서 신속하게 검증할 수 있습니다.

## 1단계: 외부 인프라 설정

### 1.1 Redis 실행 (Docker)

서버 실행을 위해 Redis가 필요합니다. Docker가 설치되어 있는지 확인하고 Redis 컨테이너를 실행합니다.

1. **Docker 설치 확인:**
   ```bash
   docker --version
   ```
   *Docker가 없다면 [Docker Desktop](https://www.docker.com/products/docker-desktop/)을 설치하세요.*

2. **Redis 실행:**
   ```bash
   docker run -d -p 6379:6379 --name gitanimals-redis redis
   ```

### 1.2 H2 데이터베이스 의존성 확인

`build.gradle` 파일에서 H2 의존성이 `implementation` 또는 `runtimeOnly`에 포함되어 있는지 확인합니다. 만약 `testRuntimeOnly`에만 있다면 아래와 같이 추가가 필요할 수 있습니다.

```gradle
// build.gradle (db.gradle 등)
dependencies {
    runtimeOnly "com.h2database:h2:${h2Version}"
}
```

## 2단계: 서버 실행

H2를 사용하도록 설정을 오버라이딩하여 서버를 실행합니다.

```bash
./gradlew bootRun --args='--spring.profiles.active=local \
  --spring.datasource.url=jdbc:h2:mem:gitanimalsrender;MODE=MySQL;DATABASE_TO_LOWER=TRUE \
  --spring.datasource.driver-class-name=org.h2.Driver \
  --spring.jpa.hibernate.ddl-auto=create \
  --spring.jpa.database-platform=org.hibernate.dialect.H2Dialect'
```

*서버가 실행되면 `localhost:8080/h2-console` (설정된 경우) 등을 통해 접속하거나, 실행 중인 서버에 직접 SQL을 실행할 수 있습니다.*

## 3단계: 테스트 데이터 삽입

서버가 실행 중인 상태에서 (또는 `ddl-auto=create`로 테이블이 생성된 후), 테스트를 위한 유저와 페르소나 데이터를 삽입합니다.

### 3.1 입력 받기

1. **Username 입력:** 추후 API 호출 시 사용할 이름 (예: `my-test-user`)
2. **Pet(Persona) 이름 입력:** `PersonaType` enum 중 하나 (예: `GOOSE`, `CAT`, `SLIME_RED` 등)

### 3.2 SQL 실행 (H2)

H2 콘솔이나 별도의 DB 툴을 통해 아래 쿼리를 실행합니다. (ID는 적절한 Long 값을 사용합니다.)

```sql
-- 1. 유저 생성 (gitanimalsrender.user 테이블)
-- name: 입력받은 username
INSERT INTO user (id, name, visit, last_persona_give_point, version, created_at, modified_at)
VALUES (1, '입력받은_username', 1, 0, 0, NOW(), NOW());

-- 2. 페르소나 생성 (gitanimalsrender.persona 테이블)
-- type: 입력받은 PersonaType
-- user_id: 위에서 생성한 유저의 id (1)
INSERT INTO persona (id, type, level, visible, user_id, version, created_at, modified_at)
VALUES (100, '입력받은_PersonaType', 1, true, 1, 0, NOW(), NOW());
```

## 4단계: API 검증

데이터가 정상적으로 들어갔다면 브라우저나 `curl`을 통해 결과를 확인합니다.

```bash
curl http://localhost:8080/lines/입력받은_username
```

정상적으로 SVG 응답이 온다면 로컬 테스트 환경 설정이 완료된 것입니다.

## PersonaType 목록 참고

주요 PersonaType은 다음과 같습니다:
- `GOOSE`, `GOOSE_SUNGLASSES`
- `LITTLE_CHICK`, `LITTLE_CHICK_SUNGLASSES`
- `PENGUIN`, `PENGUIN_SUNGLASSES`
- `CAT`, `CHEESE_CAT`, `WHITE_CAT`
- `SLIME_RED`, `SLIME_BLUE`, `SLIME_GREEN`
- `PIG`, `PIG_SUNGLASSES`
- `DESSERT_FOX`
- `QUOKKA`
- `MOLE`
- `RABBIT`

*전체 목록은 `src/main/kotlin/org/gitanimals/core/PersonaType.kt`를 참조하세요.*
