package org.gitanimals.core.abnormal

interface AbnormalDetector {

    fun <T> checkAbnormal(request: String, onSuccess: () -> T, onFailure: (AbnormalReason) -> Unit): T
}

data class AbnormalReason(
    val type: AbnormalType,
    val reason: String,
)

enum class AbnormalType {
    REPEAT,
    SUCCESS,
    ;
}

