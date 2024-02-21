package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Container8() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "개인정보처리방침 보기",)
    }
}

@Preview(showBackground = true)
@Composable
fun Container8Preview() {
    TossCloneProjectTheme {
        Container8()
    }
}