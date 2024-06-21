package spring.entities
import jakarta.persistence.*
import kotlinx.serialization.Serializable

@Serializable
@Entity
@Table(name = "tb_users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0,
    @Column(name = "name")
    private var name: String? = null,
    @Column(name = "email")
    private var email: String? = null,
    @Column(name = "phone")
    private var phone: String? = null,
    @Column(name = "password")
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