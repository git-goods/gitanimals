package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot

@AggregateRoot
@Table(name = "user")
@Entity(name = "user")
class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", unique = true, nullable = false, columnDefinition = "TEXT")
    val name: String,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    private val personas: MutableList<Persona> = mutableListOf(),
) : AbstractTime() {


}
