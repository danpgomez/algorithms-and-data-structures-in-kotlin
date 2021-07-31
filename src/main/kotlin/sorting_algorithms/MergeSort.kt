package sorting_algorithms


fun main() {
    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var leftIndex = 0
        var rightIndex = 0
        val newList = mutableListOf<Int>()

        /*
        * Sort and merge the individual pieces of each side
        * of the large array so we end up with two sorted halves.
        * */
        while (leftIndex < left.size && rightIndex < right.size) {

            if (left[leftIndex] <= right[rightIndex]) {
                newList.add(left[leftIndex])
                leftIndex++
            } else {
                newList.add(right[rightIndex])
                rightIndex++
            }
        }

        // Add the sorted left side to the newList
        while (leftIndex < left.size) {
            newList.add(left[leftIndex])
            leftIndex++
        }

        // Add the sorted right side to the newList
        while (rightIndex < right.size) {
            newList.add(right[rightIndex])
            rightIndex++
        }

        return newList
    }

    /*
    * O(n log n) time complexity because we use Divide and Conquer
    * O(n) space complexity as we have to create individual sub-lists
    * for each element in the large list as we break it down.
    * */
    fun mergeSort(list: List<Int>): List<Int> {
        if (list.size == 1) return list

        // Split array in two
        val half = list.size / 2
        val leftSide = list.subList(0, half)
        val rightSide = list.subList(half, list.size)

        return merge(mergeSort(leftSide), mergeSort(rightSide))
    }


    val numbers = listOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    val answer = mergeSort(numbers)
    println("Answer is: $answer")
}