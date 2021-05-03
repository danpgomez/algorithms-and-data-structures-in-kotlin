data class Node<T>(
    var value: T,
    var next: Node<T>? = null
)

class LinkedList<T> (
    var head: Node<T>? = null,
    val tail: Node<T>? = head
        ) {

    fun append(item: Node<T>) {
        var current = head
        if (current == null) {
            head = item
        } else {
            while (current?.next != null) {
                current = current.next!!
            }
            current?.next = item
        }
    }

    fun preppend(item: Node<T>) {
        // TODO: Implement
    }

    fun remove(item: Node<T>) {
        // TODO: Implement
    }

    fun reverse() {
        // TODO: Implement
    }

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
    myLinkedList.append(nodeTwo)
    myLinkedList.append(nodeThree)
    myLinkedList.printList()
    println("\n---------------------------------")

    val anotherList = LinkedList<Int>()
    val intNodeOne = Node(1)
    val intNodeTwo = Node(2)
    anotherList.append(intNodeOne)
    anotherList.append(intNodeTwo)
    anotherList.printList()
    println("\n---------------------------------")
}