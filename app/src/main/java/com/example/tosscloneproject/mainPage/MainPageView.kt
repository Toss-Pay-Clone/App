package com.example.tosscloneproject.mainPage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPageView(navController: NavHostController) {
    Scaffold(
        containerColor = Color(0xFFF3F4F6),
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
    ) {
        ScrollContent(navController = navController)
    }
}

@Composable
fun ScrollContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 70.dp, horizontal = 20.dp)
            .background(Color(0xFFF2F4F5)),
    ) {
        Container1()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container2()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container3(navController = navController) // 내 자산 페이지 이동
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container4()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container5()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container6()
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        Container7()
        Spacer(modifier = Modifier.padding(vertical = 30.dp))
        Container8()
        Spacer(modifier = Modifier.padding(vertical = 30.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun MainPageViewPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        MainPageView(navController = navController)    }
}