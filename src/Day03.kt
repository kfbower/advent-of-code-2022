fun main() {



    fun part1(input: List<String>): Int {

        val priorityValueMap: MutableMap<Char, Int> = buildPriorityList()
        val priorityList: MutableList<Int> = mutableListOf()

        input.forEachIndexed { i, s ->
            val list1: MutableList<Char> = mutableListOf()
            val list2: MutableList<Char> = mutableListOf()
            val length = s.length
            val firstHalfEnd = (length / 2)
            var j: Int = 0
            while (j < length) {
                if (j < firstHalfEnd) {
                    list1.add(s[j])
                    ++j
                } else if (j in firstHalfEnd  until length) {
                    list2.add(s[j])
                    ++j
                }


            }
            val common = list1.intersect(list2.toSet())
            val commonChar = common.first()
            println(common)
            println(commonChar)
            val priorityValue = priorityValueMap[commonChar]
            if (priorityValue != null) {
                priorityList.add(priorityValue)
            }

        }
        return priorityList.sum()
    }

    fun part2(input: List<String>): Int {



        return input.size


    }


    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

}

fun buildPriorityList(): MutableMap<Char, Int> {
    val map = mutableMapOf<Char,Int>()
    var n = 1
    var c = 'a'
    while (c <= 'z') {
        map[c] = n
        ++c
        ++n
    }
    var lC = 'A'
    while (lC <= 'Z') {
        map[lC] = n
        ++lC
        ++n
    }
    return map

}



