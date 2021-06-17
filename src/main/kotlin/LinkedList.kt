data class Node<T>(
    var value: T,
    var next: Node<T>? = null
)

class LinkedList<T>(private var head: Node<T>? = null) {

    var tail: Node<T>? = head
    var length: Int = 0
        private set

    // O(1) since we keep a reference to the tail
    // and don't need to traverse the list
    fun append(item: Node<T>) {
        if (head == null) {
            head = item
            tail = head
        } else {
            tail?.next = item
            tail = tail?.next
        }
        length++
    }

    // O(1) time complexity
    fun prepend(item: Node<T>) {
        if (head == null) {
            head = item
            tail = head
        } else {
            item.next = head
            head = item
        }
        length++
    }

    fun insert(item: Node<T>, index: Int) {
        // Ensure index is valid
        if (index >= length) {
            append(item)
            return
        }

        val leader = this.traverseToIndex(index -1)
        val holdingNode = leader?.next
        leader?.next = item
        item.next = holdingNode
        length++
    }

    private fun traverseToIndex(index: Int): Node<T>? {
        var counter = 0
        var current = head

        while (counter !== index) {
            current = current?.next
            counter++
        }

        return current
    }

    fun remove(index: Int) {
        // Ensure index is valid
        if (index >= length || index < 0) {
            println("Error: index out of bounds. No item removed")
            return
        }
        val previous = this.traverseToIndex(index - 1)
        val itemToRemove = previous?.next
        val after = itemToRemove?.next
        previous?.next = after
        length--
    }

    fun reverse() {
        // TODO: Implement
    }

    // O(n) as we're looping through all items
    fun printList() {
        var next = head?.next
        print("${head?.value}")
        while (next != null) {
            print(" -> ${next.value}")
            next = next.next
        }
        print(" -> $next")
    }
}

fun main() {
    val nodeOne = Node("one")
    val myLinkedList = LinkedList(nodeOne)
    myLinkedList.printList()
    println("\n---------------------------------")

    val nodeTwo = Node("two")
    val nodeThree = Node("three")
    val nodeFour = Node("four")
    myLinkedList.append(nodeTwo)
    myLinkedList.append(nodeThree)
    myLinkedList.append(nodeFour)
    myLinkedList.printList()
    println("\n---------------------------------")

    val anotherList = LinkedList<Int>()
    val intNodeOne = Node(1)
    val intNodeTwo = Node(2)
    val intNodeThree = Node(3)
    anotherList.append(intNodeOne)
    anotherList.append(intNodeTwo)
    anotherList.append(intNodeThree)
    anotherList.printList()
    println("\n---------------------------------")

    val emojiList = LinkedList<String>()
    val emojiOne = Node("🦄")
    val emojiTwo = Node("🦁")
    val emojiThree = Node("🐬")
    emojiList.prepend(emojiOne)
    emojiList.printList()
    println("\n---------------------------------")
    emojiList.prepend(emojiTwo)
    emojiList.printList()
    println("\n---------------------------------")
    emojiList.prepend(emojiThree)
    emojiList.printList()
    println("\n---------------------------------")
    emojiList.printList()
    println("\n---------------------------------")

    val emojiFour = Node("🐷")
    emojiList.insert(emojiFour, 3)
    emojiList.printList()
    println("\n---------------------------------")

    val emojiFive = Node("🐨")
    emojiList.insert(emojiFive, 1)
    emojiList.printList()
    println("\n---------------------------------")

    emojiList.remove(1)
    println("length is: ${emojiList.length}")
    emojiList.printList()
    println("\n---------------------------------")

    emojiList.remove(3)
    println("length is: ${emojiList.length}")
    emojiList.printList()
    println("\n---------------------------------")

    emojiList.remove(7)
    println("length is: ${emojiList.length}")
    emojiList.printList()
    println("\n---------------------------------")

    emojiList.remove(-1)
    println("length is: ${emojiList.length}")
    emojiList.printList()
    println("\n---------------------------------")
}
