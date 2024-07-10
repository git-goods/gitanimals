package org.gitanimals.render

import org.rooftop.netx.meta.EnableSaga
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.retry.annotation.EnableRetry

@EnableSaga
@EnableRetry
@SpringBootApplication
class TestRoot
