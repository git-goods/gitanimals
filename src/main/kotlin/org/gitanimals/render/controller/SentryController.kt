package org.gitanimals.render.controller

import io.sentry.Sentry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SentryController {

    @GetMapping("/sentries")
    fun sentryCall() {
        Sentry.captureException(IllegalArgumentException("This is test."))
    }
}
