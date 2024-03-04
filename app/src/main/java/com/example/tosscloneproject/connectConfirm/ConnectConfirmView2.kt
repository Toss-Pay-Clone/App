가package com.example.tosscloneproject.connectConfirm

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
fun ConnectConfirmView2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Spacer(modifier = Modifier.height(40.dp))
        Container2(navController = navController)
    }
}
@Composable
fun Container2(navController: NavHostController) {
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
                text = "나희수님이 연결한\n1개의 은행에서 문자가\n올거에요",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.confirm_image1),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 400.dp, height = 300.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Green)
            ) {
                /*TODO*/
            }
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            CustomButton(contents = "확인했어요",
                navController = navController,
                route = "ConnectConfirm3")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun ConnectConfirm2Preview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        ConnectConfirmView2(navController = navController)
    }
}