package sorting_algorithms

fun main() {
    val numbers = arrayOf(12, 37, 1, 23, 347, 0, 50, 7)

    // O(n^2) time complexity as we have nested loops
    fun selectionSort(array: Array<Int>): Array<Int> {
        for (i in array.indices) {
            var min = i
            val temp = array[i]

            for (j in i + 1 until array.size) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            array[i] = array[min]
            array[min] = temp
        }
        return array
    }

    selectionSort(numbers).forEach {
        println(it)
    }
}