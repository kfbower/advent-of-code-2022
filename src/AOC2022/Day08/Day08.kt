package AOC2022.Day08

import AOC2022.readInput

//need to understand what this one is doing
fun main() {

    fun part1(input: List<String>): Int {
        val trees = input.parseTrees()
        val size = input.first().length
        return trees.entries.count { (pos, height) ->
            val (x, y) = pos
            val horizontal =
                (0 until x).all { trees[it to y]!! < height } ||
                        (x + 1 until size).all { trees[it to y]!! < height }
            val vertical =
                (0 until y).all { trees[x to it]!! < height } ||
                        (y + 1 until size).all { trees[x to it]!! < height }
            horizontal || vertical
        }

    }

    fun part2(input: List<String>): Int {
        val trees = input.parseTrees()
        val size = input.first().length
        return trees.maxOf { (pos, height) ->
            val (x, y) = pos
            val left = viewingDistance(x - 1 downTo 0, height) { trees[it to y]!! }
            val right = viewingDistance(x + 1 until size, height) { trees[it to y]!! }
            val up = viewingDistance(y - 1 downTo 0, height) { trees[x to it]!! }
            val down = viewingDistance(y + 1 until size, height) { trees[x to it]!! }
            left * right * up * down
        }

//test

        return input.size
    }


    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))

}
fun List<String>.parseTrees(): Map<Pair<Int, Int>, Char> {
    val trees = mutableMapOf<Pair<Int, Int>, Char>()
    this.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            trees[x to y] = c
        }
    }
    return trees
}

fun viewingDistance(range: IntProgression, height: Char, tree: (Int) -> Char) =
    when {
        range.isEmpty() -> 0
        else -> {
            val index = range.map { tree(it) }.indexOfFirst { it >= height }
            if (index < 0) range.count() else index + 1
        }
    }
