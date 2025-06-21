package org.example.education

fun main() {
    val op = MathOperation(100)
    op put (100)
    op.printSum()

    val text = "Lorem Ipsum"
    val mCount = text wordCount 'm'
    val oCount = text wordCount 'o'
    println(mCount)
    println(oCount)

    val ivan = PersonForInfixNotation("Ivan")
    val louise = PersonForInfixNotation("Louise")
    val james = PersonForInfixNotation("James")
    ivan says "Privet"
    louise says "Bonjour"
    james says "Hello"

}
// инфиксная функция put в качестве функции расширения
infix fun MathOperation.put(amount: Int) {
    this.sum = this.sum + amount
}

infix fun String.wordCount(c: Char) : Int {
    var count = 0
    for (n in this) {
        if (n == c) count++
    }
    return  count
}


class MathOperation(var sum: Int) {
    fun printSum() = println(sum)
}

class PersonForInfixNotation(val name: String) {
    infix fun says(words: String) {
        println("$name says: ${words}")
    }
}