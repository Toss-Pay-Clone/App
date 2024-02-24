package com.example.tosscloneproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun CheckPassword(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFF3B424C)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.navigate("mainPage")
                    }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 60.dp))
        Text(
            text = "토스에서 사용하는\n비밀번호를 입력해주세요.",
            style = typography.titleLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Text(
            text = "숫자 4자 + 영문자 1자리",
            style = typography.bodyMedium,
            color = TextColor2
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Row(
            modifier = Modifier
                .width(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.password_click),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.password_click),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.password_click),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.password_click),
                contentDescription = null
            )
            Image(painter = painterResource(id = R.drawable.add), contentDescription = null)
            Image(
                painter = painterResource(id = R.drawable.password_click),
                contentDescription = null
            )

        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Button(
            onClick = {
                navController.navigate(route = "myAssetsPage")
            },
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(25),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF5A606E), // Container
                Color(0xFFFFFFFF)  // Content
            )
        ) {
            Text(
                text = "비밀번호를 몰라요",
                style = typography.bodySmall
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 100.dp))
        CustomNumKeyboard()
    }
}


@Composable
@Preview(showBackground = true)
fun CheckPasswordPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        CheckPassword(navController = navController)
    }
}