package org.gitanimals.render.domain

enum class AnimationMode(
    private val func: (User) -> String,
) {

    FARM({ it.createFarmAnimation() }),
    ;
    fun createAnimation(user: User): String = func.invoke(user)
}
