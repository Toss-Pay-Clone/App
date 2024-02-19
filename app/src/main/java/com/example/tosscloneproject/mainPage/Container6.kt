package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@Composable
fun Container6() {
    // wrapper
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "나희수 님을 위해 준비했어요",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        // item1
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
            )
            Text("보험 전문가에게 물어보기", fontSize = 16.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )

        }
        // item2
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
            )
            Text("LG U+ 휴대폰 요금제", fontSize = 16.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )

        }
        // item3
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
            )
            Text("내 통신 요금", fontSize = 16.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }
        Divider(thickness = 1.dp, color = Color(0xFFF2F4F5),
            modifier = Modifier.padding(20.dp))
        // item4
        Row(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
        ) {
            Text(text = "추천 서비스 더보기", color = Color(0xFF6B7684), fontSize = 16.sp)
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Container6Preview() {
    TossCloneProjectTheme {
        Container6()
    }
}