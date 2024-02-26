package com.example.tosscloneproject.myAssetsPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun MyAssetsPageView(navController: NavHostController)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(navController = navController)
        Container1()
        Container2(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MyAssetsPagePreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        MyAssetsPageView(navController = navController)
    }
}