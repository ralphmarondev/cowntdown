package com.ralphmarondev.cowntdown.core.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieComponent(
    modifier: Modifier = Modifier,
    path: Int,
    iteration: Int = LottieConstants.IterateForever
) {
    val rawComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(path))
    val progress by animateLottieCompositionAsState(
        composition = rawComposition,
        iterations = iteration
    )

    LottieAnimation(
        composition = rawComposition,
        progress = { progress },
        modifier = modifier
    )
}