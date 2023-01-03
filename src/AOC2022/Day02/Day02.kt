package AOC2022.Day02

import AOC2022.readInput

fun main() {

    fun part1(input: List<String>): Int {
        var matchScore: Int = 0
        var shapeScore: Int = 0
        var totalScore: Int = 0
        input.forEachIndexed { i, s ->
            if (s == "A X" || s == "B Y" || s == "C Z") {
                matchScore += 3
            } else if (s == "A Y" || s == "B Z" || s == "C X") {
                matchScore += 6
            } else if (s == "A Z" || s == "B X" || s == "C Y") {
                matchScore += 0
            }
        }
            input.forEachIndexed { i, s ->
                if (s[2].toString() == "X") {
                    shapeScore += 1
                } else if (s[2].toString() == "Y") {
                    shapeScore += 2
                } else if (s[2].toString() == "Z") {
                    shapeScore += 3
                }
            }
           totalScore = matchScore+shapeScore

        return totalScore

    }

    fun part2(input: List<String>): Int {
        //(1 for Rock, 2 for Paper, and 3 for Scissors)
        //X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
        val oppRock = "A"
        val oppPaper = "B"
        val oppScissor = "C"
        val win = "Z"
        val lose = "X"
        val draw = "Y"
        var matchScore: Int = 0
        var shapeScore: Int = 0
        var totalScore: Int = 0
        input.forEachIndexed { i, s ->
            if (s[0].toString() == oppRock && s[2].toString() == win) {
                shapeScore+=2

            } else if (s[0].toString() == oppRock && s[2].toString() == draw)  {
                shapeScore+=1

            } else if (s[0].toString() == oppRock && s[2].toString() == lose)  {
                shapeScore+=3
            }
            else if (s[0].toString() == oppPaper && s[2].toString() == win) {
                shapeScore+=3

            } else if (s[0].toString() == oppPaper && s[2].toString() == draw)  {
                shapeScore+=2

            } else if (s[0].toString() == oppPaper && s[2].toString() == lose)  {
                shapeScore+=1
            }
            else if (s[0].toString() == oppScissor && s[2].toString() == win) {
                shapeScore+=1

            } else if (s[0].toString() == oppScissor && s[2].toString() == draw)  {
                shapeScore+=3

            } else if (s[0].toString() == oppScissor && s[2].toString() == lose)  {
                shapeScore+=2
            }
        }
        input.forEachIndexed { i, s ->
            if (s[2].toString() == "X") {
                matchScore += 0
            } else if (s[2].toString() == "Y") {
                matchScore += 3
            } else if (s[2].toString() == "Z") {
                matchScore += 6
            }
        }
        totalScore = matchScore+shapeScore

        return totalScore


    }


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}

