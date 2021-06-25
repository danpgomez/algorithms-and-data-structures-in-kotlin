class Queue<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var length: Int = 0

    fun peek(): T? {
        if (length == 0) {
            throw Exception("Queue is empty")
        }
        return first?.value
    }

    fun enqueue(item: Node<T>) {
        if (length == 0) {
            first = item
            last = first
        } else {
            item.next = last
            last?.previous = item
            last = item
        }
        length++
    }

    fun dequeue(): String {
        if (length == 0) {
            throw Exception("Queue is empty")
        } else {
            first = first?.previous
            length--
            return this.toString()
        }
    }

    override fun toString(): String {
        var message = first?.value.toString()
        var nextNode = first?.previous
        while (nextNode != null) {
            val nextValue = nextNode.value
            message += ", $nextValue"
            nextNode = nextNode.previous
        }
        return message
    }
}

fun main() {
    val customerQueue = Queue<String>()
    val avery = Node("avery")
    val briar = Node("briar")
    val gray = Node("gray")
    val dakota = Node("dakota")

    customerQueue.enqueue(avery)
    customerQueue.enqueue(briar)
    customerQueue.enqueue(gray)
    customerQueue.enqueue(dakota)

    println("Peek1: ${customerQueue.peek()}")
    println("Dequeue1: ${customerQueue.dequeue()}")
    println("Peek2: ${customerQueue.peek()}")
    println("Dequeue2: ${customerQueue.dequeue()}")
    println("Peek3: ${customerQueue.peek()}")
    println("Dequeue3: ${customerQueue.dequeue()}")
    println("Peek4: ${customerQueue.peek()}")
    println("Dequeue4: ${customerQueue.dequeue()}")
    println("Peek5: ${customerQueue.peek()}")
}