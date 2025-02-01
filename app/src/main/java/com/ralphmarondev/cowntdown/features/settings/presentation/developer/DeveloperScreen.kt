package com.ralphmarondev.cowntdown.features.settings.presentation.developer

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.cowntdown.R
import com.ralphmarondev.cowntdown.ui.theme.CowntdownTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeveloperScreen(
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Developer",
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(R.drawable.ralphmaron),
                        contentDescription = "App icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ralph Maron Eda",
                        fontWeight = FontWeight.W500,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "I'm a Computer Engineering student passionate about Android development. I love crafting intuitive and efficient mobile apps, diving deep into Kotlin and Jetpack Compose to build seamless user experiences. When I'm not coding, you’ll find me exploring new tech or working on my latest app project. Follow my journey to see what I’m building next!",
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
                HorizontalDivider(modifier = Modifier.padding(16.dp))
                Text(
                    text = "Connect with me on:",
                    fontWeight = FontWeight.W500,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialMediaButton(
                        imageIcon = R.drawable.github,
                        contentDescription = "Github",
                        url = "https://github.com/ralphmarondev",
                        appUrl = "https://github.com/ralphmarondev"
                    )
                    SocialMediaButton(
                        imageIcon = R.drawable.instagram,
                        contentDescription = "Instagram",
                        url = "https://www.instagram.com/ralphmaron/",
                        appUrl = "instagram://user?username=ralphmaron"
                    )
                    SocialMediaButton(
                        imageIcon = R.drawable.tiktok,
                        contentDescription = "TikTok",
                        url = "https://www.tiktok.com/@ralphmaron",
                        appUrl = "tiktok://user?username=ralphmaron"
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}

@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    imageIcon: Int,
    contentDescription: String,
    url: String,
    appUrl: String
) {
    val context = LocalContext.current
    ElevatedCard(
        onClick = {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(appUrl))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } catch (e: Exception) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        },
        modifier = modifier
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageIcon),
                contentDescription = contentDescription,
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DeveloperPreview() {
    CowntdownTheme {
        DeveloperScreen(
            navigateBack = {}
        )
    }
}