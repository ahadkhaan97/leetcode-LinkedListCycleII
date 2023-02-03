fun main() {
    print(detectCycle(prepareList(intArrayOf(-1, -7, 7, -4, 19, 6, -9, -5, -2, -5)))?.`val`)
}

fun detectCycle(head: ListNode?): ListNode? {
    val list = mutableSetOf<ListNode>()
    var temp = head
    while (temp != null) {
        if (list.none { it == temp }) {
            list.add(temp)
        } else {
            return list.filter { it == temp }[0]
        }

        temp = temp.next
    }
    return null
}

fun prepareList(array: IntArray): ListNode? {
    return if (array.isNotEmpty()) {
        val head = ListNode(array[0])
        head.next = null
        var temp: ListNode? = null
        var temp2: ListNode? = null
        for (i in 1 until array.size) {
            temp = head
            while (temp?.next != null) {
                if (temp.`val` == -5)
                    temp2 = temp
                temp = temp.next!!
            }
            temp?.next = ListNode(array[i])
        }
        temp?.next = temp2
        head
    } else null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}