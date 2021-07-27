package data_structures// Source: https://medium.com/swlh/building-a-hash-map-in-kotlin-73c9b23d19ba

class HashTable<K, V> {

    private val arraySize = 16
    private val entries: Array<Entry<K, V>?> = arrayOfNulls(arraySize)

    // O(1) time complexity
    fun put(key: K, value: V) {
        val index = getHashCodeForKey(key)
        if (entries[index] === null) {
            entries[index] = Entry(key, value)
        }
        entries.plus(Entry(key, value))
    }

    // O(1) time complexity if there are no collisions
    fun get(key: K): V? {
        val index = getHashCodeForKey(key)
        return entries[index]?.value
    }

    fun remove(key: K) {
        val index = getHashCodeForKey(key)
        entries[index] = null
    }

    // O(1) time complexity
    private fun getHashCodeForKey(key: K): Int {
        return key.hashCode() % arraySize
    }

    // O(n) time complexity because we're looping through all keys
    fun keys() {
        val keys: MutableList<K?> = mutableListOf()
        for (entry in entries) {
            keys.add(entry?.key)
        }
        println(keys)
    }

    // O(n) time complexity because we're looping through all values
    fun values() {
        val values: MutableList<V?> = mutableListOf()
        for (entry in entries) {
            values.add(entry?.value)
        }
        println(values)
    }

    // O(n) time complexity because we're looping through all keys and values
    fun print() {
        for (index in entries.indices) {
            val key = entries[index]?.key
            val value = entries[index]?.value
            println("key: $key, value: $value")
        }
    }
}

data class Entry<K, V>(val key: K, val value: V)

fun main() {

    val myHashTable = HashTable<String, String>()
    myHashTable.put("1", "Captain America")
    myHashTable.put("2", "Iron Man")
    myHashTable.put("3", "Black Widow")
    myHashTable.print()
    myHashTable.keys()
    myHashTable.values()
    myHashTable.remove("2")
}