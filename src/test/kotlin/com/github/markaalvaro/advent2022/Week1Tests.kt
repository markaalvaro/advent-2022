package com.github.markaalvaro.advent2022

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week1Tests {

    @Test
    fun `test Calorie Counting Part One`() {
        assertEquals(71506, calorieCounting1())
    }

    @Test
    fun `test Calorie Counting Part Two`() {
        assertEquals(209603, calorieCounting2())
    }

    @Test
    fun `test Rock Paper Scissors Part One`() {
        assertEquals(13052, rockPaperScissors1())
    }
    @Test
    fun `test Rock Paper Scissors Part Two`() {
        assertEquals(13693, rockPaperScissors2())
    }

    @Test
    fun `test Rucksack Reorganization Part One`() {
        assertEquals(8109, rucksackReorganization1())
    }

    @Test
    fun `test Rucksack Reorganization Part Two`() {
        assertEquals(2738, rucksackReorganization2())
    }
}