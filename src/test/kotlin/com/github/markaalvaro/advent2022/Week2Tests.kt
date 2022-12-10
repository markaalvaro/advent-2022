package com.github.markaalvaro.advent2022

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Week2Tests {

    @Test
    fun `test Treetop Tree House Part One`() {
        assertEquals(1787, treetopTreeHouse1())
    }

    @Test
    fun `test Treetop Tree House Part Two`() {
        assertEquals(440640, treetopTreeHouse2())
    }

    @Test
    fun `test Cathode Ray Tube Part One`() {
        assertEquals(11220, cathodeRayTube1())
    }

    @Test
    fun `test Cathode Ray Tube Part Two`() {
        val expected = """
            ###..####.###...##....##.####.#....#..#.
            #..#....#.#..#.#..#....#.#....#....#.#..
            ###....#..#..#.#..#....#.###..#....##...
            #..#..#...###..####....#.#....#....#.#..
            #..#.#....#....#..#.#..#.#....#....#.#..
            ###..####.#....#..#..##..####.####.#..#.""".trimIndent()
        assertEquals(expected + "\n", cathodeRayTube2())
    }
}