package com.ralphmarondev.cowntdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.ralphmarondev.cowntdown.navigation.AppNavigation
import com.ralphmarondev.cowntdown.ui.theme.CowntdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            CowntdownTheme(darkTheme = darkTheme) {
                AppNavigation(
                    darkTheme = darkTheme,
                    toggleDarkTheme = {
                        darkTheme = !darkTheme
                    }
                )
            }
        }
    }
}