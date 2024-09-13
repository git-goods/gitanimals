package org.gitanimals.star.domain

import org.springframework.data.jpa.repository.JpaRepository

interface StargazersRepository : JpaRepository<Stargazer, String>
