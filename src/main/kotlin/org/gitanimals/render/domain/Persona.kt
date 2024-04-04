package org.gitanimals.render.domain

import jakarta.persistence.*

@Table(name = "persona")
@Entity(name = "persona")
class Persona(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(name = "act_type")
    @Enumerated(EnumType.STRING)
    val actType: ActType,
): AbstractTime() {

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    lateinit var user: User

    fun act(): String {
        TODO()
    }
}
