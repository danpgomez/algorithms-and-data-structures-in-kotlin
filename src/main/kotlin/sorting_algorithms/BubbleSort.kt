package sorting_algorithms

fun main() {
    val numbers = arrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    // O(n^2) time complexity since we have nested loops
    fun bubbleSort(array: Array<Int>): Array<Int> {
        for (number in array) {
            for (i in 0 until array.size - 1) {
                if (array[i] > array[i + 1]) {
                    val temp = array[i]
                    array[i] = array[i + 1]
                    array[i + 1] = temp
                }
            }
        }
        return array
    }

    bubbleSort(numbers).forEach {
        println(it)
    }
}