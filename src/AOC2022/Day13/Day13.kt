package AOC2022.Day13

import AOC2022.readInput

fun main(){
    fun part1(input: List<String>): Int {
        var orderedCount = 0
        var outOfOrderCount = 0

        val pairComps: MutableList<Pair<String,String>> = mutableListOf()

        //make pair list
        var x=0
            while (x<input.size){
                pairComps.add(Pair(input[x],input[x+1]))
                x+=3
            }

        //eval each pair
       println(pairComps)





    return orderedCount
    }

    fun part2(input: List<String>){

    }

    val input = readInput("Day13_test")
    println(part1(input))
    println(part2(input))
}

