package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day05.txt"

fun supplyStacks1(): String {
    val startingPosition = readFile(FILE_NAME, trim=false).takeWhile { it.isNotBlank() }
        .map { it.chunked(4).map { chunk -> if (chunk.length >= 2) chunk[1] else ' ' } }
        .dropLast(1)

    val stacks = mutableListOf<MutableList<Char>>()

    for (i in 0..startingPosition.last().lastIndex) {
        stacks.add(ArrayDeque())
        var j = startingPosition.lastIndex
        do {
            stacks.last().add(startingPosition[j][i])
            j--
        } while (j >= 0 && i <= startingPosition[j].lastIndex && startingPosition[j][i] != ' ')
    }

    readFile(FILE_NAME).dropWhile { it.isNotBlank() }.drop(1)
        .map { it.split(" ").filter { d -> !d.matches(Regex("[a-z]*")) } }
        .forEach{ (toMove, from, to) ->
            repeat(toMove.toInt()) {
                val inProcess = stacks[from.toInt() - 1].removeLast()
                stacks[to.toInt() - 1].add(inProcess)
            }
        }

    return stacks.map { it.removeLast() }.joinToString("")
}

fun supplyStacks2(): Int {
    return 0
}

fun main() {
    println(supplyStacks1())
    println(supplyStacks2())
}