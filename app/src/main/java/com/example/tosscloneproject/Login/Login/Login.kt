package com.example.tosscloneproject.Login.Login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.Login.Compose.InputDots
import com.example.tosscloneproject.Login.Compose.NumberBoard
import com.example.tosscloneproject.Login.LoginViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TextColor3
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

//@Composable
//fun LoginNavigation (startRoute: NAV_ROUTE = NAV_ROUTE.Login) {
//    val navController = rememberNavController()
//    val routeAction = remember(NavController) {RouteAction(navController)}
//
//    NavHost( navController, startRoute.routeName) {
//
//        composable(NAV_ROUTE.Login.routeName) {
//            LoginPage (routeAction = routeAction)}
//        composable(NAV_ROUTE.Success.routeName) { SuccessPage(routeAction = routeAction)}
//        composable(NAV_ROUTE.MainPage.routeName) { MainPageView()}
//        composable(NAV_ROUTE.LoginFailed.routeName) {
//            LoginFailedPage(routeAction = routeAction)}
//    }
//}


@Composable
fun LoginPage (
    loginViewModel: LoginViewModel,
    routeAction: RouteAction
) {
    val pin = remember { mutableStateOf(listOf<String>()) }
    val useBio = remember { mutableStateOf(false) }
    val typography = MaterialTheme.typography
    val context = LocalContext.current

    Surface ( color = TextColor3 ){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(170.dp))
            Text(
                text = "이미 토스에 가입되어 있어요\n비밀번호를 입력해주세요",
                textAlign = TextAlign.Center,
                style = typography.bodyLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(38.dp))
            InputDots(numbers=pin.value)
            Spacer(modifier = Modifier.height(120.dp))

            NumberBoard( onNumberClick = { clickedNumber ->
                if (pin.value.size < 5) {
                    pin.value = pin.value + clickedNumber
                }
            } )

            if (pin.value.size == 5) {
                val password = pin.value.joinToString(separator = "")
                Log.d("LoginPage", "password : $password")  // 로그 출력
                loginViewModel.loginUser(password)
            }

            val loginResult by loginViewModel.loginResult.collectAsState()

            when (loginResult) {
                "Success" -> {
                    Log.d("LoginPage","success")
                    routeAction.navTo(NAV_ROUTE.Success)
                    pin.value = listOf()
                    loginViewModel.resetLoginResult()}

                "Failed" -> {
                    Log.d("LoginPage","fail")
                    routeAction.navTo(NAV_ROUTE.LoginFailed)
                    pin.value = listOf()
                    Toast.makeText(context, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            if (useBio.value) {
                useBio.value = false
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    TossCloneProjectTheme {

    }
}