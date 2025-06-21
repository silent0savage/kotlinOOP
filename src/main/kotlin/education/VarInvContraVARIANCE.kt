package org.example.education

interface Mail<T: Message>
open class Letter(val text: String)
class EmailLetter(text: String): Letter(text) {
    /*fun changeMailToEmail(obg: Mail<EmailLetter>) {
        val mailService: Mail<Letter> = obj
    } // ошибка
    fun changeMailToDefault(obj: Mail<Letter>) {
        val mailService : Mail<EmailLetter> = obj // ошибка
    }*/
}

interface covBase<out T: covSomeBase> // ковариантный интерфейс
// Класс SomeBase<Base> является базовым для Derived
open class covSomeBase(val text: String)
class covDerived(text: String): covSomeBase(text) {
    fun changeBaseToDerived(obj: covBase<covDerived>) {
        val base: covBase<covSomeBase> = obj // ошибки нет
    }
}


interface contraBase<in T: contraSomeBase> // контравариантный интерфейс
// классу contraSomeBase<contraDerived> можно присвоить значение contraSomeBase<Base>
open class contraSomeBase(val text: String)
class contraDerived(text: String): contraSomeBase(text) {
    fun changeContrBaseToDefault(obj: contraBase<contraSomeBase>) {
        val contrbase: contraBase<contraDerived> = obj
    }
}