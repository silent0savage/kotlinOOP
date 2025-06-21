package org.example.education
import kotlin.reflect.KProperty

fun main() {
    val tom = PersonForDelegateProperties("Tom", 47)
    println(tom.name)

    tom.age = 38
    println(tom.age)

    tom.age = -150
    println(tom.age)
}

class PersonForDelegateProperties(val name : String, _age: Int) {
    var age: Int by LoggerDelegate(_age)
}

class LoggerDelegate(private var personAge: Int){
    operator fun getValue(thisRef: PersonForDelegateProperties, property: KProperty<*>): Int {
        return personAge
    }

    operator fun setValue(thisRef: PersonForDelegateProperties, property: KProperty<*>, value: Int) {
        println("Set value: $value")
        if (value > 0 && value < 130) personAge = value
    }
}
