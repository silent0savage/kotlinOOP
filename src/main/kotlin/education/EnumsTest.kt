package org.example.education

interface IHoliday {
    fun holidayNotice()
}

fun main() {
    val day3 = Week.WEDNESDAY
    println(Months.FEBRUARY)
    println(Week.SUNDAY)
    println("Name: ${day3.name}")
    println("Ordinal: ${day3.ordinal}")

    for(day in Week.entries)
        println(day)
    println(Week.valueOf("SATURDAY"))
}

enum class Months : IHoliday {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, NOVEMBER, DECEMBER;
        override fun holidayNotice(){
            when (this) {
                JUNE, JULY, AUGUST -> println("Finally, a holidays!")
                else -> println("No holidays this month.")
            }
        }
    }


enum class Week(val value: Int, val isWeekDay: Boolean, val countWorkHours: Int) {
    MONDAY(1, true, 8), TUESDAY(2, true, 8),
    WEDNESDAY(3, true, 0), THURSDAY(4, true, 8 ),
    FRIDAY(5, true, 8), SATURDAY(6, false, 5),
    SUNDAY(7, false, 0) {

        val someValue = 5

        fun weekendNotice(countWorkHours: Int): String {
            if (countWorkHours == 0) {
                return "Today I rest!"
            }
            return "Now I work!"
        }
    }
}