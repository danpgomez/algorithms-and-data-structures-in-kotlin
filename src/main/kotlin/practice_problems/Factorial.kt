package practice_problems

fun main() {

    // Both of these functions run at O(n) time complexity since they have to
    // either loop through or make recursive calls "n" times.

    fun factorialIterative(number: Int): Int {
        var n = number - 1
        var answer = number
        while (n > 0) {
            answer *= n
            n--
        }
        return answer
    }

    fun factorialRecursive(number: Int): Int {
        if (number == 2) {
            return 2
        }
        return number * factorialRecursive(number - 1)
    }

    println("Factorial of 5 Iterative: ${factorialIterative(5)}")
    println("Factorial of 7 Iterative: ${factorialIterative(7)}")
    println("Factorial of 9 Iterative: ${factorialIterative(9)}")

    println("Factorial of 5 Recursive: ${factorialRecursive(5)}")
    println("Factorial of 7 Recursive: ${factorialRecursive(7)}")
    println("Factorial of 9 Recursive: ${factorialRecursive(9)}")

}