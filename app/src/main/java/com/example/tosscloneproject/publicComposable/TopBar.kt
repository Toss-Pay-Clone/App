package com.example.tosscloneproject.publicComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun TopBar(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(color = Color.White),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        navController.popBackStack() // 뒤로가기
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TopBarPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        TopBar(navController = navController)
    }
}