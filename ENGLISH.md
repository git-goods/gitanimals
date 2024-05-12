<div align="center">
   <a href="/README.md"> <b>한국어로 번역하기</b> </a>
</div>
<br>

<img src="./docs/logo.svg" width="30000"/>

##

<div align = "center">  
<a href="https://github.com/devxb/gitanimals">
    <img src="https://render.gitanimals.org/lines/devxb?pet-id=8" width="1000" height="150"/>
</a>

⭐️ Please press the star! It greatly helps development! ⭐️<br>
<i><h4><a href="https://github.com/devxb/gitanimals/stargazers">Press star</a></h4></i>
</div>

<div align="center">
<h3>Grow your pets through GitHub activities!</h3> 
<h4> You can acquire and grow pets through GitHub activities.
<br> When you commit 30 times, you can adopt an additional pet.
<br> Each contribution increases a random pet's level by 1.
<br> You can trade the pets with others.     
<br>
<br>
Choose from over 40 different pets and raise them.
</h4>
<br>
<a href="https://github.com/devxb/gitanimals">
    <img alt="docs/sample.svg" src="https://render.gitanimals.org/farms/devxb"/>
</a>
</div>

## Getting Start

You can easily apply by copying the following link to your GitHub Readme.

> [!IMPORTANT]   
> Please replace {username} with your GitHub nickname (ex. devxb).    
> {username} must be your GitHub username.

### Line Mode

Line mode allows you to specify one of your pets to move within the specified width and height
range.   
When using line mode, if you request the image in markdown, you cannot set width and height, so
please use HTML format instead.

> [!TIP]   
> **Adjust the width and height of the Img to adjust the pet's movement area.**   
> If you make the width long and the height short (width = 1000, height = 60), the pet will move
> horizontally for a long distance.   
> Conversely, if you make the width short and the height long (width = 60, height = 1000), the pet
> will move vertically for a long distance.   
> If the pet is not visible, please make the height of the img larger than the vertical length of
> the pet.

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/devxb?pet-id=1" width="300" height="120"/>
</a>

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/lines/{username}" width="1000" height="120"/>
</a>
```

If you don't enter any value for pet-id, the first pet will be responsed.

You can check the available pet-ids in https://render.gitanimals.org/users/{username} to your GitHub
username and requesting the API.
Enter the value corresponding to $.personas.[].id in the API response into pet-id.

In line mode, the total number of contributions is displayed above the pet's level. If you don't
want this, include contribution-view=false as a query parameter in your request.

### Farm Mode

Farm mode shows all your animals and additional information.

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/farms/devxb" width="300"/>
</a>

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/farms/{username}"/>
</a>
```

## Tips

### How to Acquire Pets

Pets can be acquired in two ways:

1. **Contributions 30 times**   
   When you accumulate 30 commits, a new pet will appear. At this point, all pets have different
   probabilities of appearing.   
   The maximum number of pets you can have is 30. If you have more than 30 pets, they will go into
   your inventory, and you can swap them with the pets displayed at any time. <- Under development
2. **Purchase Pets <- Under development**   
   You can buy pets sold by other users with commit points.   
   A certain amount of points will be given per commit. Alternatively, you can sell your own pets to
   earn commit points.

### Total Contributions

Total contributions represent the sum of contributions accumulated after joining GitHub.   
_New contributions may take up to 1 hour to be reflected._

### Available Pets

