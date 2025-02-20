package org.gitanimals.rank.domain

import jakarta.persistence.*

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Rank(
    @Id
    @Column(name = "id")
    val id: Long,

    @Column(name = "order", nullable = false)
    val order: Long,
) : AbstractTime()
