
<img src="./docs/logo.svg" width="30000"/>

##
<a href="https://github.com/devxb/gitanimals">
    <img src="https://render.gitanimals.org/lines/devxb?pet-id=126" width="2000" height="60"/>
</a>

<div align = "center">  
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
line mode를 사용할때, markdown 방식으로 이미지를 요청하면, width, height를 설정할 수 없어서 펫이 보이지 않을 수 있으니, HTMl방식을 사용해주세요.   
_pet-id에 아무값도 입력하지 않으면, 첫번째 펫이 가져와져요._   

> [!TIP]   
> **HTML을 붙여넣기 할 경우, Img의 width와 height를 조절해서 펫의 이동영역을 조절할 수 있어요.**   
> width를 길게 height를 작게하면 (width = 1000, height = 60) 가로로 길게 움직이게 할 수 있어요.   
> 반대로, width를 작게 height를 길게하면 (width = 60, height = 1000) 세로로 길게 움직이게 할 수 있어요.

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/devxb?pet-id=1" width="300" height="60"/>
</a>

**html**
```html
<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/{username}" width="1000" height="60"/>
</a>
```   
   
   
### farm mode
farm mode는 갖고있는 모든 동물과 추가적인 정보를 보여줘요.

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/farms/devxb" width="300"/>
</a>

**html**   
```html
<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/farms/{username}"/>
</a>
```
   
   
### 펫을 변경하는 방법
펫은 다음 url을 웹에 요청 후, `$.personas.[].id` 에 해당하는 값을 url의 pet-id param에 입력하면서 변경할 수 있어요.   
변경가능한 펫을 확인하려면, `https://render.gitanimals.org/users/{username}` 의 {username}을 자신의 깃허브 아이디로 변경 후, 요청해보세요.   
```html
<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/devxb?pet-id=1" width="1000" height="60"/>
</a>
```   

## TIPS

### 펫을 획득하는 방법

펫은 다음 두가지 방법으로 획득할 수 있습니다.

1. **커밋 30번하기**    
    커밋이 30번 누적되면 새로운 펫이 등장해요. 이때, 모든 펫들은 등장하는 확률이 다릅니다.   
    이때, 최대로 얻을 수 있는 펫은 30개 입니다. 30개가 넘는 펫은 인벤토리로 들어가며, 언제든지 보여지는 펫과 교체할 수 있어요. **_<- 개발중_** 
2. **펫 구매하기** **_<- 개발중_**   
    다른 유저가 판매하는 펫을 커밋포인트로 구매할 수 있어요.    
    커밋 1회당 일정량의 포인트가 지급됩니다. 혹은 자신의 펫을 판매해서 커밋포인트를 얻을수도 있어요.     

### Total contributions

Total contribtuions 는 깃허브에 가입 후 모든 Contribtuions 수를 집계해서 보여줍니다.   
이때, 새로운 contribtuion은 반영은 최대 1시간이 소요될 수 있습니다. 

### 등장 가능한 펫들

<img alt="docs/pets.svg" src="docs/pets.svg"/>

##

<div align="center">
<p> 아이디어나 발견 한 버그가 있다면 제보 해주세요.
<i>Contact : develxb@gmail.com</i></p>
</div>
