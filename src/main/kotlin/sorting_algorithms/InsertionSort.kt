package sorting_algorithms

fun main() {
    val numbers = intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)

    // O(n^2) time complexity as we have nested loops
    fun insertionSort(array: IntArray): IntArray {
        for (index in 1 until array.size) {
            val newValue = array[index]
            var previousIndex = index - 1

            // Compare newValue to value before it
            // Shift all values over by 1 until newValue is inserted at correct spot
            while (previousIndex >= 0 && array[previousIndex] > newValue) {
                array[previousIndex + 1] = array[previousIndex]
                previousIndex--
            }

            array[previousIndex + 1] = newValue

        }
        return array
    }

    insertionSort(numbers).forEach {
        println(it)
    }
}