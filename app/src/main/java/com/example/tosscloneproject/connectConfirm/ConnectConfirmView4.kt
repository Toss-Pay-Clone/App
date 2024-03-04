package com.example.tosscloneproject.connectConfirm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun ConnectConfirmView4(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Container4(navController = navController)
    }
}

@Composable
fun Container4(navController: NavHostController) {
    Column(
        Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            Text(
                text = "이제 토스앱으로 계좌에서\n돈을 보낼 수 있어요",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.confirm_image3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 200.dp)
                    .size(width = 300.dp, height = 200.dp)
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            CustomButton(contents = "확인했어요",
                navController = navController,
                route = "MainPage")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ConnectConfirm4Preview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        ConnectConfirmView4(navController = navController)
    }
}