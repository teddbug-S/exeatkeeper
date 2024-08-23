package com.example.exeatkeeper.lib

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


// create a shared text state for the text fields

class SharedTextState(val initialValue: String = "") {
    var text by mutableStateOf(initialValue)
}