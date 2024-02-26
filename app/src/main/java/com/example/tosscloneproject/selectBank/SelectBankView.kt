package com.example.tosscloneproject.selectBank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun SelectBankView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopBar(navController = navController)
        Bank()
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        SelectBankView(navController = navController)
    }
}