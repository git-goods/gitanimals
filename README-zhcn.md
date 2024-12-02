<img src="./docs/logo.svg" width="30000"/>

##

<div align="center">

[English](README-en.md) | [한국어](README.md) | **简体中文**

<a href="https://hits.seeyoufarm.com"><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fdevxb%2Fgitanimals&count_bg=%23000000&title_bg=%23000000&icon=&icon_color=%23000000&title=hits&edge_flat=true"/></a>
</div>
<div align = "center">  
<a href="https://github.com/devxb/gitanimals">
    <img src="https://render.gitanimals.org/lines/devxb?pet-id=23" width="25%" height="100"/><img src="https://render.gitanimals.org/lines/devxb?pet-id=22" width="25%" height="100"/><img src="https://render.gitanimals.org/lines/devxb?pet-id=1" width="25%" height="100"/>
</a>

⭐️ 请点一下Star，这对我很重要！⭐️<br>
<i><h4><a href="https://github.com/devxb/gitanimals/stargazers">Star</a></h4></i>
</div>

<div align="center">
<h3>通过 GitHub 活动培养你的宠物！</h3> 
<h4> 您可以通过 GitHub 活动获取和饲养宠物。
<br> 当你提交30次 commits 时，你可以收养一只额外的宠物。
<br> 每次贡献都会使随机宠物的等级增加1。
<br> 你可以和其他人交换宠物。   
<br>
<br>
选择50多种不同的宠物并饲养它们！
<br>

