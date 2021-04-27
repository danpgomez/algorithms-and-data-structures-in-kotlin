package practice_problems

fun main() {

    // Given an array, return the first recurring element
    val array1 = arrayListOf(2, 5, 1, 2, 3, 5, 1, 2, 4)
    val array2 = arrayListOf(2, 1, 1, 2, 3, 5, 1, 2, 4)
    val array3 = arrayListOf(2, 3, 4, 5)

    fun findFirstRecurring(array: ArrayList<Int>): String {
        var repeatingElement = 0
        val tempArray = arrayListOf<Int>()

        // O(n) time complexity but O(n) space complexity
        // because in worst case we loop and store all elements of input array.
        for (element in array) {
            if (tempArray.contains(element)) {
                repeatingElement = element
                return "$repeatingElement is the recurring element"
            }
            println("element is: $element")
            tempArray.add(element)
        }

        return "There are $repeatingElement recurring elements"
    }

    println(array1.toSet())
//    println(findFirstRecurring(array1))
//    println(findFirstRecurring(array2))
//    println(findFirstRecurring(array3))
}
