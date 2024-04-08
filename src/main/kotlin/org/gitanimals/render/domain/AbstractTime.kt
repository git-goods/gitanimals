package org.gitanimals.render.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
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
    val modifiedAt: Instant = createdAt,
)
