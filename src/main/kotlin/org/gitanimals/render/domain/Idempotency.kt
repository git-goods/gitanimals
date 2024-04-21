package org.gitanimals.render.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity(name="idempotency")
@Table(name="idempotency")
class Idempotency(
    @Id
    @Column(name="id")
    val id: String
)
