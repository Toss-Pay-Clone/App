package com.example.tosscloneproject.Login.Compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.ui.theme.TextColor2

@Composable
fun InputDots(
    numbers: List<Int> = listOf(),
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (i in 0..5) {
            PinIndicator(
                filled = when (i) {
                    0 -> numbers.isNotEmpty()
                    else -> numbers.size > i
                }
            )
        }
    }
}

@Composable
private fun PinIndicator (
    filled: Boolean,
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(20.dp)
            .clip(CircleShape)
            .background( if (filled) TextColor2 else Color.Transparent )
            .border(BorderStroke(2.dp, TextColor2), CircleShape )
    )
}