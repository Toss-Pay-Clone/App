package com.example.tosscloneproject.Login.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.Login.Compose.InputDots
import com.example.tosscloneproject.Login.Compose.NumberBoard
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.NavigationGraph
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TextColor3
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@Composable
fun LoginNavigation (startRoute: NAV_ROUTE = NAV_ROUTE.Login) {
    val navController = rememberNavController()
    val routeAction = remember(NavController) {RouteAction(navController)}

    NavHost( navController, startRoute.routeName) {

        composable(NAV_ROUTE.Login.routeName) { LoginPage (routeAction = routeAction)}
        composable(NAV_ROUTE.Success.routeName) { SuccessPage(routeAction = routeAction)}
        composable(NAV_ROUTE.MainPage.routeName) { MainPageView()}
    }
}

@Composable
fun LoginPage (
    routeAction: RouteAction
) {
    val pin = remember { mutableStateListOf<Int>() }
    val useBio = remember { mutableStateOf(false) }
    var typography = MaterialTheme.typography

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
            InputDots(numbers=pin)
            Spacer(modifier = Modifier.height(120.dp))

            NumberBoard( onNumberClick = { clickedNumber ->
                val number = clickedNumber.toIntOrNull()
                if (number != null && pin.size < 6) {
                    pin.add(number)
                }
            } )

            if (pin.size == 6) { routeAction.navTo(NAV_ROUTE.Success) }
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