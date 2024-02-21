package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Container5() {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "계좌개설", color = Color(0xFF6B7684), fontSize = 16.sp)
        Divider(color = Color(0xFF6B7684), modifier = Modifier
            .height(18.dp)
            .width(1.dp))
        Text(text = "카드발급", color = Color(0xFF6B7684), fontSize = 16.sp)
        Divider(color = Color(0xFF6B7684), modifier = Modifier
            .height(18.dp)
            .width(1.dp))
        Text(text = "대출받기", color = Color(0xFF6B7684), fontSize = 16.sp)
    }
}
@Preview(showBackground = true)
@Composable
fun Container5Preview() {
    TossCloneProjectTheme {
        Container5()
    }
}