package org.example.education

fun main() {
    var user1 = dataClassUser(
        1,
        "Alice",
        "1293014",
        "alP1Am@mail.ru",
        "Moscow",
        "Lenin",
        "8a"
        )

    var user2 = dataClassUser(
        2,
        "Manny",
        "1939412",
        "Man_228cool.ru",
        "St.Petersburg",
        "Pobeda",
        "100"
    )
    println(user1)
    println(user1.printer())
    print("First data class user and second data class user is equals? :   ")
    println(user1 == user2) // метод equals

    val oldUser1 = BasicUser(
        1,
        "Alice",
        "1293014",
        "alP1Am@mail.ru",
        "Moscow",
        "Lenin",
        "8a"
    )
    println(oldUser1)

    val oldUser2 = BasicUser(
        3,
        "Ivan",
        "82932856851",
        "vanyaTop219.ru",
        "Ufa",
        "Salavat-Ulayev",
        "7b"
    )
    println(oldUser2)
    print("first old user and second old user is equals?:   ")
    println(oldUser1 == oldUser2)
    val oldUser3 = BasicUser(
        3,
        "Ivan",
        "82932856851",
        "vanyaTop219.ru",
        "Ufa",
        "Salavat-Ulayev",
        "7b"
    )
    println(oldUser3)
    print("second old user and third old user is equals?:   ")
    println(oldUser2 == oldUser3)

    if (oldUser2 == oldUser3) {
        println("Hash code oldUser2 ${oldUser2.hashCode()} = hash code oldUser3 ${oldUser3.hashCode()} : " +
                "${oldUser2.hashCode() == oldUser3.hashCode()}")
    }

    val user3 = user2.copy(name = "Vasily") // синтансический метод, добавляется компилятором Kotlin
    // val oldUser4 = oldUser3.copy() нет встроенного метода copy()
    println(user3)
}

data class dataClassUser(
    val id : Int,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val city: String,
    val street: String,
    val houseNumber: String
){
    fun printer() : String{
        return ""
    }
}


class BasicUser(
    val id : Int,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val city: String,
    val street: String,
    val houseNumber: String
) {
    override fun toString(): String {
        println()
        return "basicClassUser(id=$id, name=$name, phone number=$phoneNumber, email=$email, city=$city, street=$street," +
                "house number = $houseNumber)"
    }

    // equals. По умолчанию есть в data class. Сравнивает ссылки на объекты (===), а не их содержимое
    override fun equals(other: Any?): Boolean {
        if (this === other) return true // проверка ссылки
        if (other !is BasicUser) return false // проверка типа

        // сравнение всех полей
        return id == other.id &&
                name == other.name &&
                phoneNumber == other.phoneNumber &&
                email == other.email &&
                city == other.city &&
                street == other.street &&
                houseNumber == other.houseNumber
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        return result
    }

}