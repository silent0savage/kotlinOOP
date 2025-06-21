package org.example
import education.Vehicle as veh
import education.Car
import education.Bicycle

class App{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val person = Person("Almaz")
            val vehicle = veh("Car")
            val car = Car("truck", "Ford Ranger", 180)
            val mountBicycle = Bicycle("mountain", "Stels", 9)
            val commonBicycle= Bicycle("common", "IK", 0)
            val driver = Driver("Driver", 12345678, 12)
            vehicle.move()
            car.carInfo()
            mountBicycle.bikeInfo()
            commonBicycle.bikeInfo()

            person.age = 131
            person.printInfo()
            driver.driverExp(12)
            driver.driverInfo()

            val tom = createPerson("Tom", "JetBrains")
            println(tom.name)
            // println(tom.company)
        }

        private inline fun createPerson(_name: String, _comp: String) = object : Person(_name) {
            val company = _comp
        }
    }
}


open class Person(open var name: String) {
    open var age: Int = 1
        set(value) {
            if (value > 0 && value < 130) {
                field = value
            } else { println("Incorrect age, name: $name")}
        }
    open fun sayHello() = println("Hi, my name is $name, my age is $age")
    fun printInfo() = println("Name: $name, age: $age")
}

class Driver (name: String, val licenceId : Int, var experience : Int) : Person(name) {
    override var age : Int = 35
    fun driverExp(exp: Int) {
        if (exp > 20) {
            println("You are an experienced driver!")
        } else {println("You're new")}
    }
    fun driverInfo() {
        println("name : $name, licence id : $licenceId, age: $age, driver year's experience : $experience")
    }
}








