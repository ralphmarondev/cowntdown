package com.ralphmarondev.cowntdown.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.cowntdown.features.settings.presentation.about.AboutScreen
import com.ralphmarondev.cowntdown.features.settings.presentation.developer.DeveloperScreen
import com.ralphmarondev.cowntdown.features.settings.presentation.licenses.LicenseScreen

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
                navigateToDeveloper = {
                    navController.navigate(Routes.Developer) {
                        launchSingleTop = true
                    }
                },
                navigateToLicenses = {
                    navController.navigate(Routes.Licenses) {
                        launchSingleTop = true
                    }
                }
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
            DeveloperScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable<Routes.Licenses> {
            LicenseScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}
