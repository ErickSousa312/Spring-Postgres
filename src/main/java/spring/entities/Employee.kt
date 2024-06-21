package spring.entities

import java.io.Serializable

class Employee (
    id : Long,
    name : String,
    var department : String,
):Person(id, name), Serializable