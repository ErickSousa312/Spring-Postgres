package spring.entities

import jakarta.persistence.*
import java.io.Serializable
import java.time.Instant

@Entity
@Table(name = "tb_order", schema = "public")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var moment: Instant? = null,

    @ManyToOne()
    @JoinColumn(name = "client_id")
    var client: User? = null

):Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false
        if (moment != other.moment) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (moment?.hashCode() ?: 0)
        return result
    }
}