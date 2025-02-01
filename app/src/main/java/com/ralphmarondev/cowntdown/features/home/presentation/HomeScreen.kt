package com.ralphmarondev.cowntdown.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ralphmarondev.cowntdown.R
import com.ralphmarondev.cowntdown.core.components.LottieComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel()
    val isFirstDayOfMonth by viewModel.isFirstDayOfMonth.collectAsState()
    val daysUntilNextFirstDay by viewModel.daysUntilNextFirstDay.collectAsState()
    val typewriterText by viewModel.typewriterText.collectAsState()
    val currentDate by viewModel.currentDate.collectAsState()

    LaunchedEffect(isFirstDayOfMonth) {
        if (isFirstDayOfMonth) {
            viewModel.startTypewriterEffect()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                val modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)

                if (isFirstDayOfMonth) {
                    LottieComponent(path = R.raw.cow_dancing, modifier = modifier)
                    Text(
                        text = currentDate,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = typewriterText,
                        fontWeight = FontWeight.W500,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                } else {
                    LottieComponent(path = R.raw.cow_drinking, modifier = modifier)
                    Text(
                        text = "Countdown to the next first day of the month: $daysUntilNextFirstDay",
                        fontWeight = FontWeight.W500,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}