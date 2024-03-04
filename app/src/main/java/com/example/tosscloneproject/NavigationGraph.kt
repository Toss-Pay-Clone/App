package com.example.tosscloneproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.connectBank.ConnectBankView
import com.example.tosscloneproject.connectConfirm.ConnectConfirmView1
import com.example.tosscloneproject.connectConfirm.ConnectConfirmView2
import com.example.tosscloneproject.connectConfirm.ConnectConfirmView3
import com.example.tosscloneproject.connectConfirm.ConnectConfirmView4
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
        composable("MainPage") {// 메인 페이지
            MainPageView(navController = navController)
        }
        composable("CheckPassword") {// 비밀번호 확인
            CheckPassword(navController = navController)
        }
        composable("MyAssetsPage") {// 내 자산 페이지
            MyAssetsPageView(navController = navController)
        }
        composable("AssetList") {// bottom sheet 내의 은행
            AssetList(navController = navController)
        }
        composable("SelectBank") {// 은행 선택 페이지
            SelectBankView(navController = navController)
        }
        composable("ConnectBank") { // 은행 연결 페이지
            ConnectBankView(navController = navController)
        }
        composable("TossCertification") { // 토스인증서
            TossCertificationView(navController = navController)
        }
        composable("ConnectConfirm1") { // 연결확인1
            ConnectConfirmView1(navController = navController)
        }
        composable("ConnectConfirm2") { // 연결확인2
            ConnectConfirmView2(navController = navController)
        }
        composable("ConnectConfirm3") { // 연결확인3
            ConnectConfirmView3(navController = navController)
        }
        composable("ConnectConfirm4") { // 연결확인4
            ConnectConfirmView4(navController = navController)
        }

    }
}

