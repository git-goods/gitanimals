package org.gitanimals.render.domain

import org.springframework.data.jpa.repository.JpaRepository

interface AnimalRepository : JpaRepository<Animal, Long>
