package practice_problems

fun main() {

    /*
     * Given the index number return the value of the index
     * within the Fibonacci sequence.
     */

    // O(n) time complexity as we're iterating by 1 until we get to the index
    fun fibonacciIterative(index: Int): Int {
        var counter = 2
        var first = 1
        var second = 2
        var third = 0

        return when (index) {
            0 -> 0
            1 -> 1
            else -> {
                while (counter != index) {
                    third = first + second
                    first = second
                    second = third
                    counter++
                }
                first
                // Return the first element which is where our counter is at
            }
        }

    }

    // O(2^n) time complexity since we increase exponentially by the size of the index.
    fun fibonacciRecursive(index: Int): Int {
        return if (index < 2) index
        else fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2)
    }

    println("Fibonacci Iterative with index 0: ${fibonacciIterative(0)}") // 0
    println("Fibonacci Iterative with index 5: ${fibonacciIterative(5)}") // 5
    println("Fibonacci Iterative with index 7: ${fibonacciIterative(7)}") // 13

    println("Fibonacci Recursive with index 0: ${fibonacciRecursive(0)}") // 0
    println("Fibonacci Recursive with index 5: ${fibonacciRecursive(5)}") // 5
    println("Fibonacci Recursive with index 7: ${fibonacciRecursive(7)}") // 13
}