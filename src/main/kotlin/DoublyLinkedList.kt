data class Node<T>(
    var value: T,
    var next: Node<T>? = null,
    var previous: Node<T>? = null
)

class DoublyLinkedList<T>(private var head: Node<T>? = null) {

    private var tail: Node<T>? = head
    var length: Int = 0
        private set

    // O(1) since we keep a reference to the tail
    // and don't need to traverse the list
    fun append(newItem: Node<T>) {
        if (head == null) {
            head = newItem
            tail = head
        } else {
            newItem.previous = tail
            tail?.next = newItem
            tail = tail?.next
        }
        length++
    }

    // O(1) time complexity
    fun prepend(newItem: Node<T>) {
        if (head == null) {
            head = newItem
            tail = head
        } else {
            head?.previous = newItem
            newItem.next = head
            head = newItem
        }
        length++
    }

    // O(n) because we have to traverse to index
    fun insert(newItem: Node<T>, index: Int) {
        // Ensure index is valid
        if (index >= length) {
            append(newItem)
            return
        }

        // Get reference to nodes before and after desired index
        val leadingNode = this.traverseToIndex(index - 1)
        val followingNode = leadingNode?.next

        // Link surrounding nodes to new node
        leadingNode?.next = newItem
        followingNode?.previous = newItem

        // Link new node to surrounding nodes
        newItem.next = followingNode
        newItem.previous = leadingNode
        length++
    }

    private fun traverseToIndex(index: Int): Node<T>? {
        var counter = 0
        var current = head

        while (counter != index) {
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

        // Get references to unwanted and surrounding nodes
        val leadingNode = this.traverseToIndex(index - 1)
        val unwantedNode = leadingNode?.next
        val followingNode = unwantedNode?.next

        // Link surrounding nodes to each other
        leadingNode?.next = followingNode
        followingNode?.previous = leadingNode
        length--
    }

    fun reverse() {
        // TODO: Implement
    }

    // O(n) as we're looping through all items
    fun printList() {
        var next = head?.next
        print("[${head?.previous?.value}|${head?.value}|${head?.next?.value}]")
        while (next != null) {
            print("--[${next.previous?.value}|${next.value}|${next.next?.value}]")
            next = next.next
        }
    }
}

fun main() {
    val nodeOne = Node("one")
    val myLinkedList = DoublyLinkedList(nodeOne)
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

    val anotherList = DoublyLinkedList<Int>()
    val intNodeOne = Node(1)
    val intNodeTwo = Node(2)
    val intNodeThree = Node(3)
    anotherList.append(intNodeOne)
    anotherList.append(intNodeTwo)
    anotherList.append(intNodeThree)
    anotherList.printList()
    println("\n---------------------------------")

    val emojiList = DoublyLinkedList<String>()
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
