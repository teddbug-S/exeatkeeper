package com.example.exeatkeeper.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.exeatkeeper.R
import com.example.exeatkeeper.lib.SharedIntState
import com.example.exeatkeeper.lib.doMatch
import com.example.exeatkeeper.navigation.HistoryScreenClass
import com.example.exeatkeeper.navigation.HomeScreenClass
import com.example.exeatkeeper.navigation.SettingsScreenClass
import com.example.exeatkeeper.navigation.StudentsScreenClass

data class EKNavigationItem(
    val label: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val screenName: Any
)

@Composable
fun EKBottomNavigationBar(navController: NavHostController, selectedIndex: SharedIntState) {

    val navItems = listOf(
        EKNavigationItem(R.string.home, R.drawable.home, R.drawable.home_outline, HomeScreenClass),
        EKNavigationItem(
            R.string.students,
            R.drawable.student,
            R.drawable.student_outline,
            StudentsScreenClass
        ),
        EKNavigationItem(
            R.string.history,
            R.drawable.history,
            R.drawable.history,
            HistoryScreenClass
        ),
        EKNavigationItem(
            R.string.settings,
            R.drawable.settings,
            R.drawable.settings_outline,
            SettingsScreenClass
        ),
    )

    // Observe the current back stack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Determine the currently selected index based on the current route
    val currentRoute = navBackStackEntry?.destination?.route.toString()

    selectedIndex.value =
        navItems.indexOfFirst { doMatch(currentRoute, it.screenName) }



    NavigationBar {
        navItems.forEachIndexed { index, ekNavigationItem ->
            val icon =
                painterResource(if (selectedIndex.value == index) ekNavigationItem.selectedIcon else ekNavigationItem.unselectedIcon)

            NavigationBarItem(
                selected = selectedIndex.value == index,
                onClick = {
                    navController.popBackStack(HomeScreenClass, inclusive = false)
                    navController.navigate(ekNavigationItem.screenName) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                },
                label = {
                    Text(
                        stringResource(ekNavigationItem.label),
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 16.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
    }
}
