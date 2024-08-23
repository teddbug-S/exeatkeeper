package com.example.exeatkeeper.lib

import android.net.Uri
import androidx.compose.runtime.mutableStateOf

class SharedUriState(initialValue: Any? = null) {
    var uri = mutableStateOf(initialValue)
}