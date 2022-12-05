package com.github.markaalvaro.advent2022

fun readFile(fileName: String, trim: Boolean = false): List<String> {
    return object {}.javaClass.classLoader.getResource(fileName)!!
        .readText(Charsets.UTF_8)
        .lines()
        .map { if (trim) it.trim() else it }
}

fun <T> readFile(fileName: String, transformation: (String) -> T): List<T> {
    return readFile(fileName)
        .map(transformation)
}
