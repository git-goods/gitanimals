package org.gitanimals.render.domain

import jakarta.persistence.*

@Entity
@Table(name = "behavior")
class Behavior(
    @Id
    @Column(name = "id")
    val id: Long,

    @Enumerated(EnumType.STRING)
    val type: BehaviorType,

    @ManyToOne
    @JoinColumn(name = "id")
    val animal: Animal,
)
