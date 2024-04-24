<div align="center">
   <a href="/ENGLISH.md"> <b>Translate to english</b> </a>
</div>
<br>

<img src="./docs/logo.svg" width="30000"/>

##

<div align = "center">  
<a href="https://github.com/devxb/gitanimals">
    <img src="https://render.gitanimals.org/lines/devxb?pet-id=10" width="1000" height="120"/>
</a>

⭐스타를 눌러주세요 개발에 큰 도움이 됩니다!⭐️<br>
<i><h4><a href="https://github.com/devxb/gitanimals/stargazers">Press star</a></h4></i>
</div>

<div align="center">
<h3>깃허브 활동으로 펫을 키우세요!</h3> 
<h4> 깃허브 활동으로 펫을 획득하고 성장시킬 수 있어요.
<br> 커밋을 30번 하면 1개의 펫을 추가로 입양할 수 있어요.
<br> 1개의 contribution은 랜덤한 펫의 level을 1 증가시켜요.
<br> 키운 펫은 다른사람과 거래할 수 있어요.     
<br>
<br>
40 종류가 넘는 펫을 뽑고 기르세요.
</h4>
<br>
<a href="https://github.com/devxb/gitanimals">
    <img alt="docs/sample.svg" src="https://render.gitanimals.org/farms/devxb"/>
</a>
</div>

## 빠르게 사용하기

아래의 링크를 깃허브 Readme 에 붙여넣기 하는것으로 쉽게 적용할 수 있어요.

> [!IMPORTANT]   
> {username} 은 자신의 깃허브 닉네임 (ex. devxb) 으로 변경해주세요.    
> 이때, {username} 은 반드시 자신의 깃허브 이름이 들어가야 합니다.

### line mode

line mode는 자신이 갖고있는 펫중 하나를 지정해서, 지정한 width, height범위에서 움직이게 해요.   
line mode를 사용할때, markdown 방식으로 이미지를 요청하면, width, height를 설정할 수 없어서 펫이 보이지 않을 수 있으니, HTMl방식을
사용해주세요.

> [!TIP]   
> **Img의 width와 height를 조절해서 펫의 이동영역을 조절할 수 있어요.**   
> width를 길게 height를 작게하면 (width = 1000, height = 60) 가로로 길게 움직이게 할 수 있어요.   
> 반대로, width를 작게 height를 길게하면 (width = 60, height = 1000) 세로로 길게 움직이게 할 수 있어요.   
> 만약, 펫이 보이지 않는다면, img의 height를 펫의 세로 길이보다 충분히 크게 적용해주세요.


<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/devxb?pet-id=1" width="300" height="120"/>
</a>

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/lines/{username}?pet-id=1" width="1000" height="120"/>
</a>
```   

_pet-id에 아무값도 입력하지 않으면, 첫번째 펫이 가져와져요._

변경 가능한 pet-id는 `https://render.gitanimals.org/users/{username}` 의 {username}을 자신의 깃허브 아이디로 변경 후 API를
요청하면 확인할 수 있어요.   
API 응답의 `$.personas.[].id` 에 해당하는 값을 pet-id에 입력하면 돼요.

lines모드에서는 펫 레벨 위에 총 contributions수를 보여줘요. 원하지 않을경우, 쿼리 파라미터로 `contribution-view=false`를 담아 요청하세요.

### farm mode

farm mode는 갖고있는 모든 동물과 추가적인 정보를 보여줘요.

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/farms/devxb" width="300"/>
</a>

