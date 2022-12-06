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

    @Test
    fun `test Camp Cleanup Part One`() {
        assertEquals(498, campCleanup1())
    }

    @Test
    fun `test Camp Cleanup Part Two`() {
        assertEquals(859, campCleanup2())
    }

    @Test
    fun `test Supply Stacks Part One`() {
        assertEquals("FWNSHLDNZ", supplyStacks1())
    }

    @Test
    fun `test Supply Stacks Part Two`() {
        assertEquals("RNRGDNFQG", supplyStacks2())
    }

    @Test
    fun `test Tuning Trouble Part One`() {
        assertEquals(1582, tuningTrouble1())
    }

    @Test
    fun `test Tuning Trouble Part Two`() {
        assertEquals(3588, tuningTrouble2())
    }
}