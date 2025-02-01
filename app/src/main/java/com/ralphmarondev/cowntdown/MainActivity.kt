package com.ralphmarondev.cowntdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.cowntdown.navigation.AppNavigation
import com.ralphmarondev.cowntdown.ui.theme.CowntdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CowntdownTheme {
                AppNavigation()
            }
        }
    }
}