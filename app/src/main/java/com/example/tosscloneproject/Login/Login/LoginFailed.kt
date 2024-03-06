package com.example.tosscloneproject.Login.Login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.InputDots
import com.example.tosscloneproject.Login.Compose.NumberBoard
import com.example.tosscloneproject.Login.LoginViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.ui.theme.TextColor3

@Composable
fun LoginFailedPage (
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
                text = "비밀번호를 다시 입력해주세요.",
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
                val loginPin = pin.value.joinToString(separator = "")
                Log.d("LoginPage", "Login PIN: $loginPin")  // 로그 출력
                loginViewModel.loginUser(loginPin)
            }

            val loginResult by loginViewModel.loginResult.collectAsState()

            when (loginResult) {
                "Success" -> {
                    Log.d("LoginFailPage","success")
                    routeAction.navTo(NAV_ROUTE.Success)}
                "Failed" -> {
                    Log.d("LoginFailPage","fail")
                    routeAction.navTo(NAV_ROUTE.LoginFailed)
                    Toast.makeText(context, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            if (useBio.value) {
                useBio.value = false
            }
        }
    }
}