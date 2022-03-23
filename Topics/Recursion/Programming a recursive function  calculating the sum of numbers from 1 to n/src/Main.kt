fun sumRecursive(n: Int): Int = if (n == 0 || n == 1) 1 else n + sumRecursive(n - 1)

fun main() {
    val n = readLine()!!.toInt()
    print(sumRecursive(n))
}