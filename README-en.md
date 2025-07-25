<img src="./docs/logo.svg" width="30000"/>

##

<div align="center">

**English** | [한국어](README.md) | [简体中文](README-zhcn.md) | [日本語](README-ja.md)

<a href="https://hits.sh/github.com/git-goods/gitanmals/"><img alt="Hits" src="https://hits.sh/github.com/git-goods/gitanmals.svg?style=flat-square&label=visit&color=000000&labelColor=000000&logo=data%3Aimage%2Fpng%3Bbase64%2CiVBORw0KGgoAAAANSUhEUgAAAHgAAAB4CAYAAAA5ZDbSAAAACXBIWXMAAAEUAAABFAH7OeD%2FAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAJDSURBVHgB7d1BapNBGIfx%2F0ggbqp7XbTulG5yBw8QTyB6Aj1Cu%2FAAXbiueAH1AHoDFyKt7vQIoYJQBceEgttmxCnzPT4%2F%2BLLqQJMnzOLLm0kiSZIkSZIkSZIkSZIk6QqVDKR%2Byl5Gcz2rcierTNQsI6n5ktF8z%2BH68SATdS1CMzCcgeEMDGdgOAPDGRjOwHAGhjMwnIHhut2Lrqd5sL63vMzUlSzrSXabluzncQbR78OGmsX6xXmU6ds8j0XaDBPYLRrOwHAGhjMwnIHhDAxnYDgDwxkYzsBws22Hzcu9fM1%2FaPVtfZ01LWkf4O84XD9rGDYf6lsQV%2BXoZXLwvGnJ5oOWtgH%2BjsP1btFwBoYzMJyB4QwMZ2A4A8MZGM7AcAaGMzDc1nPR9STHadE%2BS9zs9dvkzbumJTl%2B1vTnWd5Pdm9lsrYffB9wiP3D5%2BTFq6YlzYEXdy%2BuqXKLhjMwnIHhDAxnYDgDwxkYzsBwBoYzMNxYB4I3urmT7N1OX%2Bcl%2BdF5JPzXn4d%2FbtKBnz68uLr6OE%2Fez9NV2byB%2BvxqgFs0nIHhDAxnYDgDwxkYzsBwBoYzMJyB4QwMN%2Bl70Ri1LuuTG22nyh%2BdbXXouIHHsFgn63KqvFs0nIHhDAxnYDgDwxkYzsBwBoYzMJyB4bxVeZl5TXZqujovq%2FwsXQajSz1N5%2F9el6o5LPue%2BK6%2FYGA4A8MZGM7AcAaGMzCcgeEMDGdgOAPDGRjOwHAGhjMwnIHhDAxnYDgDwxkYzsBwBoYzMJyB4X4DH8pLebxREVkAAAAASUVORK5CYII%3D"/></a> <a href="https://www.instagram.com/gitanimals"><img alt="Hits" src="https://hits.sh/www.instagram.com/gitanimals.svg?style=flat-square&label=Instagram&color=ff426f&labelColor=000000&logo=instagram"/></a>
<a href="https://www.instagram.com/gitanimals"><img width=88 src="https://img.shields.io/badge/Instagram-%23E4405F.svg?style=for-the-badge&logo=Instagram&logoColor=white"/></a>
</div>
<div align = "center">  
<a href="https://github.com/devxb/gitanimals">
    <img src="https://render.gitanimals.org/lines/devxb?pet-id=23" width="25%" height="100"/><img src="https://render.gitanimals.org/lines/devxb?pet-id=22" width="25%" height="100"/><img src="https://render.gitanimals.org/lines/devxb?pet-id=1" width="25%" height="100"/>
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
<br> and buy background and decorate your farm
<br>
<br>
Choose from over 50 different pets and raise them.
<br>

