
fun main() {
    fun part1(input: List<String>) {
        val set1: MutableList<Char> = mutableListOf('S','M','R','N','W','J','V','T')
        val set2: MutableList<Char> = mutableListOf('B','W','D','J','Q','P','C','V')
        val set3: MutableList<Char> = mutableListOf('B','J','F','H','D','R','P')
        val set4: MutableList<Char> = mutableListOf('F','R','P','B','M','N','D')
        val set5: MutableList<Char> = mutableListOf('H','V','R','P','T','B')
        val set6: MutableList<Char> = mutableListOf('C','B','P','T')
        val set7: MutableList<Char> = mutableListOf('B','J','R','P','L')
        val set8: MutableList<Char> = mutableListOf('N','C','S','L','T','Z','B','W')
        val set9: MutableList<Char> = mutableListOf('L','S','G')

        input.forEachIndexed { _, s ->
            println(s.lines())
            val newY = s.dropWhile { !it.isDigit() }
            val newS = newY.filter { !it.isWhitespace() }
            val parts = newS.split("from","to")

            val moves = parts[0].toInt()
            val start = parts[1].toInt()
            val end = parts[2].toInt()
            var j=0
            var removed: Char
            while (j<moves){
                when (start) {
                    1-> {removed = set1.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    2 -> {removed = set2.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    3 -> {removed = set3.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    4 -> {removed = set4.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    5 -> {removed = set5.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    6 -> {removed = set6.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    7 -> {removed = set7.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    8 -> {removed = set8.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                    9 -> {removed = set9.removeLast()
                        when(end) {
                            1 -> set1.add(removed)
                            2 -> set2.add(removed)
                            3 -> set3.add(removed)
                            4 -> set4.add(removed)
                            5 -> set5.add(removed)
                            6 -> set6.add(removed)
                            7 -> set7.add(removed)
                            8 -> set8.add(removed)
                            9 -> set9.add(removed)
                        }
                        j++
                    }
                }
            }
        }

        val set1f = set1.last()
        val set2f = set2.last()
        val set3f = set3.last()
        val set4f = set4.last()
        val set5f = set5.last()
        val set6f = set6.last()
        val set7f = set7.last()
        val set8f = set8.last()
        val set9f = set9.last()

        println("$set1f$set2f$set3f$set4f$set5f$set6f$set7f$set8f$set9f")
    }



    fun part2(input: List<String>) {
        val set1: MutableList<Char> = mutableListOf('S', 'M', 'R', 'N', 'W', 'J', 'V', 'T')
        val set2: MutableList<Char> = mutableListOf('B', 'W', 'D', 'J', 'Q', 'P', 'C', 'V')
        val set3: MutableList<Char> = mutableListOf('B', 'J', 'F', 'H', 'D', 'R', 'P')
        val set4: MutableList<Char> = mutableListOf('F', 'R', 'P', 'B', 'M', 'N', 'D')
        val set5: MutableList<Char> = mutableListOf('H', 'V', 'R', 'P', 'T', 'B')
        val set6: MutableList<Char> = mutableListOf('C', 'B', 'P', 'T')
        val set7: MutableList<Char> = mutableListOf('B', 'J', 'R', 'P', 'L')
        val set8: MutableList<Char> = mutableListOf('N', 'C', 'S', 'L', 'T', 'Z', 'B', 'W')
        val set9: MutableList<Char> = mutableListOf('L', 'S', 'G')

        input.forEachIndexed { _, s ->

            val newY = s.dropWhile { !it.isDigit() }
            val newS = newY.filter { !it.isWhitespace() }
            val parts = newS.split("from", "to")
            val moves = (parts[0].toInt())-1
            val start = parts[1].toInt()
            val end = parts[2].toInt()
            var j=0
            val removed: MutableList<Char>

            when (start) {
                1 -> {
                    removed = set1.subList(set1.lastIndex-moves, set1.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set1.removeLast()
                        j++
                    }
                }

                2 -> {
                    removed = set2.subList(set2.lastIndex-moves, set2.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set2.removeLast()
                        j++
                    }
                }

                3 -> {
                    removed = set3.subList(set3.lastIndex-moves, set3.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set3.removeLast()
                        j++
                    }
                }
                4 -> {
                    removed = set4.subList(set4.lastIndex-moves, set4.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set4.removeLast()
                        j++
                    }
                }
                5 -> {
                    removed = set5.subList(set5.lastIndex-moves, set5.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set5.removeLast()
                        j++
                    }
                }
                6 -> {
                    removed = set6.subList(set6.lastIndex-moves, set6.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set6.removeLast()
                        j++
                    }
                }
                7 -> {
                    removed = set7.subList(set7.lastIndex-moves, set7.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set7.removeLast()
                        j++
                    }
                }
                8 -> {
                    removed = set8.subList(set8.lastIndex-moves, set8.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set8.removeLast()
                        j++
                    }
                }
                9 -> {
                    removed = set9.subList(set9.lastIndex-moves, set9.lastIndex+1)
                    when (end) {
                        1 -> set1.addAll(removed)
                        2 -> set2.addAll(removed)
                        3 -> set3.addAll(removed)
                        4 -> set4.addAll(removed)
                        5 -> set5.addAll(removed)
                        6 -> set6.addAll(removed)
                        7 -> set7.addAll(removed)
                        8 -> set8.addAll(removed)
                        9 -> set9.addAll(removed)
                    }
                    while (j<moves+1){
                        set9.removeLast()
                        j++
                    }
                }
            }
        }

        val set1f = set1.last()
        val set2f = set2.last()
        val set3f = set3.last()
        val set4f = set4.last()
        val set5f = set5.last()
        val set6f = set6.last()
        val set7f = set7.last()
        val set8f = set8.last()
        val set9f = set9.last()

        println("$set1f$set2f$set3f$set4f$set5f$set6f$set7f$set8f$set9f")
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
