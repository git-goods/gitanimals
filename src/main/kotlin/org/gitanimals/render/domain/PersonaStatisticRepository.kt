package org.gitanimals.render.domain

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.Instant

interface PersonaStatisticRepository : JpaRepository<Persona, Long> {

    @Query("select p from persona p where p.createdAt >= :createdAt")
    fun findAllPersonaByCreatedAtAfter(
        @Param("createdAt") createdAt: Instant,
        pageable: Pageable,
    ): Slice<Persona>
}
