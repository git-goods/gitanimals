package org.gitanimals.guild.supports

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.gitanimals.core.PersonaType
import org.gitanimals.guild.app.IdentityApi
import org.gitanimals.guild.app.RenderApi
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class MockApiConfiguration {

    @Bean
    fun identityApi(): IdentityApi = mockk<IdentityApi>().apply {
        val api = this
        every { api.increasePoint(any(), any(), any(), any()) } just Runs
        every { api.decreasePoint(any(), any(), any(), any()) } just Runs
        every { api.getUserByToken(any()) } returns identityUserResponse
    }

    @Bean
    fun renderApi(): RenderApi = mockk<RenderApi>().apply {
        val api = this
        every { api.getUserByName(any()) } returns renderUserResponse
    }

    companion object {
        val identityUserResponse = IdentityApi.UserResponse(
            id = "1",
            username = "devxb",
            points = "30000",
            profileImage = "https://gitanimals.org"
        )

        val renderUserResponse = RenderApi.UserResponse(
            id = "2",
            name = "devxb",
            totalContributions = "9999",
            personas = listOf(
                RenderApi.UserResponse.PersonaResponse(
                    id = "3",
                    level = "99",
                    type = PersonaType.GOOSE,
                ),
                RenderApi.UserResponse.PersonaResponse(
                    id = "4",
                    level = "98",
                    type = PersonaType.GOOSE,
                ),
            )
        )
    }
}
