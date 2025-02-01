package com.ralphmarondev.cowntdown.features.settings.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Source
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.cowntdown.R
import com.ralphmarondev.cowntdown.features.settings.presentation.components.SettingItemCard
import com.ralphmarondev.cowntdown.features.settings.presentation.components.ThemeToggleCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        fontFamily = FontFamily.Monospace
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = rememberAsyncImagePainter(R.drawable.app_icon),
                    contentDescription = "App icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Cowntdown",
                    fontWeight = FontWeight.W500,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = "Version 1.0",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.tertiary
                )
                HorizontalDivider(modifier = Modifier.padding(16.dp))
                ThemeToggleCard(
                    modifier = Modifier
                        .clickable { toggleDarkTheme() }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 2.dp),
                    darkTheme = darkTheme,
                    toggleDarkTheme = toggleDarkTheme
                )
                SettingItemCard(
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .padding(16.dp),
                    label = "About",
                    imageVector = Icons.Outlined.Info
                )
                SettingItemCard(
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .padding(16.dp),
                    label = "Licenses",
                    imageVector = Icons.Outlined.Source
                )
            }
        }
    }
}