package spring.entities
import jakarta.persistence.*

@Entity
@Table(name = "message")
class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "message")
    var message: String? = null
}