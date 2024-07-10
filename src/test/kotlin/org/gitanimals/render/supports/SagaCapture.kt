package org.gitanimals.render.supports

import io.kotest.matchers.equals.shouldBeEqual
import org.rooftop.netx.api.*
import org.rooftop.netx.meta.SagaHandler

@SagaHandler
class SagaCapture {

    val storage = mutableMapOf<String, Int>()

    fun clear() {
        storage.clear()
    }

    fun startCountShouldBe(count: Int) {
        (storage["start"] ?: 0) shouldBeEqual count
    }

    fun joinCountShouldBe(count: Int) {
        (storage["join"] ?: 0) shouldBeEqual count
    }

    fun commitCountShouldBe(count: Int) {
        (storage["commit"] ?: 0) shouldBeEqual count
    }

    fun rollbackCountShouldBe(count: Int) {
        (storage["rollback"] ?: 0) shouldBeEqual count
    }

    @SagaStartListener(successWith = SuccessWith.END)
    fun captureStart(startEvent: SagaStartEvent) {
        storage["start"] = (storage["start"] ?: 0) + 1
    }

    @SagaJoinListener(successWith = SuccessWith.END)
    fun captureJoin(joinEvent: SagaJoinEvent) {
        storage["join"] = (storage["join"] ?: 0) + 1
    }

    @SagaCommitListener
    fun captureCommit(commitEvent: SagaCommitEvent) {
        storage["commit"] = (storage["commit"] ?: 0) + 1
    }

    @SagaRollbackListener
    fun captureRollback(rollbackEvent: SagaRollbackEvent) {
        storage["rollback"] = (storage["rollback"] ?: 0) + 1
    }
}
