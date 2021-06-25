class DynamicArray(vararg values: String) {

    val isEmpty = values.isEmpty()
    var length = values.size
        private set
    var data = Array(length) { index -> values[index] }
        private set

    private fun increaseLength() = length++
    private fun decreaseLength() = length--

    // O(n) time complexity as we're looping through values in "data"
    // I know I can just do data.plus(item) here but that's cheating 😆.
    fun add(item: String): Array<String> {
        increaseLength()
        data = Array(length) { index ->
            // Add items from current array
            if (index != length - 1) {
                data[index]
            } else {
                // Add new item
                item
            }

        }
        return data
    }

    // O(n) time complexity because we're looping through values in "data"
    fun remove(atIndex: Int): Array<String> {
        decreaseLength()
        data = Array(length) { index ->
            // Skip value being removed and shift others over by 1
            if (index >= atIndex) {
                data[index + 1]
            } else {
                // Add values at beginning of array
                data[index]
            }
        }
        return data
    }

    // O(n) time complexity because we shift values after inserting
    fun insert(item: String, atIndex: Int): Array<String> {
        increaseLength()
        data = Array(length) { index ->
            if (index < atIndex) {
                data[index]
            } else if (index == atIndex) {
                item
            } else {
                data[index - 1]
            }
        }
       return data
    }

    // O(1) - time complexity
    fun getItem(atIndex: Int): String {
        return data[atIndex]
    }

    // O(n) - Looping through array values
    fun printValues() {
        for (value in data) {
            print("$value ")
        }
    }
}


fun main() {
    val myArray = DynamicArray("one", "two", "three")
    print("Original array: ")
    myArray.printValues()
    println("\n----------------------------------------")

    println("Length: ${myArray.length}")
    println("isEmpty: ${myArray.isEmpty}")

    // Adding
    myArray.add("four")
    myArray.add("five")
    myArray.add("six")
    println("Length: ${myArray.length}")
    myArray.printValues()
    println("\n----------------------------------------")

    // Removing
    myArray.remove(2)
    println("Length: ${myArray.length}")
    myArray.printValues()
    println(" ")
    myArray.remove(1)
    println("Length: ${myArray.length}")
    myArray.printValues()
    println("\n----------------------------------------")


    // Inserting
    myArray.insert("bunny",2)
    println("Length: ${myArray.length}")
    myArray.printValues()
    println(" ")
    myArray.insert("monkey",0)
    println("Length: ${myArray.length}")
    myArray.printValues()
    println("\n----------------------------------------")

    // Lookups
    println("Item at index 2 is: ${myArray.getItem(2)}")
    println("Item at index 5 is: ${myArray.getItem(5)}")
    println("\n----------------------------------------")
}