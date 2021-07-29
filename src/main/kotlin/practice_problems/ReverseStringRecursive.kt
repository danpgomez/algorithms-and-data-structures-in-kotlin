package practice_problems

import kotlin.reflect.typeOf

fun main() {

    fun reverseStringRecursive(str: String): String {
        var reversed = ""
        return if (str.length == 1) str
        else {
            reversed += str[str.length - 1] + reverseStringRecursive(str.substring(0, str.length - 1))
            reversed
        }
    }

    fun reverseStringIteratively(str: String): String {
        var newString = ""
        for (index in str.length - 1 downTo 0) {
           newString += str[index]
        }
        return newString
    }

    println(reverseStringRecursive("My name is Daniel"))
    println(reverseStringIteratively("I love Super Smash Bros"))

}