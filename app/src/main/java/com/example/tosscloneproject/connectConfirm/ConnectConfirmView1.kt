package com.example.tosscloneproject.connectConfirm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.tosscloneproject.publicComposable.CustomButton
import com.example.tosscloneproject.publicComposable.TopBar
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun ConnectConfirmView1(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Container()
    }
}
@Composable
fun Container() {
    Column(
        Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.clap),
                contentDescription = null
            )
            Text(
                text = "나희수님의\n자산 연결이 끝났어요",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(
                text = "은행",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(top = 40.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Green)
            ) {

            }
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            CustomButton(contents = "다음")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ConnectConfirmPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        ConnectConfirmView1(navController = navController)
    }
}