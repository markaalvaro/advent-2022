package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day06.txt"

fun tuningTrouble1() = tuningTrouble(4)

fun tuningTrouble2() = tuningTrouble(14)

fun tuningTrouble(window: Int): Int {
    return window + readFile(FILE_NAME)
        .single()
        .windowed(window)
        .indexOfFirst { it.toSet().size == window }
}

fun main() {
    println(tuningTrouble1())
    println(tuningTrouble2())
}