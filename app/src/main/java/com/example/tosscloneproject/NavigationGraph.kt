package com.example.tosscloneproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.connectConfirm.ConnectConfirmView1
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.myAssetsPage.AssetList
import com.example.tosscloneproject.myAssetsPage.MyAssetsPageView
import com.example.tosscloneproject.publicComposable.CheckPassword
import com.example.tosscloneproject.selectBank.SelectBankView
import com.example.tosscloneproject.tossCertification.TossCertificationView

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("MainPage") {
            MainPageView(navController = navController) // 메인 페이지
        }
        composable("CheckPassword") {// 비밀번호 확인
            CheckPassword(navController = navController)
        }
        composable("MyAssetsPage") {
            MyAssetsPageView(navController = navController) // 내 자산 페이지
        }
        composable("AssetList") {
            AssetList(navController = navController) // bottom sheet 내의 은행
        }
        composable("SelectBank") {
            SelectBankView(navController = navController) // 은행 선택 페이지
        }
        composable("TossCertification") {
            TossCertificationView(navController = navController)
        }
        composable("ConnectConfirm1") {
            ConnectConfirmView1(navController = navController)
        }
    }
}

