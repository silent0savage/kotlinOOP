package org.example.education

import org.example.Person

interface Message {
    val text: String
}

interface IWriter {
    fun write() : String
}


open class Hunter<T>(override var name: String, val gunName: String, var yearExperience: T) : Person(name) {
    fun <T> display(obj: T) {
        println(obj)
    }

    override fun toString(): String {
        return "Name: $name. $name has gun $gunName, years of experience $yearExperience"
    }
}

fun main() {
    val hunter01 = Hunter<Int>("John", "rifle", 10)
    hunter01.display(obj = Int)
    println(hunter01.toString())

    val hunters1: Array<String> = arrayOf("John", "Luke", "Hanz", "Ron")
    val hunters2: Array<String> = arrayOf("Pope", "Darryl", "Hank", "Ellie", "Kara")
    val yearsExperience : Array<Int> = arrayOf(10, 15, 8, 2)

    val arr1 = getBiggestArr(arrayOf(1, 2, 3 ,4), arrayOf(5, 6, 7, 8 ,9 , 10, 11))
    arr1.forEach { item -> print("$item ") }
    println()
    val arr2 = getBiggestArr(hunters1, hunters2)
    arr2.forEach { item -> print("$item ") }
    println()
    println(getBiggest(10, 20))
    println(getBiggest("Tom", "Sam"))
    println()
    val writer = Writer("Alexandr Pushkin")
    writePoem(writer)
}

fun <T> getBiggestArr(args1: Array<T>, args2: Array<T>): Array<T> {
    if (args1.size > args2.size) return args1
    return args2
}


fun <T: Comparable<T>> getBiggest(a: T, b: T) : T{
    return if(a > b) a
    else b
}

fun <T> getBiggestNumber(a: T, b: T) : T where T: Comparable<T>, T: Number{
    return if (a > b) a
    else b
}

fun<T: Message> send(message: T){
    println(message.text)
}

class EmailMessage(override val text : String) : Message
class SmsMessage(override val text : String) : Message

fun<T: IWriter> writePoem(poem: T) {
    println(poem.write())
}

open class Writer(override var name: String): Person(name), IWriter {
    override fun write(): String {
        return "$name writes poem"
    }
}