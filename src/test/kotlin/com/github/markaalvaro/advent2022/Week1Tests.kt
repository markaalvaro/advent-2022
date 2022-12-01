package com.github.markaalvaro.advent2022

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week1Tests {

    @Test
    fun `test Day 1 Part One`() {
        assertEquals(71506, calorieCounting1())
    }

    @Test
    fun `test Day 1 Part Two`() {
        assertEquals(209603, calorieCounting2())
    }
}