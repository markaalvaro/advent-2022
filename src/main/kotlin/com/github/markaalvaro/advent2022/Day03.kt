package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day03.txt"

fun String.firstHalf() = slice(0 until length/2).toSet()
fun String.secondHalf() = slice(length/2..lastIndex).toSet()
fun Char.priority() = code - if (isLowerCase()) 96 else 38

fun rucksackReorganization1(): Int {
    return readFile(FILE_NAME) { it.firstHalf() intersect it.secondHalf() }
        .flatten()
        .sumOf { it.priority() }
}

fun rucksackReorganization2(): Int {
    return readFile(FILE_NAME) { it.toSet() }
        .chunked(3)
        .map { (elf1, elf2, elf3) -> elf1 intersect elf2 intersect elf3 }
        .flatten()
        .sumOf { it.priority() }
}

fun main() {
    println(rucksackReorganization1())
    println(rucksackReorganization2())
}