你可以在[主页](https://gitanimals.org)购买并管理宠物。

</h4>
<br>
<a href="https://github.com/devxb/gitanimals">
    <img alt="docs/sample.svg" src="https://render.gitanimals.org/farms/devxb"/>
</a>
</div>

## 开始

您可以将以下链接复制到自己的README。

> [!IMPORTANT]   
> 请将 {username} 替换为您的用户名（如devxb）。
>
> {username} 必须是您的用户名。

### 行模式

行模式允许您指定一只宠物在设置好的宽度和高度内移动。

使用行模式时，请改用HTML，因为markdown无法设置宽度和高度。

> [!TIP]   
> **调整img的宽度和高度，以调整宠物的移动区域。**
>
> 如果将宽度设置长于高度（如宽度=1000，高度=60），宠物将在水平方向上移动非常长的距离。
>
> 相反地，如果你让宽度变短，高度变长（宽度=60，高度=1000），宠物将垂直移动很长一段距离。
>
> 如果宠物不可见，请增大img的高度。

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/lines/devxb?pet-id=1" width="300" height="120"/>
</a>

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/lines/{username}" width="1000" height="120"/>
</a>
```

如果您没有为宠物id输入任何值，则将自动设置为第一只宠物。

您可以在 `https://render.gitanimals.org/users/｛username}`
中查看可用的宠物ID，将其添加到您的GitHub用户名并请求API。输入与 `$.epersonas.[].id` 对应的值。

在行模式下，贡献总数显示在宠物等级上。如果您不希望这样，请在API中加上`contribution-view=false`。

### 农场模式

农场模式显示您的所有宠物和信息。

<a href="https://github.com/devxb/gitanimals">
    <img src = "https://render.gitanimals.org/farms/devxb" width="300"/>
</a>

```html
<a href="https://github.com/devxb/gitanimals">
  <img src="https://render.gitanimals.org/farms/{username}"/>
</a>
```

## 提示

### 如何获取宠物

宠物可通过以下两种方式获取：

1. **commits 30次**

当你累积30次 commits 时，一个新的宠物将会出现。不过，所有宠物出现的概率都不同。

最多可以养30只宠物。如果你有更多宠物，超过30只的部分会进入你的库存，你可以随时将它们设置为展示状态。

2. **购买**

你可以用 credits 购买其他用户出售的宠物。

每次 commits 都会得到一定的分数。或者，您可以将自己的宠物出售获得credits。

### 总贡献

贡献总数代表加入 GitHub 后累积的贡献总和。

_新的贡献可能需要1个小时才能显示_

### 可用宠物

| 名字                                                                                                      | 概率    | 描述                                                                                                                 |
|---------------------------------------------------------------------------------------------------------|-------|--------------------------------------------------------------------------------------------------------------------|
| SNOWMAN_MELT <br> <img src = "docs/snowman-melt.svg" width="100px" height="40px"/>                      | 0.001 | 🎄2024 Christmas pet🎄                                                                                             |
| SNOWMAN <br> <img src = "docs/snowman.svg" width="100px" height="70px"/>                                | 0.005 | 🎄2024 Christmas pet🎄                                                                                             |
| HAMSTER_JS <br> <img src = "docs/hamster-js.svg" width="100px" height="50px"/>                          | 0.01  |                                                                                                                    |
| HAMSTER_KOTLIN <br> <img src = "docs/hamster-kotlin.svg" width="100px" height="50px"/>                  | 0.01  |                                                                                                                    |
| HAMSTER_JAVA <br> <img src = "docs/hamster-java.svg" width="100px" height="50px"/>                      | 0.01  |                                                                                                                    |
| HAMSTER_SPRING <br> <img src = "docs/hamster-spring.svg" width="100px" height="50px"/>                  | 0.01  |                                                                                                                    |
| HAMSTER <br> <img src = "docs/hamster.svg" width="100px" height="50px"/>                                | 0.8   |                                                                                                                    |
| SCREAM_GHOST <br> <img src = "docs/scream-ghost.svg" width="100px" height="80px"/>                      | 0.001 | 😱2024 Halloween pet😱                                                                                             |
| SCREAM <br> <img src = "docs/scream.svg" width="100px" height="80px"/>                                  | 0.005 | 😱2024 Halloween pet😱                                                                                             |
| GHOST_KING <br> <img src = "docs/ghost-king.svg" width="100px" height="70px"/>                          | 0.01  | 👻2024 Halloween pet👻                                                                                             |
| GHOST <br> <img src = "docs/ghost.svg" width="100px" height="70px"/>                                    | 0.05  | 👻2024 Halloween pet👻                                                                                             |
| SLIME_PUMPKIN_1 <br> <img src="docs/slime-pumpkin-1.svg" width="50px" height="50px"/>                   | 0.08  | 🎃2024 Halloween pet🎃                                                                                             |
| SLIME_PUMPKIN_2 <br> <img src="docs/slime-pumpkin-2.svg" width="50px" height="50px"/>                   | 0.08  | 🎃2024 Halloween pet🎃                                                                                             |
| TURTLE <br> <img src = "docs/turtle.svg" width="100px" height="80px"/>                                  | 0.03  | 由 [@JIWOO CHOI](https://www.behance.net/sopungcjw42af) 设计                                                          |
| SLOTH_SUNGLASSES <br> <img src = "docs/sloth-sunglasses.svg" width="40px" height="80px"/>               | 0.06  |                                                                                                                    |
| SLOTH_KING <br> <img src = "docs/sloth-king.svg" width="40px" height="80px"/>                           | 0.05  |                                                                                                                    | 
| SLOTH <br> <img src = "docs/sloth.svg" width="40px" height="80px"/>                                     | 0.7   |                                                                                                                    |
| DESSERT_FOX <br> <img src = "docs/dessert-fox.svg" width="80px" height="65px"/>                         | 0.05  |                                                                                                                    |
| RABBIT <br> <img src = "docs/rabbit.svg" width="40px" height="55px"/>                                   | 0.9   |                                                                                                                    |
| MOLE <br> <img src = "docs/mole.svg" width="40px" height="45px" />                                      | 0.3   |                                                                                                                    |
| MOLE_GRASS <br> <img src = "docs/mole-grass.svg" width="45px" height="45px" />                          | 0.1   |                                                                                                                    |
| QUOKKA <br> <img src = "docs/quokka.svg" width="23px" height="42px" />                                  | 0.3   |                                                                                                                    |
| QUOKKA_LEAF <br> <img src = "docs/quokka-leaf.svg" width="23px" height="42px" />                        | 0.1   |                                                                                                                    |
| QUOKKA_SUNGLASSES <br> <img src = "docs/quokka-sunglasses.svg" width="23px" height="42px" />            | 0.05  |                                                                                                                    |
| FISH_MAN <br> <img src="docs/fishman.svg" width="35px" height="75px"/>                                  | 0.001 |                                                                                                                    |
| FISH_MAN_GLASSES <br> <img src="docs/fishman-glasses.svg" width="35px" height="75px" />                 | 0.001 |                                                                                                                    |
| flamingo <br> <img src="docs/flamingo.svg" width="50px" height="110"/>                                  | 0.08  |                                                                                                                    |
| TEN_MM <br> <img src="docs/tenmm.svg" width="80px" height="90px"/>                                      | 0.00  | [10MM](https://github.com/depromeet/10mm-client-web) 捐款创建的角色 <br> 只能从商店购买                                          |
| goblin <br> <img src="docs/goblin.svg" width="80px" height="80px"/>                                     | 0.06  |                                                                                                                    |
| goblin-bag <br> <img src="docs/goblin-bag.svg" width="100px" height="80px"/>                            | 0.03  |                                                                                                                    |
| bibbi <br> <img src="docs/bbibbi.svg" width="80px" height="100px"/>                                     | 0.00  | [BIBBI](https://play.google.com/store/apps/details?id=com.no5ing.bbibbi&hl=es_PY&gl=US&pli=1) 捐款创建的角色 <br> 只能从商店购买 |
| cat <br> <img src="docs/cat.svg" width="50px" height="70px"/>                                           | 0.1   |                                                                                                                    |
| cheese-cat <br> <img src="docs/cheese-cat.svg" width="50px" height="70px"/>                             | 0.04  |                                                                                                                    |
| galchi-cat <br> <img src="docs/galchi-cat.svg" width="50px" height="70px"/>                             | 0.06  |                                                                                                                    |
| white-cat <br> <img src="docs/white-cat.svg" width="50px" height="70px"/>                               | 0.04  |                                                                                                                    |
| goose <br> <img src="docs/goose.svg" width="100px" height="60px"/>                                      | 1.0   |                                                                                                                    |
| goose_sunglasses <br> <img src="docs/goose-sunglasses.svg" width="100px" height="60px"/>                | 0.05  |                                                                                                                    |
| goose_kotlin <br> <img src="docs/goose-kotlin.svg" width="100px" height="60px"/>                        | 0.01  |                                                                                                                    |
| goose_java <br> <img src="docs/goose-java.svg" width="100px" height="60px"/>                            | 0.01  |                                                                                                                    |
| goose_js <br> <img src="docs/goose-js.svg" width="100px" height="60px"/>                                | 0.01  |                                                                                                                    |
| goose_node <br> <img src="docs/goose-node.svg" width="100px" height="60px"/>                            | 0.01  |                                                                                                                    |
| goose_swift <br> <img src="docs/goose-swift.svg" width="100px" height="60px"/>                          | 0.01  |                                                                                                                    |
| goose_linux <br> <img src="docs/goose-linux.svg" width="100px" height="60px"/>                          | 0.01  |                                                                                                                    |
| goose_spring <br> <img src="docs/goose-spring.svg" width="100px" height="60px"/>                        | 0.01  |                                                                                                                    |
| little_chick <br> <img src="docs/little-chick.svg" width="45px" height="30px"/>                         | 0.9   |                                                                                                                    |
| little_chick_suglasses <br> <img src="docs/little-chick-sunglasses.svg" width="45px" height="30px"/>    | 0.4   |                                                                                                                    |
| little_chick_kotlin <br> <img src="docs/little-chick-kotlin.svg" width="80px" height="30px"/>           | 0.01  |                                                                                                                    |
| little_chick_java <br> <img src="docs/little-chick-java.svg" width="80px" height="30px"/>               | 0.01  |                                                                                                                    |
| little_chick_js <br> <img src="docs/little-chick-js.svg" width="80px" height="30px"/>                   | 0.01  |                                                                                                                    |
| little_chick_node <br> <img src="docs/little-chick-node.svg" width="80px" height="30px"/>               | 0.01  |                                                                                                                    |
| little_chick_swift <br> <img src="docs/little-chick-swift.svg" width="80px" height="30px"/>             | 0.01  |                                                                                                                    |
| little_chick_linux <br> <img src="docs/little-chick-linux.svg" width="80px" height="30px"/>             | 0.01  |                                                                                                                    |
| little_chick_spring <br> <img src="docs/little-chick-spring.svg" width="80px" height="30px"/>           | 0.01  |                                                                                                                    |
| penguin <br> <img src="docs/penguin.svg" width="120px" height="70px"/>                                  | 0.5   |                                                                                                                    |
| penguin_sunglasses <br> <img src="docs/penguin-sunglasses.svg" width="120px" height="70px"/>            | 0.2   |                                                                                                                    |
| penguin_kotlin <br> <img src="docs/penguin-kotlin.svg" width="120px" height="70px"/>                    | 0.01  |                                                                                                                    |
| penguin_java <br> <img src="docs/penguin-java.svg" width="120px" height="70px"/>                        | 0.01  |                                                                                                                    |
| penguin_js <br> <img src="docs/penguin-js.svg" width="120px" height="70px"/>                            | 0.01  |                                                                                                                    |
| penguin_node <br> <img src="docs/penguin-node.svg" width="120px" height="70px"/>                        | 0.01  |                                                                                                                    |
| penguin_swift <br> <img src="docs/penguin-swift.svg" width="120px" height="70px"/>                      | 0.01  |                                                                                                                    |
| penguin_linux <br> <img src="docs/penguin-linux.svg" width="120px" height="70px"/>                      | 0.01  |                                                                                                                    |
| penguin_spring <br> <img src="docs/penguin-spring.svg" width="120px" height="70px"/>                    | 0.01  |                                                                                                                    |
| pig <br> <img src="docs/pig.svg" width="120px" height="90px"/>                                          | 0.2   |                                                                                                                    |
| pig_sunglasses <br> <img src="docs/pig-sunglasses.svg" width="120px" height="90px"/>                    | 0.08  |                                                                                                                    |
| pig_kotlin <br> <img src="docs/pig-kotlin.svg" width="120px" height="90px"/>                            | 0.01  |                                                                                                                    |
| pig_java <br> <img src="docs/pig-java.svg" width="120px" height="90px"/>                                | 0.01  |                                                                                                                    |
| pig_js <br> <img src="docs/pig-js.svg" width="120px" height="90px"/>                                    | 0.01  |                                                                                                                    |
| pig_node <br> <img src="docs/pig-node.svg" width="120px" height="90px"/>                                | 0.01  |                                                                                                                    |
| pig_swift <br> <img src="docs/pig-swift.svg" width="120px" height="90px"/>                              | 0.01  |                                                                                                                    |
| pig_linux <br> <img src="docs/pig-linux.svg" width="120px" height="90px"/>                              | 0.01  |                                                                                                                    |
| pig_spring <br> <img src="docs/pig-spring.svg" width="120px" height="90px"/>                            | 0.01  |                                                                                                                    |
| slime_red <br> <img src="docs/slime-red.svg" width="50px" height="40px"/>                               | 0.1   |                                                                                                                    |
| slime_red_kotlin <br> <img src="docs/slime-red-kotlin.svg" width="50px" height="40px"/>                 | 0.001 |                                                                                                                    |
| slime_red_java <br> <img src="docs/slime-red-java.svg" width="50px" height="40px"/>                     | 0.001 |                                                                                                                    |
| slime_red_js <br> <img src="docs/slime-red-js.svg" width="50px" height="40px"/>                         | 0.001 |                                                                                                                    |
| slime_red_node <br> <img src="docs/slime-red-node.svg" width="50px" height="40px"/>                     | 0.001 |                                                                                                                    |
| slime_red_swift <br> <img src="docs/slime-red-swift.svg" width="50px" height="40px"/>                   | 0.001 |                                                                                                                    |
| slime_red_linux <br> <img src="docs/slime-red-linux.svg" width="50px" height="40px"/>                   | 0.001 |                                                                                                                    |
| slime_green <br> <img src="docs/slime-green.svg" width="50px" height="40px"/>                           | 0.1   |                                                                                                                    |
| slime_blue <br> <img src="docs/slime-blue.svg" width="50px" height="40px"/>                             | 0.1   |                                                                                                                    |
| cheese_cat_collaborator <br> <img src="docs/cheese-cat-collaborator.svg" width="100px" height="70px"/>  | 0.0   | 协作者 [devxb](https://github.com/devxb) 制作                                                                           |
| dessert_fox_collaborator <br> <img src="docs/dessert-fox-collaborator.svg" width="80px" height="65px"/> | 0.0   | 协作者 [sumi-001](https://github.com/sumi-0011) 制作                                                                    |
| pig_collaborator <br> <img src="docs/pig-collaborator.svg" width="120px" height="90px"/>                | 0.0   | 协作者 [hyesungoh](https://github.com/hyesungoh) 制作                                                                   |
| rabbit_collaborator <br> <img src="docs/rabbit-collaborator.svg" width="40px" height="55px"/>           | 0.0   | 协作者 [Choi jiwoo](https://www.behance.net/sopungcjw42af) 制作                                                         |

##

<div align="center">
<p> 如果你发现了bug，或者有任何想法，欢迎联系我们！<br/>
<i>联系方式： develxb@gmail.com</i></p>
</div>
