fun main(){


    fun part1(input: List<String>){
        val monkeyInfoList = parseMonkeys(input)

        println(monkeyInfoList[0].startingItems)
        println(monkeyInfoList[1].startingItems)
        println(monkeyInfoList[2].startingItems)

    }

    fun part2(input: List<String>){

    }

    val input = readInput("Day11_test")
    println(part1(input))
    println(part2(input))
}

data class MonkeyInfo(
    var monkeyNumber: Int = 0,
    val startingItems: MutableList<Int> = mutableListOf(),
    var operation: Pair<String,String> = Pair("",""),
    var test: Int =0,
    var trueMonkey: Int = 0,
    var falseMonkey: Int = 0)
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
            currentMonkey.startingItems?.plusAssign(s.toInt())
        }

        //Get the worry assignment
        val cleanOperation = input[j+2].replace("  Operation: new = old ", "")
        val splitOps = cleanOperation.split(" ")
        val op = splitOps[0]
        val opNum = splitOps[1]
        currentMonkey.operation = Pair(first = op,second=opNum)

        //Get the test
        val testText = input[j+3].replace("  Test: divisible by ","")
        currentMonkey.test = testText.toInt()

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