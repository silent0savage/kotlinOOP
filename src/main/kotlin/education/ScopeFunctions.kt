package org.example.education

fun main() {
    val sam = PersonForScopeFunctions("Sam", "sam@gmail.com")
    sam.email?.let { println("Email: $it") } // let срабатывает если значение свойства != null
    val tom = PersonForScopeFunctions("Tom", null)
    tom.email?.let {  println("Email: $it") }
    val emailOfTom = with(tom) { // with позволяет выполнить над объектом операции как единое целое
        if(email == null)
            email = "${name.lowercase()}@gmail.com"
        email
    }
    println(emailOfTom)

    val mat = PersonForScopeFunctions("Mat", null)
    val emailOfMat = mat.run { // run похожа на with, только run реализована как функция расширения
        if(email==null)
            email = "${name.lowercase()}@gmail.com"
        email
    }
    println(emailOfMat)

    val validationResult = mat.email?.run {"valid"} ?: "Underfined" // проверка на валидность email с помощью run
    println(validationResult)

    val greetingText = run {"hello WORLD!"} // run в качестве lambda функции
    println(greetingText)
    run{println("run function")}

    val rish = PersonForScopeFunctions("Rina", null)
    rish.apply {
        if (email == null) email = "${name.lowercase()}@gmail.com"
    }
    println(rish.email)

    val Luke = EmployeeForScopeFunctions()
    Luke.name("Luke")
    Luke.age(26)
    Luke.company("Google")
    println("${Luke.name} (${Luke.age}) - ${Luke.company}")

    val Amanda = PersonForScopeFunctions("Amanda", null) // то же самое что и apply, только доступ к объекту, через it
    Amanda.also {
        if (it.email == null)
            it.email = "${it.name.lowercase()}@gmail.com"
    }
    println(Amanda.email)
}

data class PersonForScopeFunctions(val name: String, var email: String?) // Построение объекта с помощью apply, в виде реализации паттерна Строитель
data class EmployeeForScopeFunctions(var name: String = "", var age: Int = 0, var company: String = "") {
    fun name(_name: String): EmployeeForScopeFunctions = apply { name = _name }
    fun age(_age: Int): EmployeeForScopeFunctions = apply { age = _age }
    fun company(_company: String) : EmployeeForScopeFunctions = apply {company = _company}
}

