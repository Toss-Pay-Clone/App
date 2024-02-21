package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@Composable
fun Container4() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // item1
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "이번 달 쓴 금액", fontSize = 13.sp)
                Text(text = "0원", fontSize = 18.sp)
            }
            Column {
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFF2F4F5), Color(0xFF6B7684)
                    )
                ) {
                    Text(
                        text = "내역", style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
        // item2
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 20.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "내 모든 카드", fontSize = 13.sp)
                Text(text = "연결하고 내역보기", fontSize = 18.sp)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Container4Preview() {
    TossCloneProjectTheme {
        Container4()
    }
}