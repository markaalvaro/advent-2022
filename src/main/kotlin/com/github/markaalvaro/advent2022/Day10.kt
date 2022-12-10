package com.github.markaalvaro.advent2022

import java.lang.StringBuilder

private const val FILE_NAME = "Day10.txt"

data class Instruction(val value: Int? = null)

private val instructions = readFile(FILE_NAME) {
    if (it == "noop") Instruction(null)
    else Instruction(it.substringAfter(" ").toInt())
}

fun cathodeRayTube1(): Int {
    var register = 1
    var cycle = 0

    return instructions.sumOf {
        var result = 0

        if (++cycle % 40 == 20) result += register * cycle

        if (it.value != null) {
            if (++cycle % 40 == 20) result += register * cycle
            register += it.value
        }

        result
    }
}

fun cathodeRayTube2(): String {
    var sprite = 0
    var cycle = 0
    val sb = StringBuilder()

    instructions.forEach {
        doCycle(++cycle, sprite, sb)

        if (it.value != null) {
            doCycle(++cycle, sprite, sb)
            sprite += it.value
        }
    }

    return sb.toString()
}

fun doCycle(cycle: Int, sprite: Int, sb: StringBuilder) {
    val pixel = (cycle - 1) % 40
    if (pixel in sprite..sprite + 2) sb.append("#")
    else sb.append(".")

    if (cycle % 40 == 0) sb.append("\n")
}

fun main() {
    println(cathodeRayTube1())
    println(cathodeRayTube2())
}