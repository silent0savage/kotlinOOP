package org.example.education


fun main() {
    val book = Book("1984", "George Orwell", "hardcover", 284, 5)
    book.open()
    val page180 = Book("1984", "George Orwell", "hardcover", 284, 5)
        .Page(180, "Offset")

    page180.read()
    page180.switchPage()
    page180.action()

    val page284 = Book("1984", "George Orwell", "hardcover", 284, 5)
        .Page(284, "Offset")
    page284.read()
}

interface Reader {
    var isReaded: Boolean
    interface NestedInterface
    class NestedClass
}

open class Book(
    val name: String,
    val author: String,
    val coverType: String,
    val pageCount: Int,
    private val pageSize: Int = 4,
    override var isReaded: Boolean = false
) : Reader {

    fun open() {
        println("The book is opened")
    }

    fun close() {
        println("The book is closed")
    }


    override fun toString(): String {
        return "Name is $name, author of book is $author and cover is $coverType"
    }

    inner class Page(var currentPage: Int = 1, val paperType: String) : Reader {
        private val pageSize: Int = 4

        override var isReaded: Boolean = false

        fun read() {
            println("Reading page $currentPage")
            if (currentPage >= pageCount) {
                isReaded = true
            }
            println("The book has been read: $isReaded")
        }

        fun switchPage() {
            currentPage++
            println("Current page: $currentPage")
        }

        override fun toString(): String {
            return "Page size is $pageSize and count of pages $pageCount"
        }

        fun action() {
            println("Page size from Page class $pageSize")
            println("Page size from Page class ${this@Page.pageSize}")
            println("Page size from Book class ${this@Book.pageSize}")
        }
    }
}
