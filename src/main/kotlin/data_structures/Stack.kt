package data_structures

import java.util.*

class Stack<T>(
    private var top: Node<T>? = null,
    private var bottom: Node<T>? = null,
) {
    var length: Int = 0
        private set

    fun isEmpty() = length == 0

    // O(1) No looping. Just adding to the beginning of the Stack
    fun push(item: Node<T>): String {
        if (isEmpty()) {
            top = item
            bottom = item
        } else {
            val currentTop = top
            top = item
            item.next = currentTop
        }
        length++
        return "New top item is: $top"
    }

    // O(1) No loops. Just reassigning top item
    fun pop(): String {
        if (isEmpty()) return "The stack is empty"

        if (top == bottom) {
            bottom = null
            length--
            return "Last item removed. List is now empty"
        }
        top = top?.next
        length--
        return "New top item is: $top"
    }

    // O(1) Just returning the top item
    fun peek(): Node<T>? {
        return top
    }
}

class ArrayListStack<T> {
    private var stack = arrayListOf<T>()

    fun push(item: T) {
        stack.add(item)
    }

    fun peek(): T {
        return top()
    }

    fun pop(): T {
        val unwanted = top()
        stack.remove(unwanted)
        return unwanted
    }

    private fun top(): T {
       if (isEmpty()) {
           throw EmptyStackException()
       }
        return stack[stack.lastIndex]
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }
}

fun main() {

    // Pushing items onto the Stack
    val bee = Node("🐝")
    val unicorn = Node("🦄")
    val dinosaur = Node("🦖")
    val myStack = Stack<String>()
    println("Is the stack empty?: ${myStack.isEmpty()}")
    println(myStack.push(unicorn))
    println("Is the stack empty?: ${myStack.isEmpty()}")
    println("New length is: ${myStack.length}")
    println(myStack.push(bee))
    println("New length is: ${myStack.length}")
    println(myStack.push(dinosaur))
    println("New length is: ${myStack.length}")

    // Peeking into the Stack
    println("What's the top item? ${myStack.peek()}")
    val lobster = Node("🦞")
    println(myStack.push(lobster))
    println("What's the top item? ${myStack.peek()}")

    // Pop top item from stack
    println(myStack.pop())
    println("New length is: ${myStack.length}")
    println(myStack.pop())
    println("New length is: ${myStack.length}")


    // Array List Stack
    val myArrayStack = ArrayListStack<String>()
    myArrayStack.push("Dog")
    myArrayStack.push("Cat")
    myArrayStack.push("Mouse")
    myArrayStack.push("Horse")
    println("Peek: ${myArrayStack.peek()}")
    println("Pop: ${myArrayStack.pop()}")
    println("Peek: ${myArrayStack.peek()}")
    println("Pop: ${myArrayStack.pop()}")
    println("Peek: ${myArrayStack.peek()}")
    println("Pop: ${myArrayStack.pop()}")
    println("Peek: ${myArrayStack.peek()}")
    println("Is the stack empty? ${myArrayStack.isEmpty()}")
}