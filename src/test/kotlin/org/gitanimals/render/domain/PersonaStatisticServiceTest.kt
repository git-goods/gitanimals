package org.gitanimals.render.domain

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.gitanimals.core.instant
import org.gitanimals.render.infra.CacheConfigurer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.interceptor.SimpleKey
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration

@DataJpaTest
@EnableCaching
@ContextConfiguration(
    classes = [
        CacheConfigurer::class,
        PersonaStatisticService::class,
    ]
)
@DisplayName("PersonaStatisticService 클래스의")
@EntityScan(basePackages = ["org.gitanimals.render.domain"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.render.domain"])
internal class PersonaStatisticServiceTest(
    private val cacheManager: CacheManager,
    private val personaStatisticService: PersonaStatisticService,
    private val personaStatisticRepository: PersonaStatisticRepository,
    private val userRepository: UserRepository,
) : DescribeSpec({
    describe("getTotalPersonaCount 메소드는") {
        context("호출되면,") {
            it("전체 persona count를 응답하고 인메모리 캐시에 저장한다.") {
                val count = personaStatisticService.getTotalPersonaCount()

                count shouldNotBe null
                cacheManager.getCache("total_persona_count_cache")!![SimpleKey.EMPTY] shouldNotBe null
            }
        }
    }

    describe("getAggregatedPersonaDistributionByCreatedAtAfter 메소드는") {
        context("createdAt을 받으면,") {
            val user = userRepository.save(user())
            val createdAt = instant()

            for (i in 0..100) {
                personaStatisticRepository.save(persona(user = user))
            }

            it("createdAt보다 이후에 생성된 모든 persona의 dropRate count를 집계한다") {
                val expectedCount = 101

                val result = personaStatisticService
                    .getAggregatedPersonaDistributionByCreatedAtAfter(createdAt)

                result.sumOf { it.count } shouldBe expectedCount
            }
        }
    }
}) {
}
