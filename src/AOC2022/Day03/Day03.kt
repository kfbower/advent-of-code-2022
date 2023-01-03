package AOC2022.Day03

import AOC2022.readInput

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
            val priorityValue = priorityValueMap[commonChar]
            if (priorityValue != null) {
                priorityList.add(priorityValue)
            }

        }
        return priorityList.sum()
    }

    fun part2(input: List<String>): Int {
        val priorityValueMap: MutableMap<Char, Int> = buildPriorityList()
        val priorityList: MutableList<Int> = mutableListOf()
        var h = 0
        var j = 0
        var k = 0
        var l = 0
        while (h<input.size){
            var first: MutableList<String> = mutableListOf()
            var second: MutableList<String> = mutableListOf()
            var third: MutableList<String> = mutableListOf()
            val list1: MutableList<Char> = mutableListOf()
            val list2: MutableList<Char> = mutableListOf()
            val list3: MutableList<Char> = mutableListOf()
            first.add(input[h])
            second.add(input[h+1])
            third.add(input[h+2])

            first.forEachIndexed { i, s ->
                while (j<s.length){
                list1.add(s[j])
                j++}
            }
            second.forEachIndexed { i, s ->
                while (k<s.length){
                list2.add(s[k])
                k++}
            }
            third.forEachIndexed { i, s ->
                while (l<s.length){
                list3.add(s[l])
                l++}
            }

            val oneby2 = list1.intersect(list2.toSet())
            val oneby3 = list1.intersect(list3.toSet())
            val common = oneby2.intersect(oneby3.toSet())
            val commonChar = common.first()
            val priorityValue = priorityValueMap[commonChar]
            if (priorityValue != null) {
                priorityList.add(priorityValue)
            }
            h += 3
            j=0
            k=0
            l=0
        }


        return priorityList.sum()


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



