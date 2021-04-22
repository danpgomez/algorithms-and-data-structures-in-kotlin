class DynamicArray<T>(
    private var values: MutableList<T>
) {
    var length: Int = values.size
    var isEmpty: Boolean = length > 0

    fun getValues() = values
    fun get(index: Int) = values[index]

    fun push(item: T): MutableList<T> {
        values[length] = item
        length++
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
    println(myArray.push(6))
}