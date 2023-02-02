fun main() {
    print(detectCycle(prepareList(intArrayOf(-1,-7,7,-4,19,6,-9,-5,-2,-5)))?.`val`)
}

fun detectCycle(head: ListNode?): ListNode? {
    val list = mutableSetOf<ListNode>()
    var temp = head
    while (temp != null) {
        if (list.none { it.`val` == temp?.`val` }) {
            list.add(temp)
        } else {
            //return list.indexOf(list.filter { it.`val` == temp?.`val` }[0])
        }

        temp = temp.next
    }
    return null
}

fun prepareList(array: IntArray): ListNode? {
    return if (array.isNotEmpty()) {
        val head = ListNode(array[0])
        head.next = null
        for (i in 1 until array.size) {
            var temp = head
            while (temp.next != null) {
                temp = temp.next!!
            }
            temp.next = ListNode(array[i])
        }
        head
    } else null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}