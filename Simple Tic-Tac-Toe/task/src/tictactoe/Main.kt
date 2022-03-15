package tictactoe
import kotlin.math.abs

fun main() {
    print("Enter cells: ")
    val input = readln().take(9)
    val cells = input.toList().windowed(size = 3, step = 3)
    cells[0][0]

    printBoard(cells)
    println(getGameState(cells))
}


fun printBoard(cells: List<List<Char>>) {
    val outer = "-".repeat(9)
    val rows = cells.map { it.joinToString(separator = " ", prefix = "| ", postfix = " |") }

    println(outer)
    rows.forEach(::println)
    println(outer)
}

fun getGameState(cells: List<List<Char>>): String {
    val symbols = cells.flatten().groupingBy { it }.eachCount().withDefault { 0 }
    val xCount = symbols.getValue('X')
    val oCount = symbols.getValue('O')
    val emptyCount = symbols.getValue('_')

    if ( abs(xCount - oCount) > 1) {
        return "Impossible"
    }

    val lines = mutableListOf<List<Char>>()
    lines += cells
    lines += (0..2).map { i -> cells.map { row -> row[i] } }
    lines += (0..2).map { i -> cells[i][i] }
    lines += (0..2).map { i -> cells[i][cells.lastIndex - i] }

    val wins = lines.map(List<Char>::toSet).filter { it.size == 1 && ('_' !in it) }.flatten()

    return when(wins.size) {
        0 -> if(emptyCount > 0) "Game not finished" else "Draw"
        1 -> "${wins.first()} wins"
        else -> "Impossible"
    }
}