You can buy and manage pet or backgrounds in [hompage](https://gitanimals.org)

</h4>
<br>
<a href="https://www.gitanimals.org/">
      <img
        src="https://render.gitanimals.org/guilds/668749238833660322/draw"
        width="600"
        height="300"
        alt="gitanimals"
      />
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

You can check the available pet-ids in `https://render.gitanimals.org/users/{username}` to your
GitHub
username and requesting the API.
Enter the value corresponding to `$.personas.[].id` in the API response into pet-id.

In line mode, the total number of contributions is displayed above the pet's level. If you don't
want this, include `contribution-view=false` as a query parameter in your request.

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

### guild mode

You can create a guild, invite friends to join, and raise pets together!   
[Click to create guild](https://gitanimals.org/guilds)

<a href="https://www.gitanimals.org/">
      <img src="https://render.gitanimals.org/guilds/668749238833660322/draw" width="300" alt="gitanimals"/>
</a>

**html**

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/guilds/{guildId}/draw"/>
</a>
```

## Tips

### How to Acquire Pets

Pets can be acquired in two ways:

1. **Contributions 30 times**   
   When you accumulate 30 commits, a new pet will appear. At this point, all pets have different
   probabilities of appearing.   
   The maximum number of pets you can have is 30. If you have more than 30 pets, they will go into
   your inventory, and you can swap them with the pets displayed at any time.
2. **Purchase Pets**   
   You can buy pets sold by other users with commit points.   
   A certain amount of points will be given per commit. Alternatively, you can sell your own pets to
   earn commit points.

### Total Contributions

Total contributions represent the sum of contributions accumulated after joining GitHub.   
_New contributions may take up to 1 hour to be reflected._

### Available Pets

| name                                                                                                    | ratio | Description                                                                                                                                                                  |
|---------------------------------------------------------------------------------------------------------|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| CAPYBARA_SWIM <br> <img src = "docs/capybara-swim.svg" width="100px" height="70px"/>                    | 0.4   | Designed by [@Choi_sunwoo](https://www.behance.net/6a39a177)                                                                                                                 |
| CAPYBARA_CARROT <br> <img src = "docs/capybara-carrot.svg" width="70px" height="70px"/>                 | 0.6   | Designed by [@Choi_sunwoo](https://www.behance.net/6a39a177)                                                                                                                 |
| CAPYBARA <br> <img src = "docs/capybara.svg" width="70px" height="70px"/>                               | 0.8   | Designed by [@Choi_sunwoo](https://www.behance.net/6a39a177)                                                                                                                 |
| LITTLE_CHICK_TUBE <br> <img src = "docs/little-chick-tube.svg" width="45px" height="40px"/>             | 0.01  | 🏖️2025 Summer pet 🏖                                                                                                                                                        |
| RABBIT_TUBE <br> <img src = "docs/rabbit-tube.svg" width="60px" height="60px"/>                         | 0.01  | 🏖️2025 Summer pet 🏖                                                                                                                                                        |
| HAMSTER_TUBE <br> <img src = "docs/hamster-tube.svg" width="100px" height="60px"/>                      | 0.01  | 🏖️2025 Summer pet 🏖                                                                                                                                                        |
| SHIBA <br> <img src = "docs/shiba.svg" width="60px" height="60px"/>                                     | 0.3   |                                                                                                                                                                              |
| SHIBA_KING <br> <img src = "docs/shiba-king.svg" width="60px" height="60px"/>                           | 0.01  |                                                                                                                                                                              |
| UNICORN <br> <img src = "docs/unicorn.svg" width="60px" height="60px"/>                                 | 0.001 | Designed by [@Choi_sunwoo](https://www.behance.net/6a39a177)                                                                                                                 |
| MALTESE_KING <br> <img src = "docs/maltese-king.svg" width="60px" height="40px"/>                       | 0.01  |                                                                                                                                                                              |
| MALTESE <br> <img src = "docs/maltese.svg" width="60px" height="40px"/>                                 | 0.02  |                                                                                                                                                                              |
| SNOWMAN_MELT <br> <img src = "docs/snowman-melt.svg" width="100px" height="40px"/>                      | 0.001 | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| SNOWMAN <br> <img src = "docs/snowman.svg" width="100px" height="70px"/>                                | 0.005 | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| DESSERT_FOX_RUDOLPH <br> <img src="docs/dessert-fox-rudolph.svg" width="80px" height="70px"/>           | 0.005 | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| RABBIT_BROWN_RUDOLPH <br> <img src="docs/rabbit-brown-rudolph.svg" width="80px" height="60px"/>         | 0.007 | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| LITTLE_CHICK_SANTA <br> <img src="docs/little-chick-santa.svg" width="45px" height="30px"/>             | 0.01  | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| HAMSTER_SANTA <br> <img src = "docs/hamster-santa.svg" width="100px" height="60px"/>                    | 0.01  | 🎄2024 Christmas pet🎄                                                                                                                                                       |
| HAMSTER_JS <br> <img src = "docs/hamster-js.svg" width="100px" height="50px"/>                          | 0.01  |                                                                                                                                                                              |
| HAMSTER_KOTLIN <br> <img src = "docs/hamster-kotlin.svg" width="100px" height="50px"/>                  | 0.01  |                                                                                                                                                                              |
| HAMSTER_JAVA <br> <img src = "docs/hamster-java.svg" width="100px" height="50px"/>                      | 0.01  |                                                                                                                                                                              |
| HAMSTER_SPRING <br> <img src = "docs/hamster-spring.svg" width="100px" height="50px"/>                  | 0.01  |                                                                                                                                                                              |
| HAMSTER <br> <img src = "docs/hamster.svg" width="100px" height="50px"/>                                | 0.8   |                                                                                                                                                                              |
| SCREAM_GHOST <br> <img src = "docs/scream-ghost.svg" width="100px" height="80px"/>                      | 0.001 | 😱2024 Halloween pet😱                                                                                                                                                       |
| SCREAM <br> <img src = "docs/scream.svg" width="100px" height="80px"/>                                  | 0.005 | 😱2024 Halloween pet😱                                                                                                                                                       |
| GHOST_KING <br> <img src = "docs/ghost-king.svg" width="100px" height="70px"/>                          | 0.01  | 👻2024 Halloween pet👻                                                                                                                                                       |
| GHOST <br> <img src = "docs/ghost.svg" width="100px" height="70px"/>                                    | 0.05  | 👻2024 Halloween pet👻                                                                                                                                                       |
| SLIME_PUMPKIN_1 <br> <img src="docs/slime-pumpkin-1.svg" width="50px" height="50px"/>                   | 0.08  | 🎃2024 Halloween pet🎃                                                                                                                                                       |
| SLIME_PUMPKIN_2 <br> <img src="docs/slime-pumpkin-2.svg" width="50px" height="50px"/>                   | 0.08  | 🎃2024 Halloween pet🎃                                                                                                                                                       |
| TURTLE <br> <img src = "docs/turtle.svg" width="100px" height="80px"/>                                  | 0.03  | Designed by [@JIWOO CHOI](https://www.behance.net/sopungcjw42af)                                                                                                             |
| SLOTH_SUNGLASSES <br> <img src = "docs/sloth-sunglasses.svg" width="40px" height="80px"/>               | 0.06  |                                                                                                                                                                              |
| SLOTH_KING <br> <img src = "docs/sloth-king.svg" width="40px" height="80px"/>                           | 0.05  |                                                                                                                                                                              | 
| SLOTH <br> <img src = "docs/sloth.svg" width="40px" height="80px"/>                                     | 0.7   |                                                                                                                                                                              |
| DESSERT_FOX <br> <img src = "docs/dessert-fox.svg" width="80px" height="65px"/>                         | 0.05  |                                                                                                                                                                              |
| RABBIT <br> <img src = "docs/rabbit.svg" width="40px" height="55px"/>                                   | 0.9   |                                                                                                                                                                              |
| MOLE <br> <img src = "docs/mole.svg" width="40px" height="45px" />                                      | 0.3   |                                                                                                                                                                              |
| MOLE_GRASS <br> <img src = "docs/mole-grass.svg" width="45px" height="45px" />                          | 0.1   |                                                                                                                                                                              |
| QUOKKA <br> <img src = "docs/quokka.svg" width="23px" height="42px" />                                  | 0.3   |                                                                                                                                                                              |
| QUOKKA_LEAF <br> <img src = "docs/quokka-leaf.svg" width="23px" height="42px" />                        | 0.1   |                                                                                                                                                                              |
| QUOKKA_SUNGLASSES <br> <img src = "docs/quokka-sunglasses.svg" width="23px" height="42px" />            | 0.05  |                                                                                                                                                                              |
| FISH_MAN <br> <img src="docs/fishman.svg" width="35px" height="75px"/>                                  | 0.001 |                                                                                                                                                                              |
| FISH_MAN_GLASSES <br> <img src="docs/fishman-glasses.svg" width="35px" height="75px" />                 | 0.001 |                                                                                                                                                                              |
| flamingo <br> <img src="docs/flamingo.svg" width="50px" height="110"/>                                  | 0.08  |                                                                                                                                                                              |
| TEN_MM <br> <img src="docs/tenmm.svg" width="80px" height="90px"/>                                      | 0.00  | Character created by `10MM` donations <br> Only buy in shop <br> <a href="https://github.com/depromeet/10mm-client-web"> 10MM </a>                                           |
| goblin <br> <img src="docs/goblin.svg" width="80px" height="80px"/>                                     | 0.06  |                                                                                                                                                                              |
| goblin-bag <br> <img src="docs/goblin-bag.svg" width="100px" height="80px"/>                            | 0.03  |                                                                                                                                                                              |
| bibbi <br> <img src="docs/bbibbi.svg" width="80px" height="100px"/>                                     | 0.00  | Character created by `BIBBI` donations <br> Only buy in shop <br> <a href="https://play.google.com/store/apps/details?id=com.no5ing.bbibbi&hl=es_PY&gl=US&pli=1"> BIBBI </a> |
| cat <br> <img src="docs/cat.svg" width="50px" height="70px"/>                                           | 0.1   |                                                                                                                                                                              |
| cheese-cat <br> <img src="docs/cheese-cat.svg" width="50px" height="70px"/>                             | 0.04  |                                                                                                                                                                              |
| galchi-cat <br> <img src="docs/galchi-cat.svg" width="50px" height="70px"/>                             | 0.06  |                                                                                                                                                                              |
| white-cat <br> <img src="docs/white-cat.svg" width="50px" height="70px"/>                               | 0.04  |                                                                                                                                                                              |
| goose <br> <img src="docs/goose.svg" width="100px" height="60px"/>                                      | 1.0   |                                                                                                                                                                              |
| goose_sunglasses <br> <img src="docs/goose-sunglasses.svg" width="100px" height="60px"/>                | 0.05  |                                                                                                                                                                              |
| goose_kotlin <br> <img src="docs/goose-kotlin.svg" width="100px" height="60px"/>                        | 0.01  |                                                                                                                                                                              |
| goose_java <br> <img src="docs/goose-java.svg" width="100px" height="60px"/>                            | 0.01  |                                                                                                                                                                              |
| goose_js <br> <img src="docs/goose-js.svg" width="100px" height="60px"/>                                | 0.01  |                                                                                                                                                                              |
| goose_node <br> <img src="docs/goose-node.svg" width="100px" height="60px"/>                            | 0.01  |                                                                                                                                                                              |
| goose_swift <br> <img src="docs/goose-swift.svg" width="100px" height="60px"/>                          | 0.01  |                                                                                                                                                                              |
| goose_linux <br> <img src="docs/goose-linux.svg" width="100px" height="60px"/>                          | 0.01  |                                                                                                                                                                              |
| goose_spring <br> <img src="docs/goose-spring.svg" width="100px" height="60px"/>                        | 0.01  |                                                                                                                                                                              |
| little_chick <br> <img src="docs/little-chick.svg" width="45px" height="30px"/>                         | 0.9   |                                                                                                                                                                              |
| little_chick_suglasses <br> <img src="docs/little-chick-sunglasses.svg" width="45px" height="30px"/>    | 0.4   |                                                                                                                                                                              |
| little_chick_kotlin <br> <img src="docs/little-chick-kotlin.svg" width="80px" height="30px"/>           | 0.01  |                                                                                                                                                                              |
| little_chick_java <br> <img src="docs/little-chick-java.svg" width="80px" height="30px"/>               | 0.01  |                                                                                                                                                                              |
| little_chick_js <br> <img src="docs/little-chick-js.svg" width="80px" height="30px"/>                   | 0.01  |                                                                                                                                                                              |
| little_chick_node <br> <img src="docs/little-chick-node.svg" width="80px" height="30px"/>               | 0.01  |                                                                                                                                                                              |
| little_chick_swift <br> <img src="docs/little-chick-swift.svg" width="80px" height="30px"/>             | 0.01  |                                                                                                                                                                              |
| little_chick_linux <br> <img src="docs/little-chick-linux.svg" width="80px" height="30px"/>             | 0.01  |                                                                                                                                                                              |
| little_chick_spring <br> <img src="docs/little-chick-spring.svg" width="80px" height="30px"/>           | 0.01  |                                                                                                                                                                              |
| penguin <br> <img src="docs/penguin.svg" width="120px" height="70px"/>                                  | 0.5   |                                                                                                                                                                              |
| penguin_sunglasses <br> <img src="docs/penguin-sunglasses.svg" width="120px" height="70px"/>            | 0.2   |                                                                                                                                                                              |
| penguin_kotlin <br> <img src="docs/penguin-kotlin.svg" width="120px" height="70px"/>                    | 0.01  |                                                                                                                                                                              |
| penguin_java <br> <img src="docs/penguin-java.svg" width="120px" height="70px"/>                        | 0.01  |                                                                                                                                                                              |
| penguin_js <br> <img src="docs/penguin-js.svg" width="120px" height="70px"/>                            | 0.01  |                                                                                                                                                                              |
| penguin_node <br> <img src="docs/penguin-node.svg" width="120px" height="70px"/>                        | 0.01  |                                                                                                                                                                              |
| penguin_swift <br> <img src="docs/penguin-swift.svg" width="120px" height="70px"/>                      | 0.01  |                                                                                                                                                                              |
| penguin_linux <br> <img src="docs/penguin-linux.svg" width="120px" height="70px"/>                      | 0.01  |                                                                                                                                                                              |
| penguin_spring <br> <img src="docs/penguin-spring.svg" width="120px" height="70px"/>                    | 0.01  |                                                                                                                                                                              |
| pig <br> <img src="docs/pig.svg" width="120px" height="90px"/>                                          | 0.2   |                                                                                                                                                                              |
| pig_sunglasses <br> <img src="docs/pig-sunglasses.svg" width="120px" height="90px"/>                    | 0.08  |                                                                                                                                                                              |
| pig_kotlin <br> <img src="docs/pig-kotlin.svg" width="120px" height="90px"/>                            | 0.01  |                                                                                                                                                                              |
| pig_java <br> <img src="docs/pig-java.svg" width="120px" height="90px"/>                                | 0.01  |                                                                                                                                                                              |
| pig_js <br> <img src="docs/pig-js.svg" width="120px" height="90px"/>                                    | 0.01  |                                                                                                                                                                              |
| pig_node <br> <img src="docs/pig-node.svg" width="120px" height="90px"/>                                | 0.01  |                                                                                                                                                                              |
| pig_swift <br> <img src="docs/pig-swift.svg" width="120px" height="90px"/>                              | 0.01  |                                                                                                                                                                              |
| pig_linux <br> <img src="docs/pig-linux.svg" width="120px" height="90px"/>                              | 0.01  |                                                                                                                                                                              |
| pig_spring <br> <img src="docs/pig-spring.svg" width="120px" height="90px"/>                            | 0.01  |                                                                                                                                                                              |
| slime_red <br> <img src="docs/slime-red.svg" width="50px" height="40px"/>                               | 0.1   |                                                                                                                                                                              |
| slime_red_kotlin <br> <img src="docs/slime-red-kotlin.svg" width="50px" height="40px"/>                 | 0.001 |                                                                                                                                                                              |
| slime_red_java <br> <img src="docs/slime-red-java.svg" width="50px" height="40px"/>                     | 0.001 |                                                                                                                                                                              |
| slime_red_js <br> <img src="docs/slime-red-js.svg" width="50px" height="40px"/>                         | 0.001 |                                                                                                                                                                              |
| slime_red_node <br> <img src="docs/slime-red-node.svg" width="50px" height="40px"/>                     | 0.001 |                                                                                                                                                                              |
| slime_red_swift <br> <img src="docs/slime-red-swift.svg" width="50px" height="40px"/>                   | 0.001 |                                                                                                                                                                              |
| slime_red_linux <br> <img src="docs/slime-red-linux.svg" width="50px" height="40px"/>                   | 0.001 |                                                                                                                                                                              |
| slime_green <br> <img src="docs/slime-green.svg" width="50px" height="40px"/>                           | 0.1   |                                                                                                                                                                              |
| slime_blue <br> <img src="docs/slime-blue.svg" width="50px" height="40px"/>                             | 0.1   |                                                                                                                                                                              |
| cheese_cat_collaborator <br> <img src="docs/cheese-cat-collaborator.svg" width="100px" height="70px"/>  | 0.0   | Pet made for collaborator [devxb](https://github.com/devxb)                                                                                                                  |
| dessert_fox_collaborator <br> <img src="docs/dessert-fox-collaborator.svg" width="80px" height="65px"/> | 0.0   | Pet made for collaborator [sumi-001](https://github.com/sumi-0011)                                                                                                           |
| pig_collaborator <br> <img src="docs/pig-collaborator.svg" width="120px" height="90px"/>                | 0.0   | Pet made for collaborator [hyesungoh](https://github.com/hyesungoh)                                                                                                          |
| rabbit_collaborator <br> <img src="docs/rabbit-collaborator.svg" width="40px" height="55px"/>           | 0.0   | Pet made for collaborator [Choi jiwoo](https://www.behance.net/sopungcjw42af)                                                                                                |
| hamster_collaborator <br> <img src = "docs/hamster-collaborator.svg" width="100px" height="50px"/>      | 0.0   | Pet made for collaborator [Orchemi](https://github.com/Orchemi)                                                                                                              |
| maltese_collaborator <br> <img src = "docs/maltese-collaborator.svg" width="60px" height="40px"/>       | 0.0   | Pet made for collaborator [Choi_sunwoo]()                                                                                                                                    |
| ghost_collaborator <br> <img src = "docs/ghost-collaborator.svg" width="100px" height="70px"/>          | 0.0   | Pet made for collaborator [Han_gaeun]()                                                                                                                                      |

##

<div align="center">
<p> If you have any ideas or discover a bug, please report it.
<i>Contact : develxb@gmail.com</i></p>
</div>
