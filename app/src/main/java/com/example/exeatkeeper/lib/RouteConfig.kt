package com.example.exeatkeeper.lib

import com.example.exeatkeeper.navigation.HistoryScreenClass
import com.example.exeatkeeper.navigation.HomeScreenClass
import com.example.exeatkeeper.navigation.PasswordResetScreenClass
import com.example.exeatkeeper.navigation.SecurityPersonnelInformationScreenClass
import com.example.exeatkeeper.navigation.SettingsScreenClass
import com.example.exeatkeeper.navigation.StudentsScreenClass


fun doMatch(currentRoute: String, matchingRoute: Any): Boolean {
    return matchingRoute.toString().substringBefore("@").equals(currentRoute)
}


fun getRouteTitle(currentRoute: String): String {

    var title = "ExeatKeeper"

    if (doMatch(currentRoute, HistoryScreenClass)) {
        title = "History"
    } else if (doMatch(currentRoute, StudentsScreenClass)) {
        title = "Students"
    } else if (
        doMatch(currentRoute, SettingsScreenClass) || doMatch(
            currentRoute,
            PasswordResetScreenClass
        ) || doMatch(currentRoute, SecurityPersonnelInformationScreenClass)
    ) {
        title = "Settings"
    }
    return title
}


fun showTopAndBottomBar(currentRoute: String): Boolean {
    return currentRoute in listOf(
        HomeScreenClass.toString().substringBefore('@'),
        HistoryScreenClass.toString().substringBefore('@'),
        StudentsScreenClass.toString().substringBefore('@'),
        SettingsScreenClass.toString().substringBefore('@'),
    )
}