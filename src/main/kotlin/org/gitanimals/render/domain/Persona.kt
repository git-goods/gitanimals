package org.gitanimals.render.domain

import jakarta.persistence.*

@MappedSuperclass
abstract class Persona(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
) {

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    lateinit var user: User

    abstract fun act(): String
}
