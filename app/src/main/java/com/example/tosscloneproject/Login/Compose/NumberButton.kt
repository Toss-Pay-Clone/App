package com.example.tosscloneproject.Login.Compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@Composable
fun NumberButton (
    modifier: Modifier = Modifier,
    number: String = "1",
    onClick: (number:String) -> Unit = {},
    ) {
    androidx.compose.material3.Button(
        onClick = { onClick(number) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .size(90.dp)
            .padding(0.dp),
        shape = RectangleShape,
        ) {
            Text(text = number,
                color = Color.White, fontSize = 30.sp)

    }
}