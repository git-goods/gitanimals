package org.gitanimals.render.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

@MappedSuperclass
abstract class AbstractTime(
    @CreatedDate
    @Column(name = "created_at")
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    @Column(name = "modified_at")
    var modifiedAt: Instant? = null,
) {

    @PrePersist
    fun prePersist() {
        modifiedAt = when (modifiedAt == null) {
            true -> createdAt
            false -> return
        }
    }
}
