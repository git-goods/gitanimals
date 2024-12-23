package org.gitanimals.guild.domain

enum class GuildIcons(
    private val imageName: String,
) {
    CAT("GUILD-1"),
    CHICK("GUILD-2"),
    FLAMINGO("GUILD-3"),
    RABBIT("GUILD-4"),
    DESSERT_FOX("GUILD-5"),
    GHOST("GUILD-6"),
    HAMSTER("GUILD-7"),
    SLIME("GUILD-8"),
    PIG("GUILD-9"),
    PENGUIN("GUILD-10"),
    ;

    fun getImagePath() = "$IMAGE_PATH_PREFIX$imageName"

    companion object {
        private const val IMAGE_PATH_PREFIX = "https://static.gitanimals.org/guilds/icons/"

        fun requireExistImagePath(imagePath: String) {
            require(entries.any { it.getImagePath() == imagePath }) {
                "Cannot find matched image by imagePath \"$imagePath\""
            }
        }
    }
}
