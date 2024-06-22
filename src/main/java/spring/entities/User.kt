package spring.entities
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import kotlinx.serialization.*
import kotlinx.serialization.Transient
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import java.time.Instant

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
    @JsonIgnore
    private var password: String? = null,

    @Transient
    @Serializable(with = OrderListSerializer::class)
    @OneToMany(mappedBy = "client", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var orders: List<Order>? = mutableListOf()

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

object OrderListSerializer : KSerializer<List<Order>?> {
    override val descriptor = ListSerializer(Order.serializer()).descriptor

    override fun serialize(encoder: Encoder, value: List<Order>?) {
        encoder.encodeSerializableValue(ListSerializer(Order.serializer()), value ?: emptyList())
    }

    override fun deserialize(decoder: Decoder): List<Order>? {
        return decoder.decodeSerializableValue(ListSerializer(Order.serializer()).nullable)
    }
}