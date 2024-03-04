package com.example.tosscloneproject.selectBank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun TopBar(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack() // 뒤로가기
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "search",
                modifier = Modifier.size(30.dp))
        }
        Text(
            text = "어떤 자산을 연결할까요?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
        )
        ScrollableOptions(
            listOf("은행", "카드", "증권", "포인트", "보험", "저축은행", "할부금융", "통신사")
        )
    }
}
@Composable
fun ScrollableOptions(options: List<String>) {
    LazyRow(
        modifier = Modifier.padding(top = 20.dp, bottom = 10.dp, start = 30.dp, end = 30.dp)
    ) {
        items(options) { option ->
            if (option == "은행") {
                Text(
                    text = option,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 22.dp)
                )
            } else {
                Text(
                    text = option,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                    modifier = Modifier.padding(end = 22.dp)
                )
            }
        }
    }
    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        TopBar(navController = navController)
    }
}