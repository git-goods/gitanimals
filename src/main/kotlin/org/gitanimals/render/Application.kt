package org.gitanimals.render

import org.rooftop.netx.meta.EnableSaga
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableSaga
@EnableJpaAuditing
@SpringBootApplication
class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}
