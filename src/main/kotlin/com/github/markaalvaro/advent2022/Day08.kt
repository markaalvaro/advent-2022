package com.github.markaalvaro.advent2022

private const val FILE_NAME = "Day08.txt"

data class Tree(val height: Int, var visible: Boolean = false)

fun MutableList<MutableList<Tree>>.rotate() = run {
    for (r in indices)
        for (c in first().indices) {
            if (r == c) break
            this[r][c] = this[c][r].also { this[c][r] = this[r][c] }
        }

    forEach { _ -> reverse() }
}

fun treetopTreeHouse1(): Int {
    val grid = readFile(FILE_NAME) { it.toList().map { height -> Tree(height.digitToInt()) }.toMutableList() }
        .toMutableList()

    repeat(4) {
        for (r in grid.indices) {
            var tallestTree = -1
            for (c in grid.indices) {
                val current = grid[r][c]
                if (tallestTree == -1 || current.height > tallestTree) {
                    current.visible = true
                    tallestTree = current.height
                }
            }
        }
        if (it < 3) grid.rotate()
    }

    return grid.flatten()
        .count { it.visible }
}

fun treetopTreeHouse2(): Int {
    val grid = readFile(FILE_NAME) { it.toList().map { height -> Tree(height.digitToInt()) } }

    val scores = mutableListOf<Int>()
    for (r in grid.indices)
        for (c in grid.first().indices)
            scores += getScore(grid, r, c)

    return scores.max()
}

fun getScore(grid: List<List<Tree>>, row: Int, col: Int): Int {
    val height = grid[row][col].height

    var left = (col - 1  downTo  0).indexOfFirst { grid[row][it].height >= height } + 1
    if (left == 0) left = (col - 1  downTo  0).count()

    var right = (col + 1 .. grid.first().lastIndex).indexOfFirst { grid[row][it].height >= height } + 1
    if (right == 0) right = (col + 1 .. grid.first().lastIndex).count()

    var down = (row+1..grid.lastIndex).indexOfFirst { grid[it][col].height >= height } + 1
    if (down == 0) down = (row+1..grid.lastIndex).count()

    var up = (row - 1 downTo 0).indexOfFirst { grid[it][col].height >= height } + 1
    if (up == 0) up = (row - 1 downTo 0).count()

    return left * right * down * up
}

fun main() {
    println(treetopTreeHouse1())
    println(treetopTreeHouse2()) // 1224000 440640
}