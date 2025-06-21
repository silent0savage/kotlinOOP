package org.example.education

import org.example.Person

fun main() {
    var counter1 = Counter(5)
    val counter2 = Counter(15)
    val counter1IsGreater = counter1 > counter2 // counter1.compareTo(counter2) > 0
    val counter3 : Counter = counter1 + counter2
    val counter4: Counter = 40 + counter1
    var counter5  = counter1++ // 6
    var counter6 = ++counter1 // 7
    var counter7: Counter = counter1 * counter2
    println(counter1IsGreater)
    println(counter3.value)
    println(counter4.value)

    for (c in Counter(1)..Counter(5)) {
        print("${c.value}  ")
    }

    val jetBrains = Company(arrayOf(Person("Bob"), Person("Jane"), Person("Kyle")))
    val firstPerson: Person? = jetBrains[0] // Bob
    println(firstPerson?.name)
    val fifthPerson: Person? = jetBrains[5] // null
    println(fifthPerson?.name)

    jetBrains[0] = Person("Mike")
    println(jetBrains[0]?.name) // Mike
    println(jetBrains.contains("Pope"))

    // оператор invoke в качестве фабрики объекта
    val letter1 = Letter2("Hello")
    val letter2 = letter1("World")
    val letter3 = letter2("!!!")
    println(letter3.text)
}

class Counter(var value: Int) {
    operator fun compareTo(counter: Counter) : Int {
        return this.value - counter.value
    }

    operator fun unaryMinus(): Counter {
        return Counter(-value)
    }

    operator fun inc(): Counter {
        return Counter(value + 1)
    }

    operator fun dec(): Counter {
        return Counter(value - 1)
    }

    operator fun times(counter: Counter) : Counter {
        return Counter(value * counter.value)
    }

    operator fun rem(counter: Counter) : Counter {
        return Counter(value % counter.value)
    }
    operator fun rangeTo(counter: Counter) : CounterRange {
        return CounterRange(this, counter)
    }

    override operator fun equals(counter: Any?): Boolean {
        if (counter is Counter) return this.value == counter.value
        return false
    }

    operator fun compareTo(number: Int) : Int {
        return this.value - number
    }

    operator fun plusAssign(counter: Counter) { // присваивание
        this.value += counter.value
    }
    operator fun timesAssign(counter: Counter) { // присваивание
        this.value *= counter.value
    }

    override fun hashCode(): Int {
        return value
    }
}

class CounterRange(val start: Counter, val end: Counter) {
    operator fun iterator(): Iterator<Counter> {
        return object : Iterator<Counter> {
            var current = start.value
            override fun hasNext(): Boolean = current <= end.value
            override fun next(): Counter = Counter(current++)
        }
    }
}

class Company(private val personal: Array<Person>) {
    operator fun contains(person: Person): Boolean{
        for (employee in personal) {
            if(employee.name == person.name) return true
        }
        return false
    }
    operator fun contains(personName: String): Boolean{
        for (employee in personal) {
            if(employee.name == personName) return true
        }
        return false
    }

    operator fun set(index: Int, person: Person) {
        if (index in personal.indices) {
            personal[index] = person
        }
    }

    operator fun get(index: Int) : Person? {
        if (index in personal.indices)
            return personal[index]
        return null
    }
}

class Letter2(val text: String) {
    operator fun invoke(addition: String) : Letter2 {
        return Letter2("$text $addition")
    }
}

operator fun Counter.plus(counter: Counter) : Counter {
    return  Counter(this.value + counter.value)
}

operator fun Int.plus(counter: Counter) : Counter {
    return  Counter(this + counter.value)
}
