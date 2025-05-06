package org.gitanimals.render.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
class UserAuthInfo(

    @Enumerated(EnumType.STRING)
    @Column(name = "entry_point", nullable = true)
    private val entryPoint: EntryPoint,

    @Column(name = "authentication_id", nullable = true)
    private val authenticationId: String,
)
