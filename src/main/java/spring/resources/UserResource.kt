package spring.resources

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import spring.entities.User
import spring.services.UserService
import java.nio.file.attribute.UserPrincipalNotFoundException

@RestController
@RequestMapping("/users")
class UserResource @Autowired constructor(val userService: UserService) {

    @GetMapping("/all")
    fun getUsers(): ResponseEntity<List<User>> {
        val users = userService.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping(value =["/test/{id}"])
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findById(id)
        return ResponseEntity.ok(user)
    }

    @ExceptionHandler(UserPrincipalNotFoundException::class)
    fun handleUserNotFoundException(ex: UserPrincipalNotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message)
    }
}