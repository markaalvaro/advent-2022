package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day05.txt"

fun supplyStacks1() = supplyStacks(false)

fun supplyStacks2() = supplyStacks(true)

fun supplyStacks(reversed: Boolean): String {
    val startingPosition = readFile(FILE_NAME, trim = false).takeWhile { it.isNotBlank() }
        .filter { it.length >= 2 }
        .map { it.chunked(4).map { chunk -> chunk[1] } }
        .dropLast(1)

    val stacks = mutableListOf<ArrayDeque<Char>>()

    for (j in 0..startingPosition.last().lastIndex) {
        stacks.add(ArrayDeque())
        var i = startingPosition.lastIndex
        do {
            stacks.last().add(startingPosition[i][j])
        } while (--i >= 0 && j <= startingPosition[i].lastIndex && startingPosition[i][j] != ' ')
    }

    readFile(FILE_NAME).dropWhile { it.isNotBlank() }
        .drop(1)
        .map { it.split(" ").filter { d -> !d.matches(Regex("[a-z]*")) } }
        .forEach { (toMove, from, to) ->
            val buffer = (1..toMove.toInt()).map { stacks[from.toInt() - 1].removeLast() }.toMutableList()
            if (reversed) buffer.reverse()
            buffer.forEach { stacks[to.toInt() - 1].add(it) }
        }

    return stacks.map { it.removeLast() }.joinToString("")
}

fun main() {
    println(supplyStacks1())
    println(supplyStacks2())
}