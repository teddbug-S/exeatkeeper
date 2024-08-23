package com.example.exeatkeeper.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exeatkeeper.screens.DataUploadScreen
import com.example.exeatkeeper.screens.HistoryScreen
import com.example.exeatkeeper.screens.HomeScreen
import com.example.exeatkeeper.screens.LoginScreen
import com.example.exeatkeeper.screens.PasswordResetScreen
import com.example.exeatkeeper.screens.PrivacyPolicyScreen
import com.example.exeatkeeper.screens.SecurityInformationScreen
import com.example.exeatkeeper.screens.SecurityPersonnelScreen
import com.example.exeatkeeper.screens.SelectSchoolScreen
import com.example.exeatkeeper.screens.SettingsScreen
import com.example.exeatkeeper.screens.SignUpScreen
import com.example.exeatkeeper.screens.StudentsScreen
import com.example.exeatkeeper.screens.TermsAndConditionsScreen


@Composable
fun Navigation(
    navController: NavHostController,
    startDestination: Any,
    innerPadding: PaddingValues
) {

    // define the NavHost
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideInVertically(
                tween(500, easing = FastOutSlowInEasing),
                initialOffsetY = { 100 })
        },
        exitTransition = { fadeOut(tween(0, 0)) },
    ) {

        composable<SignUpScreenClass> {
            SignUpScreen(navController)
        }

        composable<LoginScreenClass> {
            LoginScreen()
        }

        composable<SelectSchoolScreenClass> {
            SelectSchoolScreen()
        }

        composable<SecurityPersonnelScreenClass> {
            SecurityPersonnelScreen()
        }

        composable<DataUploadScreenClass> {
            DataUploadScreen()
        }

        composable<HomeScreenClass> {
            HomeScreen(navController, innerPadding)
        }

        composable<HistoryScreenClass> {
            HistoryScreen(navController, innerPadding)
        }

        composable<StudentsScreenClass> {
            StudentsScreen(navController, innerPadding)
        }

        composable<SettingsScreenClass> {
            SettingsScreen(navController, innerPadding)
        }

        composable<PasswordResetScreenClass> {
            PasswordResetScreen(navController)
        }

        composable<SecurityPersonnelInformationScreenClass> {
            SecurityInformationScreen(navController)
        }

        composable<TermsAndConditionsScreenClass> {
            TermsAndConditionsScreen(navController, innerPadding)
        }

        composable<PrivacyPolicyScreenClass> {
            PrivacyPolicyScreen(navController, innerPadding)
        }
    }
}
