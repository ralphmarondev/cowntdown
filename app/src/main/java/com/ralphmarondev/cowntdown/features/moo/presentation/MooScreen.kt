package com.ralphmarondev.cowntdown.features.moo.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
fun MooScreen() {
    val context = LocalContext.current
    val viewModel: MooViewModel = viewModel(
        factory = MooViewModelFactory(
            context = context
        )
    )
    val randomFunFact by viewModel.funFact.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Fun Facts",
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
                .padding(innerPadding)
        ) {
            item {
                LottieComponent(
                    path = R.raw.eating_cow,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Button(
                    onClick = viewModel::getRandomFunFact,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Say Moo!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                }
                Text(
                    text = randomFunFact,
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