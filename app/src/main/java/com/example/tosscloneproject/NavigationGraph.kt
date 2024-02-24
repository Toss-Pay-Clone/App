package com.example.tosscloneproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.myAssetsPage.MyAssetsPageView

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("mainPage") {
            MainPageView(navController = navController) // 메인 페이지
        }
        composable("checkPassword") {// 비밀번호 확인
            CheckPassword(navController = navController)
        }
        composable("myAssetsPage") {
            MyAssetsPageView(navController = navController) // 내 자산 페이지
        }
    }
}

