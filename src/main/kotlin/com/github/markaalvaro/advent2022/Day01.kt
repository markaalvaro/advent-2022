package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day01.txt"

fun calorieCounting1(): Int {
    return calorieCounting(1)
}

fun calorieCounting2(): Int {
    return calorieCounting(3)
}

fun calorieCounting(num: Int): Int {
    val counts = mutableListOf(0)

    return readFile(FILE_NAME)
        .fold(counts) { cts, line ->
            if (line.isBlank()) cts += 0
            else cts[cts.lastIndex] = cts.last() + line.toInt()
            cts
        }
        .sortedDescending()
        .take(num)
        .sum()
}

fun main() {
    println(calorieCounting1())
    println(calorieCounting2())
}