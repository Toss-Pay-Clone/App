package com.example.tosscloneproject.myAssetsPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
        .height(120.dp)
        .background(color = Color.White)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                    navController.navigate("mainPage") // 뒤로가기
                }
            )
            Text(text = "편집",
                fontSize = 16.sp)
        }
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "자산",
                fontSize = 16.sp)
            Text(text = "자산 굴리기",
                fontSize = 16.sp)
            Text(text = "대출 찾기",
                fontSize = 16.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        TopBar(navController = navController)
    }
}