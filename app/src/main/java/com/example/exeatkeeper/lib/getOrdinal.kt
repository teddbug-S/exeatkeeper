package com.example.exeatkeeper.lib


fun getOrdinal(number: Int): String {
    return when(number) {
        1 -> "First"
        2 -> "Second"
        3 -> "Third"
        4 -> "Fourth"
        5 -> "Fifth"
        6 -> "Sixth"
        else -> "Not found"
    }
}