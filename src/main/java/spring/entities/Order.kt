package spring.entities

import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer
import jakarta.persistence.*
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

import kotlinx.serialization.modules.SerializersModule
import java.time.Instant
@Serializable
@Entity
@Table(name = "tb_order", schema = "public")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Serializable(with = InstantIso8601Serializer::class)
    @Contextual
    var moment: Instant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    var client: User? = null
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        val result = id?.hashCode() ?: 0
        return result
    }


}

public object InstantIso8601Serializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("kotlinx.datetime.Instant", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Instant =
        Instant.parse(decoder.decodeString())

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeString(value.toString())
    }

}