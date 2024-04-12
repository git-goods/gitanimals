package org.gitanimals.render.domain

enum class AnimationMode(
    private val func: (User) -> String,
) {

    FARM({ it.createFarmAnimation() }),
    LINE({ it.createLineAnimation() }),
    ;
    fun createAnimation(user: User): String = func.invoke(user)
}
