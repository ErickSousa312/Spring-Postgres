package spring.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import spring.entities.User
import spring.repositories.UserRepository

//sealed class UserResult
//data class Success(val user: User) : UserResult()
//data class Error(val code: Int) : UserResult()
//caso eu queiria nulo
//data object Error : UserResult()

@Service
class UserService @Autowired constructor ( val userRepository: UserRepository) {

    fun findAll(): List<User> {
        val users = userRepository.findAll();
        return users.toList();
    }
    fun findById(id: Long): User? {
        val user  = userRepository.findById(id)
        return when (user.isPresent) {
            true -> user.get()
            false -> null
        }
    }

}