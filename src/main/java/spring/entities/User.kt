package spring.entities

import kotlinx.serialization.Serializable

@Serializable
data class User(
    private var id: Long = 0,
    private var name: String? = null,
    private var email: String? = null,
    private var phone: String? = null,
    private var password: String? = null,
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as User
        return name == other.name
    }
    override fun hashCode(): Int {
        return name?.hashCode() ?: 0
    }
//    se quiser mais manual
//    companion object {
//        const val serialVersionUID: Long = 1L
//    }
}