package spring.entities

import java.io.Serializable

open class Person(
    var id: Long = 0,
    var name: String = ""
):Serializable{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        return name == other.name
    }

    override fun hashCode(): Int {
        return name?.hashCode() ?: 0
    }
}