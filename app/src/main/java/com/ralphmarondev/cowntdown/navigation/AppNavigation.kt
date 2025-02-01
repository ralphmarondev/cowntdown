package com.ralphmarondev.cowntdown.navigation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.cowntdown.features.home.presentation.HomeScreen
import com.ralphmarondev.cowntdown.features.moo.presentation.MooScreen
import com.ralphmarondev.cowntdown.features.settings.presentation.SettingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    var currentScreen by rememberSaveable { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            val navItems = listOf(
                NavItems(
                    label = "Home",
                    selectedIcon = Icons.Filled.Home,
                    defaultIcon = Icons.Outlined.Home,
                    onClick = {
                        navController.popBackStack(route = Routes.Home, inclusive = false)
                        navController.navigate(Routes.Home) {
                            launchSingleTop = true
                        }
                    }
                ),
                NavItems(
                    label = "Moo",
                    selectedIcon = Icons.Filled.Coffee,
                    defaultIcon = Icons.Outlined.Coffee,
                    onClick = {
                        navController.popBackStack(route = Routes.Home, inclusive = false)
                        navController.navigate(Routes.Moo) {
                            launchSingleTop = true
                        }
                    }
                ),
                NavItems(
                    label = "Settings",
                    selectedIcon = Icons.Filled.Settings,
                    defaultIcon = Icons.Outlined.Settings,
                    onClick = {
                        navController.popBackStack(route = Routes.Home, inclusive = false)
                        navController.navigate(Routes.Settings) {
                            launchSingleTop = true
                        }
                    }
                )
            )

            NavigationBar {
                navItems.forEachIndexed { _, item ->
                    NavigationBarItem(
                        selected = currentScreen == item.label,
                        onClick = {
                            currentScreen = item.label
                            item.onClick()
                        },
                        icon = {
                            val icon = when (currentScreen == item.label) {
                                true -> item.selectedIcon
                                false -> item.defaultIcon
                            }
                            Icon(
                                imageVector = icon,
                                contentDescription = item.label
                            )
                        },
                        label = {
                            Text(
                                text = item.label
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.Home
        ) {
            composable<Routes.Home> {
                HomeScreen()
            }
            composable<Routes.Moo> {
                MooScreen()
            }
            composable<Routes.Settings> {
                SettingScreen(
                    darkTheme = darkTheme,
                    toggleDarkTheme = toggleDarkTheme
                )
            }
        }
    }
}

private data class NavItems(
    val label: String,
    val selectedIcon: ImageVector,
    val defaultIcon: ImageVector,
    val onClick: () -> Unit
)
