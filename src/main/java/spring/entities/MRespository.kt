package spring.entities

import org.springframework.data.repository.CrudRepository

interface MRespository: CrudRepository<Message, Long> {
}