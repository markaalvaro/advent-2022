package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day02.txt"

enum class Symbol(val points: Int) {

    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    val beats: Symbol
            get() = when(this) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }

    fun play(other: Symbol): Int {
        return this.points + if (this.beats == other) 6 else if (this == other) 3 else 0
    }
}

enum class Result(private val points: Int) {
    LOSE(0), DRAW(3), WIN(6);

    fun forceOutcome(other: Symbol): Int {
        return this.points + Symbol.values().first {
            when(this) {
                LOSE -> other.beats == it
                DRAW -> other == it
                WIN -> other.beats != it && other != it
            }
        }.points
    }
}

fun String.toSymbol(): Symbol  {
    return when(this) {
        "A", "X" -> Symbol.ROCK
        "B", "Y" -> Symbol.PAPER
        "C", "Z" -> Symbol.SCISSORS
        else -> throw IllegalArgumentException("Unexpect Rock/Paper/Scissors value")
    }
}

fun String.toResult(): Result  {
    return when(this) {
        "X" -> Result.LOSE
        "Y" -> Result.DRAW
        "Z" -> Result.WIN
        else -> throw IllegalArgumentException("Unexpect Lost/Draw/Win value")
    }
}

fun rockPaperScissors1(): Int {
    return readFile(FILE_NAME) { it.split(" ") }
        .map { Pair(it[0].toSymbol(), it[1].toSymbol()) }
        .sumOf { (them, you) -> you.play(them) }
}

fun rockPaperScissors2(): Int {
    return readFile(FILE_NAME) { it.split(" ") }
        .map { Pair(it[0].toSymbol(), it[1].toResult()) }
        .sumOf { (them, you) -> you.forceOutcome(them) }}

fun main() {
    println(rockPaperScissors1())
    println(rockPaperScissors2())
}