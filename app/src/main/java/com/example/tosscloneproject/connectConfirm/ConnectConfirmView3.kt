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
import androidx.compose.ui.res.stringResource
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
fun ConnectConfirmView3(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
        ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Container3(navController = navController)
    }
}
@Composable
fun Container3(navController: NavHostController) {
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
            Text(
                text = "토스 앱으로 돈을 보낼 수 있게\n계좌가 연결됐다는 내용이에요",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.confirm_image2),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .fillMaxWidth()
                    .size(width = 300.dp, height = 200.dp)
            )
            Text(
                text = "출금이체 자동이체라는 단어에 놀라지 마세요.",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = stringResource(id = R.string.ConfirmText),
                fontSize = 15.sp
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            CustomButton(contents = "확인했어요",
                navController = navController,
                route = "ConnectConfirm4")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ConnectConfirm3Preview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        ConnectConfirmView3(navController = navController)
    }
}