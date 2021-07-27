package data_structures

class Graph<T>(
    private var numberOfNodes: Int = 0,
    private var adjacentList: MutableMap<Node<T>, MutableList<Node<T>>?>? = mutableMapOf(),
) {

    fun addVertex(value: T) {
        val node = Node(value)
        adjacentList?.put(node, mutableListOf())
        numberOfNodes++
    }

    fun addEdge(value1: T, value2: T) {
        val node1 = Node(value1)
        val node2 = Node(value2)
        val connections1 = adjacentList?.get(node1)
        val connections2 = adjacentList?.get(node2)
        connections1?.add(node2)
        connections2?.add(node1)
    }

    fun showConnections() {
        adjacentList?.forEach { vertex ->
            val node = vertex.key.value
            val connections = vertex.value?.map { it.value }
            println("$node --> $connections")
        }
    }

}

fun main() {
    val myGraph = Graph<Int>()
    myGraph.addVertex(0)
    myGraph.addVertex(1)
    myGraph.addVertex(2)
    myGraph.addVertex(3)
    myGraph.addVertex(4)
    myGraph.addVertex(5)
    myGraph.addVertex(6)
    myGraph.addEdge(3, 1)
    myGraph.addEdge(3, 4)
    myGraph.addEdge(4, 2)
    myGraph.addEdge(4, 5)
    myGraph.addEdge(1, 2)
    myGraph.addEdge(1, 0)
    myGraph.addEdge(0, 2)
    myGraph.addEdge(6, 5)

    myGraph.showConnections()
}