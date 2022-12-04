package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day04.txt"

infix fun IntRange.containsAll(other: IntRange) = other.first in this && other.last in this

fun toRange(bounds: String): IntRange {
    val splitBounds = bounds.split("-")
    return splitBounds[0].toInt()..splitBounds[1].toInt()
}

fun campCleanup1(): Int {
    return readFile(FILE_NAME) { it.split(",").map(::toRange) }
        .count { (left, right) -> left containsAll right || right containsAll left }
}

fun campCleanup2(): Int {
    return readFile(FILE_NAME) { it.split(",").map(::toRange) }
        .count { (left, right) -> (left intersect right).isNotEmpty() }
}

fun main() {
    println(campCleanup1())
    println(campCleanup2())
}