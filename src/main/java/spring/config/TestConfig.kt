package spring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import spring.entities.Order
import spring.entities.User
import spring.repositories.OrderRepository
import spring.repositories.UserRepository
import java.time.Instant

@Configuration
@Profile("test")
class TestConfig @Autowired constructor(
    private var userRepository: UserRepository,
    private var orderRepository: OrderRepository,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val n1 = User(1,"erick", "ericksousa312@gmail.com","92992333149", "123456")
        val n3 = User(2,"jessica", "jessica@gmail.com","92992333149", "123456")

        val o1 = Order(1,  Instant.parse("2019-06-20T19:53:07Z"), n1)
        val o2 = Order(2,  Instant.parse("2019-06-20T19:53:07Z"), n3)

        userRepository.saveAll(listOf(n1, n3))
        orderRepository.saveAll(listOf(o1, o2))
    }

}