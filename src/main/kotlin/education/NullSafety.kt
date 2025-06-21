package org.example.education

import org.example.Person

fun main() {
     // val number: Int = null
     // println(number) // ошибка
    val number: Int? = null
    println(number)
    val name: String? = "Tom"
    val message: String = name ?: "Underfined"
    var age: Int? = 23
    var userAge: Int = age ?: 0

    var currentMessage : String? = "Hello, my friend Pedro!"
    var length: Int? = currentMessage?.length ?: 0
    println(length)

    val tom: Person? = Person("Tom")
    val tomName: String? = tom?.name?.uppercase()
    val id: String = name!!
    println(tomName)
    println(id)

    val papich: String? = "Vitaly"
    papich?.let { // if name != null
        println(it.length)
    }

    val nonNullName = requireNotNull(papich) {"Name = null"}
    println(nonNullName.length)
}
