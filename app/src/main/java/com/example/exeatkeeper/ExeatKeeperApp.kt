package com.example.exeatkeeper

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.exeatkeeper.components.EKBottomNavigationBar
import com.example.exeatkeeper.components.EKFAB
import com.example.exeatkeeper.components.NewExeatDialog
import com.example.exeatkeeper.components.NewStudentDialog
import com.example.exeatkeeper.lib.SharedIntState
import com.example.exeatkeeper.lib.doMatch
import com.example.exeatkeeper.lib.getRouteTitle
import com.example.exeatkeeper.lib.showTopAndBottomBar
import com.example.exeatkeeper.navigation.HistoryScreenClass
import com.example.exeatkeeper.navigation.HomeScreenClass
import com.example.exeatkeeper.navigation.Navigation
import com.example.exeatkeeper.navigation.SignUpScreenClass
import com.example.exeatkeeper.navigation.StudentsScreenClass
import com.example.exeatkeeper.ui.theme.ExeatKeeperTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExeatKeeperApp() {

    var showNewDialog by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current.applicationContext
    val currentThemeStoreValue = getTheme(context).collectAsState(initial = 0).value

    val darkMode = when (currentThemeStoreValue) {
        1 -> false
        2 -> true
        else -> isSystemInDarkTheme()
    }


    ExeatKeeperTheme(darkTheme = darkMode) {

        val navController = rememberNavController()
        val selectedIndex = SharedIntState(0)

        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // Determine the currently selected index based on the current route
        val currentRoute = navBackStackEntry?.destination?.route.toString()

        val topBarHeaderStyle = if (doMatch(currentRoute, HomeScreenClass)) {
            TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontFamily = MaterialTheme.typography.headlineLarge.fontFamily,
                fontSize = 28.sp
            )
        } else TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 26.sp
        )

        if (showNewDialog && doMatch(currentRoute, HomeScreenClass)) {
            NewExeatDialog(onDismissRequest = { showNewDialog = false })
        } else if (showNewDialog && doMatch(currentRoute, StudentsScreenClass)) {
            NewStudentDialog(onDismissRequest = { showNewDialog = false })
        } else if (showNewDialog && doMatch(currentRoute, HistoryScreenClass)) {
            NewExeatDialog(onDismissRequest = { showNewDialog = false })
        }

        Scaffold(
            topBar = {
                AnimatedVisibility(
                    visible = showTopAndBottomBar(currentRoute),
                    enter = fadeIn(tween(300)),
                    exit = slideOutVertically(tween(0))
                ) {
                    TopAppBar(
                        title = {
                            Text(
                                getRouteTitle(currentRoute),
                                style = topBarHeaderStyle
                            )
                        },
                    )
                }
            },
            floatingActionButton = {
                AnimatedVisibility(
                    visible = selectedIndex.value in listOf(0, 1, 2),
                    enter = fadeIn(tween(300)),
                    exit = fadeOut(tween(0))
                ) {
                    EKFAB(onClick = {
                        showNewDialog = true
                    })
                }
            },
            bottomBar = {
                AnimatedVisibility(
                    visible = showTopAndBottomBar(currentRoute),
                    enter = fadeIn(tween(0)),
                    exit = fadeOut(tween(0))
                ) {
                    EKBottomNavigationBar(navController, selectedIndex)
                }
            }
        ) { innerPadding ->
            Navigation(
                navController = navController,
                startDestination = SignUpScreenClass,
                innerPadding = innerPadding
            )
        }
    }
}