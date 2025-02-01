package com.ralphmarondev.cowntdown.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.cowntdown.features.settings.presentation.about.AboutScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Main
    ) {
        composable<Routes.Main> {
            MainNavigation(
                darkTheme = darkTheme,
                toggleDarkTheme = toggleDarkTheme,
                navigateToAbout = {
                    navController.navigate(Routes.About) {
                        launchSingleTop = true
                    }
                },
                navigateToDeveloper = {},
                navigateToLicenses = {}
            )
        }
        composable<Routes.About> {
            AboutScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable<Routes.Developer> {

        }
        composable<Routes.Licenses> {

        }
    }
}
