package org.gitanimals.render.app

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import org.gitanimals.core.PersonaType
import org.gitanimals.core.ProfileIdentifier
import org.gitanimals.render.app.response.AssetsResponse
import org.gitanimals.render.domain.UserService
import org.springframework.stereotype.Component

@Component
class AssetsFacade(
    private val userService: UserService,
    private val identityApi: IdentityApi,
) {

    private val cache: Cache<PersonaType, AssetsResponse> = Caffeine.newBuilder()
        .maximumSize(100)
        .build()

    fun findAllAssets(
        token: String,
        personaType: PersonaType,
    ): AssetsResponse {
        if (ProfileIdentifier.isLocal()) {
            return AssetsResponse.createSvg(PersonaEmotionAssets.from(personaType))
        }

        val identityUser = identityApi.getUserByToken(token)
        val renderUser = userService.getUserByName(name = identityUser.username)

        require(renderUser.havePersona(personaType)) {
            "personaType에 해당하는 Persona가 존재하지 않습니다."
        }

        return cache.get(personaType) {
            AssetsResponse.createSvg(PersonaEmotionAssets.from(personaType))
        }
    }

    fun findAssetSvg(
        token: String,
        personaType: PersonaType,
        emotion: String,
    ): String {
        if (!ProfileIdentifier.isLocal()) {
            val identityUser = identityApi.getUserByToken(token)
            val renderUser = userService.getUserByName(name = identityUser.username)

            require(renderUser.havePersona(personaType)) {
                "personaType에 해당하는 Persona가 존재하지 않습니다."
            }
        }

        return PersonaEmotionAssets.from(personaType).getAsset(emotion)
    }
}
