package tictactoe

fun gridCreator(inStr: String): MutableList<MutableList<Char>> {
    val inStr = inStr.replace('_', ' ')
    val grid: MutableList<MutableList<Char>> = mutableListOf()
    grid.add(mutableListOf(inStr[0], inStr[1], inStr[2]))
    grid.add(mutableListOf(inStr[3], inStr[4], inStr[5]))
    grid.add(mutableListOf(inStr[6], inStr[7], inStr[8]))
    return grid
}

fun gridPrinter(grid: MutableList<MutableList<Char>>) {
    println("""---------
| ${grid[0][0]} ${grid[0][1]} ${grid[0][2]} |
| ${grid[1][0]} ${grid[1][1]} ${grid[1][2]} |
| ${grid[2][0]} ${grid[2][1]} ${grid[2][2]} |
---------""")
}

fun makeMove (grid: MutableList<MutableList<Char>>): Boolean {
    var suitable = false
    print("Enter the coordinates: ")
    val input = readln()
    try {
        val cords = input.split(" ")
        val x = cords[0].toInt()
        val y = cords[1].toInt()
        grid[x - 1][y - 1] = if (grid[x - 1][y - 1] == ' ') 'X' else throw Exception()
        // if (x > 3 || y > 3) throw IOException()
        suitable = true
    } catch (e: NumberFormatException) {
        println("You should enter numbers!")
    } catch (e: IndexOutOfBoundsException) {
        println("Coordinates should be from 1 to 3!")
    } catch (e: Exception) {
        println("This cell is occupied! Choose another one!")
    }
    return suitable
}

fun main() {
    print("Enter cells: ")
    val grid = gridCreator(readln())
    gridPrinter(grid)
    var check = makeMove(grid)
    while (!check) {
        check = makeMove(grid)
    }
    gridPrinter(grid)
}