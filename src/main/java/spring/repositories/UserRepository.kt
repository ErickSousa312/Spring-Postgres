package spring.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import spring.entities.User

@Repository
interface UserRepository: CrudRepository<User, Long> {
}