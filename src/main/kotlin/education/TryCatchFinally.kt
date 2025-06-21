package org.example.education

fun main() {
    /*
    try {
        val x = 0
        val y = 4
        val result =  y / x
        println(result)
    }
    // message, stackTrace
    catch (e: Exception) {
        println(e.message)

        for (line in e.stackTrace){
            println("at $line")
        }
    }
    finally {
        println("Program has been finished with exception")
    }
     */

    try {
        val correctAge = checkAge(20)
        val incorrectAge = checkAge(-1)
        val nums = arrayOf(1, 2, 3, 4)
        println(nums[6])
    }
    catch (e: ArrayIndexOutOfBoundsException) {
        println("Out of bound of array")
    }
    catch (e: Exception) {
        println(e.message)
    }

}
fun checkAge(age: Int) : Int{
    if (age < 0 || age > 130) throw Exception("Age $age is invalid.")
    println("Age $age is valid")
    return age
}