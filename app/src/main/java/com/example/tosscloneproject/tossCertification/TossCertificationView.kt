package com.example.tosscloneproject.tossCertification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
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
fun TossCertificationView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Containter()
    }
}

@Composable
fun Containter() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "계좌를 연결하기 위해\n토스인증서로 인증할게요",
                fontSize = 20.sp,
            )
            Box(
                modifier = Modifier
                    .padding(bottom = 200.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.certification),
                    contentDescription = "Certification",
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 60.dp, bottom = 60.dp)
                ) {
                    Text(text = "나희수",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "2026.01.25 만료",
                        fontSize = 12.sp,
                        color = Color.Gray)
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(contents = "다음")
            Text(
                text = "다른방법으로인증",
                fontSize = 14.sp,
                color = Color.Gray,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TossCertificationPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        TossCertificationView(navController = navController)
    }
}