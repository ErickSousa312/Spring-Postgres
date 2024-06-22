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
import spring.entities.Order
import spring.entities.User
import spring.services.OrderService
import spring.services.UserService
import java.nio.file.attribute.UserPrincipalNotFoundException

@RestController
@RequestMapping("/orders")
class OrderResource @Autowired constructor(val orderService: OrderService) {

    @GetMapping("/all")
    fun getUsers(): ResponseEntity<List<Order>> {
        val users = orderService.findAll()
        return ResponseEntity.ok(users)
    }

    @GetMapping(value =["/test/{id}"])
    fun getUserById(@PathVariable id: Long): ResponseEntity<Order?> {
        println(id)
        val order = orderService.findById(id)
        println(order)
        return ResponseEntity.ok(order)
    }

    @ExceptionHandler(UserPrincipalNotFoundException::class)
    fun handleUserNotFoundException(ex: UserPrincipalNotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message)
    }
}