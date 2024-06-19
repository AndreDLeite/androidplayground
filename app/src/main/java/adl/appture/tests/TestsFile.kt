package adl.appture.tests

infix fun String.substringMatches(r: Regex): String {
    return this.replace(r, "")
}

infix fun String.removeSpecificDigits(r: String): String {
    val regex = r.toRegex()
    return this.replace(regex, "")
}

fun String.removeDigits() = this.replace("\\d".toRegex(), "")

val anonymousObj = object {
    val x: Int = 10
    val y: Int = 20
}

data class ListNode<T : Any>(
    val nextNode: ListNode<T>? = null,
    val previousNode: ListNode<T>? = null,
    val value: T
) {
    override fun toString(): String {
        return if (nextNode != null) {
            "$value -> ${nextNode.toString()}"
        } else {
            "$value"
        }

    }
}

class operationOnLinkedList<T : Any> {
    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null
    private var size = 0


    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    // note here we modifying its return type to be operationOnLinkedList<T>.
// By doing so, each call to push will return the updated LinkedList instance,
// enabling subsequent method calls on the same object.
    fun push(value: T): operationOnLinkedList<T> = apply {
        head = ListNode(value = value, nextNode = head)
        if (tail == null) {
            tail = head
        }
        size++
    }
}

object MyParameter {

    fun toMyString(): String {
        return "My String"
    }

}

object testMyStack {
    val testeObject = object {
        val x: Int = 10
        val y: Int = 20
    }
    val myStackTest = MyStack<MyParameter>(operationOnLinkedList())

    fun getFirstString() {
        myStackTest.getFirstNode()
    }
}

fun printVowels(phrase: String) {
    phrase.forEachIndexed { index, c ->
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            print(index)
        } else {
            print(c)
        }
    }
}

data class MyStack<E>(val linkedList: operationOnLinkedList<E>) where E : Any {
    val myStack = ArrayDeque<operationOnLinkedList<E>>()

    fun add() {
        if (linkedList.isEmpty().not()) {
            myStack.add(linkedList)
        } else {
            println("Can't add an empty list into the stack")
        }
    }

    fun getFirstNode() {
        if (myStack.isNotEmpty()) {
            println(myStack.first().toString())
        } else {
            println("Stack is empty")
        }
    }

    fun remove() {
        if (myStack.isNotEmpty()) {
            myStack.removeLast()
        } else {
            println("Stack is empty")
        }
    }
}