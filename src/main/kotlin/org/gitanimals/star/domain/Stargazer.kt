package org.gitanimals.star.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Stargazer(
    @Id
    @Column(name = "login")
    val login: String,
)
