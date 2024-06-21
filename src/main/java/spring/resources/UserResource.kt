package spring.resources

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import spring.entities.User

@Service
class UserResource {
    fun findAll(): ResponseEntity<User> {
        val user:User = User(1L,"erick","erick@gmail.com", phone = "274545548",password = "123456")
        return ResponseEntity.ok(user)
    }
}