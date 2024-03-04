package com.example.tosscloneproject.connectBank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun ConnectBankView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Container(navController = navController)
    }
}
@Composable
fun Container(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "아래 계좌를 연결할게요",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "은행",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp)
            )
            Text(
                text = "ℹ️해지된 계좌, 사업자계좌, 보안계좌, 출자금은 연결할 수 없어요.",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 10.dp)
            )
            // SelectBankView 에서 선택된 은행이 여기에 나타남
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray)
            ) {

            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "찾는 계좌가 없나요?",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = null
                )
            }
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            CustomButton(contents = "다음",
                navController = navController,
                route = "ConnectConfirm1")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ConnectBankPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        ConnectBankView(navController = navController)
    }
}