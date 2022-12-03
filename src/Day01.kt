fun main() {
    fun part1(input: List<String>): Int {
        var maxCals: Int = 0
        var subTotal: Int = 0
        var calorieList: MutableList<Int> = mutableListOf()
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
        maxCals = calorieList.max()
        return maxCals
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    val input = readInput("Day01")
    println(part1(input))
    ///

}

