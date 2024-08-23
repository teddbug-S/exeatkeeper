package com.example.exeatkeeper.lib

import android.content.Context


fun saveThemePreference(themeMode: Int, context: Context) {
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    with(sharedPref.edit()) {
        putInt("theme_mode", themeMode)
        apply()
    }
}

fun loadThemePreference(context: Context): Int {
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val savedMode = sharedPref.getInt("theme_mode", 2)
    return savedMode
}
