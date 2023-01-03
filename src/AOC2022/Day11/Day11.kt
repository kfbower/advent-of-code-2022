package AOC2022.Day11

import AOC2022.readInput

fun main(){


    fun part1(input: List<String>): Long {
        val cycles: Int = 20
        val worryDivisor: Long = 3L
        val monkeyInfoList = parseMonkeys(input)
        var currentWorry: Long = 0L
        var newWorry: Long = 0L
        var nextMonkeysWorry: Long = 0L
        var r = 0

        while (r < cycles) {
            monkeyInfoList.forEachIndexed { _, monkeyInfo ->
                val max = monkeyInfo.holdingItems.size
                var j = 0
                if (monkeyInfo.holdingItems != emptyList<String>()) {
                    while (j < max) {
                        monkeyInfo.monkeyInspection += 1
                        currentWorry = monkeyInfo.holdingItems[0]
                        if (monkeyInfo.operation.second == "old") {
                            when (monkeyInfo.operation.first) {
                                "+" -> {
                                    newWorry = currentWorry + currentWorry
                                }

                                "*" -> {
                                    newWorry = currentWorry * currentWorry
                                }
                            }
                        } else {
                            when (monkeyInfo.operation.first) {
                                "+" -> {
                                    newWorry = currentWorry + monkeyInfo.operation.second.toLong()
                                }

                                "*" -> {
                                    newWorry = currentWorry * monkeyInfo.operation.second.toLong()
                                }
                            }
                        }
                        nextMonkeysWorry = newWorry / worryDivisor
                        monkeyInfo.holdingItems.remove(monkeyInfo.holdingItems[0])

                        if ((nextMonkeysWorry % monkeyInfo.test) == 0L) {
                            val destination = monkeyInfoList.find { it.monkeyNumber == monkeyInfo.trueMonkey }
                            destination?.holdingItems?.add(nextMonkeysWorry)
                        } else {
                            val destination = monkeyInfoList.find { it.monkeyNumber == monkeyInfo.falseMonkey }
                            destination?.holdingItems?.add(nextMonkeysWorry)
                        }
                        j++
                    }
                }
            }
            r++
        }

        val businessList = mutableListOf<Long>()
        monkeyInfoList.forEachIndexed { _, monkeyInfo ->
            businessList.add(monkeyInfo.monkeyInspection)
        }

        businessList.sortDescending()
        println(businessList)
        return businessList[0] * businessList[1]

    }

    fun part2(input: List<String>): Long {
        val cycles: Int = 10000
        val worryDivisor: Long = 3L
        val monkeyInfoList = parseMonkeys(input)
        var currentWorry: Long = 0L
        var newWorry: Long = 0L
        var nextMonkeysWorry: Long = 0L
        var r = 0

        while (r < cycles) {
            monkeyInfoList.forEachIndexed { _, monkeyInfo ->
                val max = monkeyInfo.holdingItems.size
                var j = 0
                if (monkeyInfo.holdingItems != emptyList<String>()) {
                    while (j < max) {
                        monkeyInfo.monkeyInspection += 1
                        currentWorry = monkeyInfo.holdingItems[0]
                        if (monkeyInfo.operation.second == "old") {
                            when (monkeyInfo.operation.first) {
                                "+" -> {
                                    newWorry = currentWorry + currentWorry
                                }

                                "*" -> {
                                    newWorry = currentWorry * currentWorry
                                }
                            }
                        } else {
                            when (monkeyInfo.operation.first) {
                                "+" -> {
                                    newWorry = currentWorry + monkeyInfo.operation.second.toLong()
                                }

                                "*" -> {
                                    newWorry = currentWorry * monkeyInfo.operation.second.toLong()
                                }
                            }
                        }
                        nextMonkeysWorry = newWorry
                        monkeyInfo.holdingItems.remove(monkeyInfo.holdingItems[0])

                        if ((nextMonkeysWorry % monkeyInfo.test) == 0L) {
                            val destination = monkeyInfoList.find { it.monkeyNumber == monkeyInfo.trueMonkey }
                            destination?.holdingItems?.add(nextMonkeysWorry)
                        } else {
                            val destination = monkeyInfoList.find { it.monkeyNumber == monkeyInfo.falseMonkey }
                            destination?.holdingItems?.add(nextMonkeysWorry)
                        }
                        j++
                    }
                }
            }
            r++
        }

        val businessList = mutableListOf<Long>()
        monkeyInfoList.forEachIndexed { _, monkeyInfo ->
            businessList.add(monkeyInfo.monkeyInspection)
        }

        businessList.sortDescending()
        println(businessList)
        return businessList[0] * businessList[1]
        
    }

    val input = readInput("Day11_test")
    println(part1(input))
    println(part2(input))
}

data class MonkeyInfo(
    var monkeyNumber: Int = 0,
    var holdingItems: MutableList<Long> = mutableListOf(),
    var operation: Pair<String,String> = Pair("",""),
    var test: Long =0L,
    var trueMonkey: Int = 0,
    var falseMonkey: Int = 0,
    var monkeyInspection: Long = 0L)

fun parseMonkeys(input: List<String>): MutableList<MonkeyInfo> {
    val monkeyInfoList: MutableList<MonkeyInfo> = mutableListOf()

    var j=0
    while (j<input.size){
        //Get the monkey number
        val currentMonkey: MonkeyInfo = MonkeyInfo()
        val newMonk = input[j].replace("Monkey ","")
        val monkNum = newMonk.replace(":","")
        currentMonkey.monkeyNumber += monkNum.toInt()

        //Get the monkey items
        val items = input[j+1].replace("  Starting items: ","")
        val itemsList = items.split(", ")
        itemsList.forEachIndexed { _, s ->
            currentMonkey.holdingItems.plusAssign(s.toLong())
        }

        //Get the worry assignment
        val cleanOperation = input[j+2].replace("  Operation: new = old ", "")
        val splitOps = cleanOperation.split(" ")
        val op = splitOps[0]
        val opNum = splitOps[1]
        currentMonkey.operation = Pair(first = op,second=opNum)

        //Get the test
        val testText = input[j+3].replace("  Test: divisible by ","")
        currentMonkey.test = testText.toLong()

        //Get the true
        val trueText = input[j+4].replace("    If true: throw to monkey ","")
        currentMonkey.trueMonkey = trueText.toInt()

        //Get the false
        val falseText = input[j+5].replace("    If false: throw to monkey ","")
        currentMonkey.falseMonkey = falseText.toInt()


        monkeyInfoList.add(currentMonkey)
        j+=7


    }

    return monkeyInfoList
}