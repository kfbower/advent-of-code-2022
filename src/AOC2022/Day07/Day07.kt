package AOC2022.Day07

import readInput

fun main(){

    fun treeBuilder(lines: List<String>): Directory {
        val root = Directory("/", parent = null)
        var current = root
        lines.drop(1).forEach {
            if (it.startsWith("$ cd ..")) {
                current = current.parent!!
            } else if (it.startsWith("$ cd")) {
                val path = it.drop(5)
                val newDir = Directory(path, parent = current)
                current.children.add(newDir)
                current = newDir
            } else if (it[0].isDigit()) {
                val size = it.split(" ")[0].toInt()
                current.file += size
            }


        }
        return root
    }


 fun part1(input: List<String>): Pair<Int, Int> {
   val root = treeBuilder(input)
     getSizes(root)
     val all = flatten(root)
     val answer = all.filter { it.size < Params.dirMax }.sumOf { it.size}
     val currentUsed = all.sumOf { it.file }
     val unused = Params.maxSpace - currentUsed
     val toDelete = Params.unusedSpace - unused


     val part2 = all.sortedBy { it.size }.first { it.size > toDelete }.size

     return answer to part2
 }
    val input = readInput("Day07")

    println(part1(input))

}

fun getSizes(directory: Directory): Int {
    //recursive function to pull add the sizes
    val sizes = directory.children.sumOf { getSizes(it) }
    directory.size = sizes + directory.file
    return directory.size
}

fun flatten(directory: Directory): List<Directory> {
    //recursive function to get the sizes
    val children = directory.children.flatMap { flatten(it) }
    return children + directory
}


data class Directory(
    val name: String,
    val parent: Directory?,
    val children: MutableList<Directory> = mutableListOf(),
    var file: Int = 0,
    var size: Int = 0)


object Params{
    val dirMax = 100000
    val maxSpace = 70000000
    val unusedSpace = 30000000
}
