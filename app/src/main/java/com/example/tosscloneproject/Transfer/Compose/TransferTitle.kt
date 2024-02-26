package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun TransferTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
    )
}

@Preview(showBackground = true)
@Composable
fun TransferTitlePreview() {
    TossCloneProjectTheme {
        TransferTitle(title = "어디로 돈을 보낼까요?")
    }
}