fun isPrime(n: Int, i: Int = 2): Boolean {
    return when {
        n < 2 || n % i == 0 -> false
        i + 1 < n -> isPrime(n, i + 1)
        else -> true
    }
}

fun main() {
    val n = readLine()!!.toInt()
    print(isPrime(n))
}