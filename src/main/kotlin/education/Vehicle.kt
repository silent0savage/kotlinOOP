package education

open class Vehicle(val type: String) {
    init {
        if (type.length > 1 && type.length < 30) {
            println("Название транспорта корректно")
        }
    }
    fun move() {
        println("I'm moving")
    }
}

class Car(type: String, val model: String, var maxSpeed: Int) : Vehicle(type) {
    fun carInfo() {
        println("Car type: $type, model: $model, max speed: $maxSpeed")
    }
}
class Bicycle : Vehicle {
    val model : String
    var countOfSpeeds : Int = 0
        set(countOfSpeeds){
            if (countOfSpeeds > 0)
                field = countOfSpeeds
        }
        get() = field

    constructor(type: String, model: String, countOfSpeeds: Int) : super(type) {
        this.model = model
        this.countOfSpeeds = countOfSpeeds
    }

    fun bikeInfo() {
        println("Bicycle type: $type, model: $model, count of speeds : $countOfSpeeds")
    }
}


