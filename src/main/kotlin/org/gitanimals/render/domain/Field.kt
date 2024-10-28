package org.gitanimals.render.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.gitanimals.render.core.IdGenerator

@Entity
@Table(name = "field")
class Field(
    @Id
    @Column(name = "id")
    private val id: Long,

    @Column(name = "field_type")
    @Enumerated(value = EnumType.STRING)
    val fieldType: FieldType,

    @Column(name = "is_choose", nullable = false)
    private var isChoose: Boolean,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
) {

    fun isChoose(): Boolean = this.isChoose

    fun choose() {
        this.isChoose = true
    }

    fun unChoose() {
        this.isChoose = false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Field) return false

        return fieldType == other.fieldType
    }

    override fun hashCode(): Int {
        return fieldType.hashCode()
    }

    fun fillBackground(): String = this.fieldType.fillBackground()

    fun loadComponent(name: String, totalCount: Long): String =
        this.fieldType.loadComponent(name, totalCount)

    fun drawBorder(): String = this.fieldType.drawBorder()

    companion object {
        fun from(user: User, fieldType: FieldType): Field {
            return Field(
                id = IdGenerator.generate(),
                fieldType = fieldType,
                isChoose = false,
                user = user,
            )
        }
    }
}
