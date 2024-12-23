package org.gitanimals.render.supports

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.core.annotation.AliasFor
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.event.RecordApplicationEvents
import kotlin.reflect.KClass

@DataJpaTest
@ContextConfiguration
@RecordApplicationEvents
@EntityScan(basePackages = ["org.gitanimals.render.domain"])
@EnableJpaRepositories(basePackages = ["org.gitanimals.render.domain"])
annotation class IntegrationTest(
    @get:AliasFor(annotation = ContextConfiguration::class, value = "classes")
    val classes: Array<KClass<*>>,
)
