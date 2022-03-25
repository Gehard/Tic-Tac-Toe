fun main() {
    val first = readln().split(" ").map { it.toInt() }
    val second = readln().split(" ").map { it.toInt() }
    val third = readln().split(" ").map { it.toInt() }


    val rows = intArrayOf(first[0], second[0], third[0])
    val columns = intArrayOf(first[1], second[1], third[1])

    fun find(nums: IntArray) = nums.toHashSet().let { set -> (1..5).filter { it !in set } }
    println(find(rows).joinToString(" "))
    println(find(columns).joinToString(" "))


}