package com.example.tosscloneproject.Login.Compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable


@Composable
fun AnimatedPageSlide (visible: Boolean, content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(200, delayMillis = 100)),
        exit = ExitTransition.None ) {
        content()
    }
}

