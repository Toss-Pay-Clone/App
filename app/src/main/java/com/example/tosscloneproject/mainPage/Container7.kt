package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@Composable
fun Container7() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = {},
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxHeight(),
            shape = RoundedCornerShape(25),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF000000), Color(0xFFFFFFFF)
            )
        ) {
            Icon(
                Icons.Filled.Settings,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = "화면 설정",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ), modifier = Modifier.padding(end = 8.dp)
            )
        }
        Button(
            onClick = {},
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxHeight(),
            shape = RoundedCornerShape(25),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF000000), Color(0xFFFFFFFF)
            )
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = "자산 추가",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ), modifier = Modifier.padding(end = 8.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Container7Preview() {
    TossCloneProjectTheme {
        Container7()
    }
}