package spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class FirstController {
    @GetMapping("/oi")
    fun getGreetings(): String {
        return "Hello, World!"
    }
}