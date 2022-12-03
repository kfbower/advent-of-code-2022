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

   return input.size
    }


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}

