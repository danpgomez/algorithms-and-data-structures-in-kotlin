package data_structures

data class TreeNode(
    val value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

class BinarySearchTree(
    var root: TreeNode? = null
) {

    fun insert(item: Int): BinarySearchTree {
        val newNode = TreeNode(item)

        // If tree is empty make new node the root
        if (root == null) {
            root = newNode
            return this
        }

        var currentNode = root
        while (true) {
            if (currentNode != null) {
                if (newNode.value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        return this
                    }
                    currentNode = currentNode.left
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        return this
                    }
                    currentNode = currentNode.right
                }
            }
        }
    }

    fun lookup(value: Int): Boolean {
        if (root?.value == value) {
            return true
        }

        var currentNode = root
        while (currentNode != null) {
            when {
               value < currentNode.value -> currentNode = currentNode.left
               value > currentNode.value -> currentNode = currentNode.right
               value == currentNode.value -> return true
            }
        }

        return false
    }

    fun remove(value: Int): Boolean {
        if (root == null) {
            println("Error: Tree is empty")
            return false
        }

        var parentNode = root
        var currentNode = root

        while (currentNode != null) {
            if (value < currentNode.value) {
                // If value is smaller than currentNode go left
                parentNode = currentNode
                currentNode = currentNode.left
            } else if (value > currentNode.value) {
                // If value is greater than currentNode go right
                parentNode = currentNode
                currentNode = currentNode.right
            } else if (value == currentNode.value) { // We have a match!!!

                // Option 1: currentNode (desired node) is a leaf
                if (currentNode.left == null && currentNode.right == null) {
                    if (currentNode == root) {
                        root = null
                        return true
                    } else {
                        when {
                            value < parentNode!!.value -> parentNode.left = null
                            value > parentNode.value -> parentNode.right = null
                        }
                        return true
                    }
                }

                // Option 2: currentNode (desired node) has one child
                else if ((currentNode.left != null)xor(currentNode.right != null)) {
                    if (currentNode.left != null) {
                        when {
                            currentNode.left!!.value < parentNode?.value!! -> parentNode.left = currentNode.left
                            currentNode.left!!.value > parentNode.value -> parentNode.right = currentNode.left
                        }
                    } else if (currentNode.right != null) {
                        when {
                            currentNode.right!!.value < parentNode?.value!! -> parentNode.left = currentNode.right
                            currentNode.right!!.value > parentNode.value -> parentNode.right = currentNode.right
                        }
                    }
                }

                // Option 3: currentNode (desired node) has two children. Replace with successor
                // Successor is leftmost of right child
                else {
                    // Step 1. Get reference to undesired node's children
                    val rightChild = currentNode.right
                    val leftChild = currentNode.left

                    // Step 2. Traverse to the successor by going right once and then left in a  loop until null
                    currentNode = currentNode.right
                    while (currentNode?.left != null) {
                        currentNode = currentNode.left
                    }
                    val successor = currentNode

                    // Step 3. Attach children of undesired node to successor
                    // Check whether the parent node is the root and if so only assign the left child
                    if (parentNode == root) {
                       currentNode?.left = leftChild
                        root = currentNode
                    } else {
                        successor?.right = rightChild
                        successor?.left = leftChild

                        // Step 4. Check if successor is greater or smaller than parent to decide if it should be left or right of parent
                        when {
                            successor!!.value < parentNode!!.value -> parentNode.left = successor
                            successor.value > parentNode.value -> parentNode.right = successor
                        }
                    }

                    return true
                }
            }
        }
        println("$value not found")
        return false
    }
}

fun preOrderTraversal(
    node: TreeNode?,
    operation: (TreeNode) -> Unit
) {
    if (node == null) return

    operation.invoke(node)
    preOrderTraversal(node.left, operation)
    preOrderTraversal(node.right, operation)
}

fun main() {
    val myTree = BinarySearchTree()

    // Insert
    myTree.insert(5)
    myTree.insert(3)
    myTree.insert(7)
    myTree.insert(9)

    preOrderTraversal(myTree.root) {
        println(it.value)
    }

    // Lookups
    println(myTree.lookup(5))
    println(myTree.lookup(3))
    println(myTree.lookup(7))
    println(myTree.lookup(9))
    println(myTree.lookup(20))
    println(myTree.lookup(30))
    println(myTree.lookup(40))

    // Remove
    println(myTree.remove(9))
    println(myTree.remove(5))
    println(myTree.remove(3))
    println(myTree.remove(7))
    println(myTree.remove(6))

    preOrderTraversal(myTree.root) {
        println("After remove: ${it.value}")
    }

}