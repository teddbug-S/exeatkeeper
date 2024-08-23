package com.example.exeatkeeper

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val THEME_KEY = intPreferencesKey("theme")

fun getTheme(context: Context): Flow<Int> {
    val themeFlow: Flow<Int> = context.settingsDataStore.data
        .map { preferences -> preferences[THEME_KEY] ?: 0 }

    return themeFlow
}

suspend fun setTheme(context: Context, theme: Int) {
    context.settingsDataStore.edit {
        settings ->
        settings[THEME_KEY] = theme
        Log.d("SET_THEME", "Changed: ${settings[THEME_KEY] == theme}")
    }
}