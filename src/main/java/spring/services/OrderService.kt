package spring.services

import spring.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import spring.entities.Order

//sealed class OrderResult
//data class Success(val user: User) : UserResult()
//data class Error(val code: Int) : UserResult()
//caso eu queiria nulo
//data object Error : UserResult()

@Service
class OrderService @Autowired constructor (
    private val orderRepository: OrderRepository
) {
    fun findAll(): List<Order> {
        val order = orderRepository.findAll();
        return order.toList();
    }
    fun findById(id: Long): Order? {
        val user  = orderRepository.findById(id)
        return when (user.isPresent) {
            true -> user.get()
            false -> null
        }
    }
}