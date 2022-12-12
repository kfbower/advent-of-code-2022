package AOC2022.Day01

import readInput

fun main() {

    fun makeSummedList(input: List<String>): MutableList<Int> {
        var calorieList: MutableList<Int> = mutableListOf()
        var subTotal: Int = 0
        input.forEachIndexed { i, s ->
            if (i < input.size-1) {
                if (s != "") {
                    subTotal += s.toInt()
                } else {
                    calorieList.add(subTotal)
                    subTotal = 0
                }
            }
            else{
                subTotal += s.toInt()
                calorieList.add(subTotal)
            }
        }
        return calorieList
    }
    fun part1(input: List<String>): Int {
        var maxCals: Int = 0
        val calorieList = makeSummedList(input)
        maxCals = calorieList.max()
        return maxCals
    }

    fun part2(input: List<String>): Int {
        val calorieList = makeSummedList(input)
        val calListSorted = calorieList.sorted()
        println(calListSorted)

        var top1 = calListSorted[calListSorted.size-1]
        println(top1)
        var top2 = calListSorted[calListSorted.size-2]
        println(top2)
        var top3 = calListSorted[calListSorted.size-3]
        println(top3)
        var totalTop3 = top1+top2+top3


        return totalTop3
    }


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))

}