**html**

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/farms/{username}"/>
</a>
```

## TIPS

### 펫을 획득하는 방법

펫은 다음 두가지 방법으로 획득할 수 있어요.

1. **커밋 30번하기**    
   커밋이 30번 누적되면 새로운 펫이 등장해요. 이때, 모든 펫들은 등장하는 확률이 달라요.   
   이때, 최대로 얻을 수 있는 펫은 30개 입니다. 30개가 넘는 펫은 인벤토리로 들어가며, 언제든지 보여지는 펫과 교체할 수 있어요. **_<- 개발중_**
2. **펫 구매하기** **_<- 개발중_**   
   다른 유저가 판매하는 펫을 커밋포인트로 구매할 수 있어요.    
   커밋 1회당 일정량의 포인트가 지급됩니다. 혹은 자신의 펫을 판매해서 커밋포인트를 얻을수도 있어요.

### Total contributions

Total contribtuions 는 깃허브에 가입 후 집계된 Contribtuions 의 총합 이에요.    
_새로운 contribution은 반영은 최대 1시간이 소요될 수 있어요._

### 등장 가능한 펫들

| name                                                                         | ratio | Description                                                                                                                                                                   |
|------------------------------------------------------------------------------|-------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| goose                                                                        | 1.0   |                                                                                                                                                                               |
| goose_sunglasses                                                             | 0.05  |                                                                                                                                                                               |
|                                                                              |       |                                                                                                                                                                               |
| goose_kotlin                                                                 | 0.01  |                                                                                                                                                                               |
| goose_java                                                                   | 0.01  |                                                                                                                                                                               |
| goose_js                                                                     | 0.01  |                                                                                                                                                                               |
| goose_node                                                                   | 0.01  |                                                                                                                                                                               |
| goose_swift                                                                  | 0.01  |                                                                                                                                                                               |
| goose_linux                                                                  | 0.01  |                                                                                                                                                                               |
| goose_spring                                                                 | 0.01  |                                                                                                                                                                               |
| little_chick                                                                 | 0.9   |                                                                                                                                                                               |
| little_chick_suglasses                                                       | 0.4   |                                                                                                                                                                               |
| little_chick_kotlin                                                          | 0.01  |                                                                                                                                                                               |
| little_chick_java                                                            | 0.01  |                                                                                                                                                                               |
| little_chick_js                                                              | 0.01  |                                                                                                                                                                               |
| little_chick_node                                                            | 0.01  |                                                                                                                                                                               |
| little_chick_swift                                                           | 0.01  |                                                                                                                                                                               |
| little_chick_linux                                                           | 0.01  |                                                                                                                                                                               |
| little_chick_spring                                                          | 0.01  |                                                                                                                                                                               |
| penguin                                                                      | 0.5   |                                                                                                                                                                               |
| penguin_sunglasses                                                           | 0.2   |                                                                                                                                                                               |
| penguin_kotlin                                                               | 0.01  |                                                                                                                                                                               |
| penguin_java                                                                 | 0.01  |                                                                                                                                                                               |
| penguin_js                                                                   | 0.01  |                                                                                                                                                                               |
| penguin_node                                                                 | 0.01  |                                                                                                                                                                               |
| penguin_swift                                                                | 0.01  |                                                                                                                                                                               |
| penguin_linux                                                                | 0.01  |                                                                                                                                                                               |
| penguin_spring                                                               | 0.01  |                                                                                                                                                                               |
| pig                                                                          | 0.2   |                                                                                                                                                                               |
| pig_sunglasses                                                               | 0.08  |                                                                                                                                                                               |
| pig_kotlin                                                                   | 0.01  |                                                                                                                                                                               |
| pig_java                                                                     | 0.01  |                                                                                                                                                                               |
| pig_js                                                                       | 0.01  |                                                                                                                                                                               |
| pig_node                                                                     | 0.01  |                                                                                                                                                                               |
| pig_swift                                                                    | 0.01  |                                                                                                                                                                               |
| pig_linux                                                                    | 0.01  |                                                                                                                                                                               |
| pig_spring                                                                   | 0.01  |                                                                                                                                                                               |
| slime_red                                                                    | 0.1   |                                                                                                                                                                               |
| slime_red_kotlin                                                             | 0.001 |                                                                                                                                                                               |
| slime_red_java                                                               | 0.001 |                                                                                                                                                                               |
| slime_red_js                                                                 | 0.001 |                                                                                                                                                                               |
| slime_red_node                                                               | 0.001 |                                                                                                                                                                               |
| slime_red_swift                                                              | 0.001 |                                                                                                                                                                               |
| slime_red_linux                                                              | 0.001 |                                                                                                                                                                               |
| slime_green                                                                  | 0.1   |                                                                                                                                                                               |
| slime_blue                                                                   | 0.1   |                                                                                                                                                                               |
| flamingo <br> <img src="docs/flamingo.svg" width="50px" height="110"/>       | 0.08  |                                                                                                                                                                               |
| TEN_MM <br> <img src="docs/tenmm.svg" width="80px" height="90px"/>           | 0.00  | Character created by `10MM` donations <br> Only buy in shop <br> <a href="https://github.com/depromeet/10mm-client-web"> 10MM </a>                                            |
| goblin <br> <img src="docs/goblin.svg" width="80px" height="80px"/>          | 0.06  |                                                                                                                                                                               |
| goblin-bag <br> <img src="docs/goblin-bag.svg" width="100px" height="80px"/> | 0.03  |                                                                                                                                                                               |
| bibbi <br> <img src="docs/bbibbi.svg" width="80px" height="100px"/>         | 0.00  | Character created by `BIBBI` donations <br> Only buy in shop <br> <a href="https://play.google.com/store/apps/details?id=com.no5ing.bbibbi&hl=es_PY&gl=US&pli=1"> BIBBI </a> |

##

<div align="center">
<p> 아이디어나 발견 한 버그가 있다면 제보 해주세요.
<i>Contact : develxb@gmail.com</i></p>

<a href="https://hits.seeyoufarm.com"><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fdevxb%2Fgitanimals&count_bg=%23000000&title_bg=%23000000&icon=&icon_color=%23000000&title=hits&edge_flat=true"/></a>
</div>
