package spring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import spring.entities.User
import spring.repositories.UserRepository
import java.util.*

@Configuration
@Profile("test")
class TestConfig @Autowired constructor(val userRepository: UserRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        val n1 = User(1,"erick", "ericksousa312@gmail.com","92992333149", "123456")
        val n3 = User(2,"jessica", "jessica@gmail.com","92992333149", "123456")
        userRepository.saveAll(listOf(n1, n3))
    }

}