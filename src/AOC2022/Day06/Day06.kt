package AOC2022.Day06

import AOC2022.readInput

fun main() {
    fun part1(input: List<String>): Int{
        var finalIndex = 0
        var char1: Char?
        var char2: Char?
        var char3: Char?
        var char4: Char?
        val charset: MutableList<Char> = mutableListOf()

        input.forEachIndexed { i, s ->

            var j=0

            while (j< s.length){
                char1 = s[j]
                char2 = s[j+1]
                char3 = s[j+2]
                char4 = s[j+3]
                charset += char1!!
                charset += char2!!
                charset += char3!!
                charset += char4!!

               val distinctcount =  charset.distinct().count()

                if (distinctcount <4){
                    j++
                    char1=null
                    char2=null
                    char3=null
                    char4=null
                    charset.clear()
                }
                else {
                    j+=4
                    finalIndex = j
                    return@forEachIndexed

                }
            }
        return finalIndex


        }
        return finalIndex
    }
    fun part2(input: List<String>): Int{
        var finalIndex = 0
        var char1: Char?
        var char2: Char?
        var char3: Char?
        var char4: Char?
        val charset: MutableList<Char> = mutableListOf()

        input.forEachIndexed { i, s ->

            var j=0
            var k=0
            while (j< s.length){
               while (k<14){
                   charset += s[k+j]
                   k++
               }

                val distinctcount =  charset.distinct().count()

                if (distinctcount <14){
                    j++
                    k=0
                    charset.clear()
                }
                else {
                    j+=14
                    finalIndex = j
                    return@forEachIndexed

                }
            }
            return finalIndex


        }
        return finalIndex

    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