| name                                                                                                 | ratio | Description                                                                                                                                                                  |
|------------------------------------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| FISH_MAN <br> <img src="docs/fishman.svg" width="35px" height="75px"/>                               | 0.001 |                                                                                                                                                                              |
| flamingo <br> <img src="docs/flamingo.svg" width="50px" height="110"/>                               | 0.08  |                                                                                                                                                                              |
| TEN_MM <br> <img src="docs/tenmm.svg" width="80px" height="90px"/>                                   | 0.00  | Character created by `10MM` donations <br> Only buy in shop <br> <a href="https://github.com/depromeet/10mm-client-web"> 10MM </a>                                           |
| goblin <br> <img src="docs/goblin.svg" width="80px" height="80px"/>                                  | 0.06  |                                                                                                                                                                              |
| goblin-bag <br> <img src="docs/goblin-bag.svg" width="100px" height="80px"/>                         | 0.03  |                                                                                                                                                                              |
| bibbi <br> <img src="docs/bbibbi.svg" width="80px" height="100px"/>                                  | 0.00  | Character created by `BIBBI` donations <br> Only buy in shop <br> <a href="https://play.google.com/store/apps/details?id=com.no5ing.bbibbi&hl=es_PY&gl=US&pli=1"> BIBBI </a> |
| cat <br> <img src="docs/cat.svg" width="50px" height="70px"/>                                        | 0.1   |                                                                                                                                                                              |
| cheese-cat <br> <img src="docs/cheese-cat.svg" width="50px" height="70px"/>                          | 0.04  |                                                                                                                                                                              |
| galchi-cat <br> <img src="docs/galchi-cat.svg" width="50px" height="70px"/>                          | 0.06  |                                                                                                                                                                              |
| white-cat <br> <img src="docs/white-cat.svg" width="50px" height="70px"/>                            | 0.04  |                                                                                                                                                                              |
| goose <br> <img src="docs/goose.svg" width="100px" height="60px"/>                                   | 1.0   |                                                                                                                                                                              |
| goose_sunglasses <br> <img src="docs/goose-sunglasses.svg" width="100px" height="60px"/>             | 0.05  |                                                                                                                                                                              |
| goose_kotlin <br> <img src="docs/goose-kotlin.svg" width="100px" height="60px"/>                     | 0.01  |                                                                                                                                                                              |
| goose_java <br> <img src="docs/goose-java.svg" width="100px" height="60px"/>                         | 0.01  |                                                                                                                                                                              |
| goose_js <br> <img src="docs/goose-js.svg" width="100px" height="60px"/>                             | 0.01  |                                                                                                                                                                              |
| goose_node <br> <img src="docs/goose-node.svg" width="100px" height="60px"/>                         | 0.01  |                                                                                                                                                                              |
| goose_swift <br> <img src="docs/goose-swift.svg" width="100px" height="60px"/>                       | 0.01  |                                                                                                                                                                              |
| goose_linux <br> <img src="docs/goose-linux.svg" width="100px" height="60px"/>                       | 0.01  |                                                                                                                                                                              |
| goose_spring <br> <img src="docs/goose-spring.svg" width="100px" height="60px"/>                     | 0.01  |                                                                                                                                                                              |
| little_chick <br> <img src="docs/little-chick.svg" width="45px" height="30px"/>                      | 0.9   |                                                                                                                                                                              |
| little_chick_suglasses <br> <img src="docs/little-chick-sunglasses.svg" width="45px" height="30px"/> | 0.4   |                                                                                                                                                                              |
| little_chick_kotlin <br> <img src="docs/little-chick-kotlin.svg" width="80px" height="30px"/>        | 0.01  |                                                                                                                                                                              |
| little_chick_java <br> <img src="docs/little-chick-java.svg" width="80px" height="30px"/>            | 0.01  |                                                                                                                                                                              |
| little_chick_js <br> <img src="docs/little-chick-js.svg" width="80px" height="30px"/>                | 0.01  |                                                                                                                                                                              |
| little_chick_node <br> <img src="docs/little-chick-node.svg" width="80px" height="30px"/>            | 0.01  |                                                                                                                                                                              |
| little_chick_swift <br> <img src="docs/little-chick-swift.svg" width="80px" height="30px"/>          | 0.01  |                                                                                                                                                                              |
| little_chick_linux <br> <img src="docs/little-chick-linux.svg" width="80px" height="30px"/>          | 0.01  |                                                                                                                                                                              |
| little_chick_spring <br> <img src="docs/little-chick-spring.svg" width="80px" height="30px"/>        | 0.01  |                                                                                                                                                                              |
| penguin <br> <img src="docs/penguin.svg" width="120px" height="70px"/>                               | 0.5   |                                                                                                                                                                              |
| penguin_sunglasses <br> <img src="docs/penguin-sunglasses.svg" width="120px" height="70px"/>         | 0.2   |                                                                                                                                                                              |
| penguin_kotlin <br> <img src="docs/penguin-kotlin.svg" width="120px" height="70px"/>                 | 0.01  |                                                                                                                                                                              |
| penguin_java <br> <img src="docs/penguin-java.svg" width="120px" height="70px"/>                     | 0.01  |                                                                                                                                                                              |
| penguin_js <br> <img src="docs/penguin-js.svg" width="120px" height="70px"/>                         | 0.01  |                                                                                                                                                                              |
| penguin_node <br> <img src="docs/penguin-node.svg" width="120px" height="70px"/>                     | 0.01  |                                                                                                                                                                              |
| penguin_swift <br> <img src="docs/penguin-swift.svg" width="120px" height="70px"/>                   | 0.01  |                                                                                                                                                                              |
| penguin_linux <br> <img src="docs/penguin-linux.svg" width="120px" height="70px"/>                   | 0.01  |                                                                                                                                                                              |
| penguin_spring <br> <img src="docs/penguin-spring.svg" width="120px" height="70px"/>                 | 0.01  |                                                                                                                                                                              |
| pig <br> <img src="docs/pig.svg" width="120px" height="90px"/>                                       | 0.2   |                                                                                                                                                                              |
| pig_sunglasses <br> <img src="docs/pig-sunglasses.svg" width="120px" height="90px"/>                 | 0.08  |                                                                                                                                                                              |
| pig_kotlin <br> <img src="docs/pig-kotlin.svg" width="120px" height="90px"/>                         | 0.01  |                                                                                                                                                                              |
| pig_java <br> <img src="docs/pig-java.svg" width="120px" height="90px"/>                             | 0.01  |                                                                                                                                                                              |
| pig_js <br> <img src="docs/pig-js.svg" width="120px" height="90px"/>                                 | 0.01  |                                                                                                                                                                              |
| pig_node <br> <img src="docs/pig-node.svg" width="120px" height="90px"/>                             | 0.01  |                                                                                                                                                                              |
| pig_swift <br> <img src="docs/pig-swift.svg" width="120px" height="90px"/>                           | 0.01  |                                                                                                                                                                              |
| pig_linux <br> <img src="docs/pig-linux.svg" width="120px" height="90px"/>                           | 0.01  |                                                                                                                                                                              |
| pig_spring <br> <img src="docs/pig-spring.svg" width="120px" height="90px"/>                         | 0.01  |                                                                                                                                                                              |
| slime_red <br> <img src="docs/slime-red.svg" width="50px" height="40px"/>                            | 0.1   |                                                                                                                                                                              |
| slime_red_kotlin <br> <img src="docs/slime-red-kotlin.svg" width="50px" height="40px"/>              | 0.001 |                                                                                                                                                                              |
| slime_red_java <br> <img src="docs/slime-red-java.svg" width="50px" height="40px"/>                  | 0.001 |                                                                                                                                                                              |
| slime_red_js <br> <img src="docs/slime-red-js.svg" width="50px" height="40px"/>                      | 0.001 |                                                                                                                                                                              |
| slime_red_node <br> <img src="docs/slime-red-node.svg" width="50px" height="40px"/>                  | 0.001 |                                                                                                                                                                              |
| slime_red_swift <br> <img src="docs/slime-red-swift.svg" width="50px" height="40px"/>                | 0.001 |                                                                                                                                                                              |
| slime_red_linux <br> <img src="docs/slime-red-linux.svg" width="50px" height="40px"/>                | 0.001 |                                                                                                                                                                              |
| slime_green <br> <img src="docs/slime-green.svg" width="50px" height="40px"/>                        | 0.1   |                                                                                                                                                                              |
| slime_blue <br> <img src="docs/slime-blue.svg" width="50px" height="40px"/>                          | 0.1   |                                                                                                                                                                              |

##

<div align="center">
<p> If you have any ideas or discover a bug, please report it.
<i>Contact : develxb@gmail.com</i></p>
<a href="https://hits.seeyoufarm.com"><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fdevxb%2Fgitanimals&count_bg=%23000000&title_bg=%23000000&icon=&icon_color=%23000000&title=hits&edge_flat=true"/></a>
