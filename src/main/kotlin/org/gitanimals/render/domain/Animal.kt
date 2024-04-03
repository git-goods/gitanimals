package org.gitanimals.render.domain

import jakarta.persistence.*
import org.gitanimals.render.core.AggregateRoot

@AggregateRoot
@Entity(name = "animal")
@Table(name = "animal", indexes = [Index(columnList = "user_id")])
class Animal(
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val animalType: AnimalType,

    @OneToMany(mappedBy = "animal")
    val behaviors: MutableList<Behavior>,
) : AbstractTime()
