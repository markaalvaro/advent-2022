package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day07.txt"

data class Folder(val name: String, val parent: Folder?, var size: Int = 0)

fun noSpaceLeft1(): Int {
    val allFolders = noSpaceLeft()

    return allFolders
        .filter { it.size <= 100000 }
        .sumOf { it.size }
}

fun noSpaceLeft2(): Int {
    val allFolders = noSpaceLeft()

    val rootSize = allFolders[0].size

    val freeSpace = 70000000 - rootSize
    val needToFree = 30000000 - freeSpace

    return allFolders
        .filter { it.size >= needToFree }
        .minOf { it.size }
}

fun noSpaceLeft(): List<Folder> {
    var current = Folder("/", null)
    val allFolders = mutableListOf(current)

    readFile(FILE_NAME).drop(1)
        .filter { it != "$ ls" && !it.startsWith("dir") }
        .forEach {
            if (it == "$ cd ..") {
                current = current.parent!!
            }
            else if (it.startsWith("$ cd")) {
                allFolders += Folder(it.substringAfter("cd "), current)
                current = allFolders.last()
            }
            else {
                val newFileSize = it.split(" ")[0].toInt()
                current.size += newFileSize

                var currentParent = current.parent
                while (currentParent != null) {
                    currentParent.size += newFileSize
                    currentParent = currentParent.parent
                }
            }
        }

        return allFolders
}

fun main() {
    println(noSpaceLeft1())
    println(noSpaceLeft2())
}