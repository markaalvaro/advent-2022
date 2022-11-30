package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day01.txt"

fun day1Part1(): Int {
    return readFile(FILE_NAME)
        .size
}

fun day1Part2(): Int {
    return readFile(FILE_NAME) { it }
        .size
}

fun main() {
    println(day1Part1())
    println(day1Part1())
}