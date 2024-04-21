package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository

interface IdempotencyRepository : JpaRepository<Idempotency, String>
