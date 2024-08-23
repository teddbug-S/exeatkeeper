package com.example.exeatkeeper.lib

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class SharedIntState(val initialValue: Int) {
    var value by mutableIntStateOf(initialValue)
}