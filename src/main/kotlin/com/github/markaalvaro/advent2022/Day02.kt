package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day02.txt"

enum class Symbol(val points: Int, vararg val tokens: String) {

    ROCK(1, "A", "X"),
    PAPER(2, "B", "Y"),
    SCISSORS(3, "C", "Z");

    val beats: Symbol
            get() = when(this) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
            }

    fun play(other: Symbol) = this.points + if (this.beats == other) 6 else if (this == other) 3 else 0
}

enum class Result(private val points: Int, val token: String) {
    LOSE(0, "X"), DRAW(3, "Y"), WIN(6, "Z");

    fun forceOutcome(other: Symbol) = this.points + Symbol.values()
        .first {
            when(this) {
                LOSE -> other.beats == it
                DRAW -> other == it
                WIN -> other.beats != it && other != it
            }
        }
        .points
}

fun String.toSymbol() = Symbol.values().single { this in it.tokens }
fun String.toResult() = Result.values().single { this == it.token }

fun rockPaperScissors1() = readFile(FILE_NAME)
    .map { it.split(" ").map { token -> token.toSymbol() } }
    .sumOf { (them, you) -> you.play(them) }

fun rockPaperScissors2() = readFile(FILE_NAME)
    .map { it.split(" ") }
    .map { (them, you) -> Pair(them.toSymbol(), you.toResult()) }
    .sumOf { (them, you) -> you.forceOutcome(them) }


fun main() {
    println(rockPaperScissors1())
    println(rockPaperScissors2())
}