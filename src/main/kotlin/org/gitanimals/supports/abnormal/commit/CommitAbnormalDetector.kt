package org.gitanimals.supports.abnormal.commit

import org.gitanimals.core.abnormal.AbnormalDetector
import org.gitanimals.core.abnormal.AbnormalReason
import org.gitanimals.supports.abnormal.commit.client.AbnormalGithubRestApi
import org.springframework.stereotype.Component

@Component
class CommitAbnormalDetector(
    private val githubRestApi: AbnormalGithubRestApi,
): AbnormalDetector {


    override fun <T> checkAbnormal(request: String, onSuccess: () -> T, onFailure: (AbnormalReason) -> Unit): T {
        error("")
    }
}
