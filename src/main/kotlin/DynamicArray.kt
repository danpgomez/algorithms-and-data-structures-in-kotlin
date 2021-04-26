class DynamicArray<T>(
    private var values: MutableList<T>
) {
    var length: Int = values.size
        private set
    var isEmpty: Boolean = length > 0
        private set

    fun getValues() = values

    // O(1) time complexity
    fun lookup(index: Int) = values[index]

    // O(1) time complexity
    fun push(item: T): MutableList<T> {
        values.add(length, item)
        length++
        return values
    }

    // O(n) time complexity because we have to shift remaining items
    fun remove(item: T): MutableList<T> {
        values.remove(item)
        length--
        return values
    }
}

fun <T> mutableDynamicArray(vararg values: T): DynamicArray<T> {
    val result = mutableListOf<T>()
    for (item in values) {
        result.add(item)
    }
    return DynamicArray(result)
}

fun main() {
    val myArray = mutableDynamicArray(1, 2, 3)
    myArray.push(6)
    println(myArray.lookup(2))
    println(myArray.getValues())
    println(myArray.isEmpty)
    myArray.remove(3)
    println(myArray.getValues())
}