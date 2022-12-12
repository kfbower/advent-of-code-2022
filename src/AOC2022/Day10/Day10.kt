package AOC2022.Day10

import readInput

fun main(){

    /* addx V takes two cycles to complete. After two cycles, the X register is increased by the value V. (V can be negative.)
    noop takes one cycle to complete. It has no other effect.*/

    /*signal strength (the cycle number multiplied by the value of the X register) */


    fun part1(input: List<String>): Int {
        val ssList = mutableListOf<Pair<Int,Int>>()
        var cycleCount = 1
        var Xreg = 1
        input.forEachIndexed { _, s ->
            if (s=="noop"){
                cycleCount++
                val ledgerEntry:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry
            }
            else if (s.contains("addx")){
                val newS = s.replace("addx ","")
                cycleCount++
                val ledgerEntry:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry
                cycleCount++
                Xreg+=(newS.toInt())
                val ledgerEntry2:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry2
            }
        }

//Find the signal strength during the 20th, 60th, 100th, 140th, 180th, and 220th cycles. What is the sum of these six signal strengths?
        val ssTotal: MutableList<Int> = mutableListOf()
        val ssTargetList= listOf<Int>(20,60,100,140,180,220)
        ssTargetList.forEachIndexed { _, i ->
            val cycleLookup = ssList.find{it.first == i}
            val sizeLookup = cycleLookup?.second
            ssTotal+=(sizeLookup!!*i)
        }

      return ssTotal.sum()
    }
    fun part2(input: List<String>){

        val lit = "#"
        val unlit = "."
        val ssList = mutableListOf<Pair<Int,Int>>()
        var cycleCount = 0
        var Xreg = 1

        input.forEachIndexed { i, s ->


            if (s=="noop"){
                val ledgerEntry:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry
                cycleCount++
            }
            else if (s.contains("addx")){
                val newS = s.replace("addx ","")

                val ledgerEntry:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry
                cycleCount++


                val ledgerEntry2:Pair<Int,Int> = Pair(cycleCount, Xreg)
                ssList+=ledgerEntry2
                cycleCount++
                Xreg+=(newS.toInt())
            }

        }
        val drawList1 = mutableListOf<String>()
        val drawList2 = mutableListOf<String>()
        val drawList3 = mutableListOf<String>()
        val drawList4 = mutableListOf<String>()
        val drawList5 = mutableListOf<String>()
        val drawList6 = mutableListOf<String>()
        println(ssList)



        ssList.forEachIndexed { index, pair ->

            if (index in 0..39) {
                if (pair.first == pair.second|| pair.first == ((pair.second+1)) || pair.first == ((pair.second-1))) {
                    drawList1 += lit
                } else {
                    drawList1 += unlit
                }
            }
            else if (index in 40..79) {
                if ((pair.first - 40) == pair.second|| pair.first-40 == (pair.second+1) || pair.first-40 == (pair.second-1)) {
                    drawList2 += lit
                } else {
                    drawList2 += unlit
                }
            }
            else if (index in 80..119) {
                if ((pair.first - 80) == pair.second|| pair.first-80 == (pair.second+1) || pair.first-80 == (pair.second-1)) {
                    drawList3 += lit
                } else {
                    drawList3 += unlit
                }
            }
            else if (index in 120..159) {
                if ((pair.first - 120) == pair.second|| pair.first-120 == (pair.second+1) || pair.first-120 == (pair.second-1)) {
                    drawList4 += lit
                } else {
                    drawList4 += unlit
                }
            }
            else if (index in 160..199) {
                if ((pair.first -160) == pair.second|| pair.first-160 == (pair.second+1) || pair.first-160 == (pair.second-1)) {
                    drawList5 += lit
                } else {
                    drawList5 += unlit
                }
            }
            else if (index in 200..239) {
                if ((pair.first-200) == pair.second|| pair.first-200 == (pair.second+1) || pair.first-200 == (pair.second-1)) {
                    drawList6 += lit
                } else {
                    drawList6 += unlit
                }
            }
            else{
                println("nothing")
            }

        }

        println(drawList1)
        println(drawList2)
        println(drawList3)
        println(drawList4)
        println(drawList5)
        println(drawList6)


    }

    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}