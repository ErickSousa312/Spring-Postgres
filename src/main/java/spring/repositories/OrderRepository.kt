package spring.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import spring.entities.Order

@Repository
interface OrderRepository : CrudRepository<Order, Long> {}