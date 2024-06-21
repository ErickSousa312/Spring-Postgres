package spring.service

import org.springframework.stereotype.Service
import spring.entities.Person

@Service
 class ServiceKotlin {

    fun nameString(): String {
        val pessoa = Person(1,"erick")
        println(pessoa.name)
        return pessoa.name;
    }
}
