package spring.entities
import jakarta.persistence.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
@Entity
@Table(name = "tb_users",schema = "public")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0,
    private var name: String? = null,
    private var email: String? = null,
    private var phone: String? = null,
    private var password: String? = null,

//    @OneToMany(mappedBy = "client")
//    private var orders: List<Order?> = listOf()

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
}