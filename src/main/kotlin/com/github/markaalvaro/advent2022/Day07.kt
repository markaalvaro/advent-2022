package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day07.txt"

data class Folder(val parent: Folder?, var size: Int = 0)

val folders = makeFolders()

fun noSpaceLeft1() = folders.filter { it.size <= 100000 }
    .sumOf { it.size }

fun noSpaceLeft2(): Int {
    val rootSize = folders.first().size
    val freeSpace = 70000000 - rootSize
    val needToFree = 30000000 - freeSpace

    return folders.filter { it.size >= needToFree }
        .minOf { it.size }
}

fun makeFolders(): List<Folder> {
    var current = Folder(null)
    val folders = mutableListOf(current)

    readFile(FILE_NAME).drop(1)
        .filter { it != "$ ls" && !it.startsWith("dir") }
        .forEach {
            if (it == "$ cd ..")
                current = current.parent!!
            else if (it.startsWith("$ cd")) {
                folders += Folder(current)
                current = folders.last()
            }
            else {
                val newFileSize = it.substringBefore(" ").toInt()
                current.size += newFileSize

                var currentParent = current.parent
                while (currentParent != null) {
                    currentParent.size += newFileSize
                    currentParent = currentParent.parent
                }
            }
        }

        return folders
}

fun main() {
    println(noSpaceLeft1())
    println(noSpaceLeft2())
}