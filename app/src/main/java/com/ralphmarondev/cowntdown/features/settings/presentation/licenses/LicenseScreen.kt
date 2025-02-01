package com.ralphmarondev.cowntdown.features.settings.presentation.licenses

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ralphmarondev.cowntdown.R
import com.ralphmarondev.cowntdown.ui.theme.CowntdownTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LicenseScreen(
    navigateBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "License",
                        fontFamily = FontFamily.Monospace
                    )
                },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = "Navigate back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
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
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "MIT License",
                    fontWeight = FontWeight.W500,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Copyright (c)2025 Ralph Maron Eda. All Right Reserved.",
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Text(
                    text = stringResource(R.string.app_license),
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Text(
                    text = buildAnnotatedString {
                        append("Any questions about our licensed work can be sent to ")
                        pushStringAnnotation(
                            tag = "email",
                            annotation = "mailto:edaralphmaron@gmail.com"
                        )
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                            append("edaralphmaron@gmail.com")
                        }
                        pop()
                    },
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable {
                            // Open email app
                            val intent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:edaralphmaron@gmail.com")
                            }
                            context.startActivity(intent)
                        }
                )

                HorizontalDivider(modifier = Modifier.padding(8.dp))
                Text(
                    text = "Android Open Source Project",
                    fontWeight = FontWeight.W500,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Apache License 2.0",
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "- google fonts",
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        pushStringAnnotation(
                            tag = "license",
                            annotation = "http://www.apache.org/licenses/LICENSE-2.0"
                        )
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                            append("http://www.apache.org/licenses/LICENSE-2.0")
                        }
                        pop()
                    },
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable {
                            // Open browser
                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("http://www.apache.org/licenses/LICENSE-2.0")
                            }
                            context.startActivity(intent)
                        }
                )

            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LicensePreview() {
    CowntdownTheme {
        LicenseScreen(
            navigateBack = {}
        )
    }
}