package org.gitanimals.render.controller.filter

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldExistInOrder
import io.restassured.RestAssured
import io.restassured.http.Header
import org.gitanimals.render.controller.users
import org.gitanimals.render.domain.User
import org.gitanimals.render.domain.UserRepository
import org.gitanimals.render.supports.RedisContainer
import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(
    classes = [
        RedisContainer::class
    ]
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Cors 적용 테스트의")
internal class CorsFilterTest(
    @LocalServerPort private val port: Int,
    private val userRepository: UserRepository,
) : DescribeSpec({

    beforeSpec {
        RestAssured.port = port
    }

    afterEach { userRepository.deleteAll() }

    describe("/users/{username} api는") {
        context("호출되면, ") {
            it("cors 허용 header들을 추가해서 반환한다.") {
                val user = userRepository.saveAndFlush(user)

                val response = users(user.name)

                response.headers().shouldExistInOrder(
                    listOf(
                        { it == Header("Access-Control-Allow-Origin", "*") },
                        { it == Header("Access-Control-Allow-Methods", "*") },
                        { it == Header("Access-Control-Max-Age", "3600") },
                        {
                            it == Header(
                                "Access-Control-Allow-Headers",
                                "Origin, X-Requested-With, Content-Type, Accept, Authorization, Api-Version"
                            )
                        }
                    )
                )
            }
        }
    }

}) {

    private companion object {
        private val user = User.newUser("devxb", mutableMapOf(2024 to 1000))
    }
}
