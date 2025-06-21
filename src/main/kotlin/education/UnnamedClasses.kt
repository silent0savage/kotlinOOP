package org.example.education
import org.example.Person


fun main() {
    val arno = object : Assasin (
        name = "Arno",
        yearOfBirth = 1769,
        game = "AC: Unity"
    ) {
        override var age: Int = 25
    }
    println(arno)
    println(arno.sayHello())
    println(arno.useBlade())

    val ezio = object : Assasin (
        name = "Ezio",
        yearOfBirth = 1459,
        game = "AC: II"
        ) {
        override var age: Int = 32
    }
    println(ezio)
    println(ezio.sayHello())
    val connor = object : Assasin (
        "Connor",
        1756,
        "AC: III"
    ) {
        override var age: Int = 21
        override fun useBlade(): String {
            return "Tomahawk instead of blade!"
        }
    }
    println(connor)
    println(connor.sayHello())
    println(connor.useBlade())
}

open class Assasin(override var name: String, val yearOfBirth: Int, val game: String) : Person("") {
    open fun useBlade() : String {
        return "Performed secret murder"
    }

    override fun toString(): String {
        return "Name: $name, year of birth day $yearOfBirth, game: $game"
    }
}
