package com.example.tosscloneproject.Login.Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.Login.Compose.BirthNumberViewModel
import com.example.tosscloneproject.Login.Compose.GenderNumberViewModel
import com.example.tosscloneproject.Login.Compose.PhoneNumberViewModel
import com.example.tosscloneproject.Login.Compose.TelecomViewModel
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    RegisterNavigation()
                }
            }
        }
    }
}



@Composable
fun RegisterNavigation (startRoute: NAV_ROUTE = NAV_ROUTE.Name) {

    // 네비게이션 컨트롤러
    val navController = rememberNavController()

    // 네비게이션 라우트 액션
    val routeAction = remember(navController) { RouteAction(navController) }

    val userNameViewModel : UserNameViewModel = viewModel()
    val birthNumberViewModel : BirthNumberViewModel = viewModel()
    val genderNumberViewModel : GenderNumberViewModel = viewModel()
    val telecomViewModel : TelecomViewModel = viewModel()
    val phoneNumberViewModel : PhoneNumberViewModel = viewModel()

    // NavHost로 네비게이션 결정
    // 네비게이션 연결할 페이지 설정
    NavHost( navController, startRoute.routeName ) {

        // 라우트 이름 = 화면의 키
            // 화면 = 값
        composable(NAV_ROUTE.Name.routeName){
            NamePage(routeAction=routeAction, userNameViewModel = userNameViewModel)}
        composable(NAV_ROUTE.ResidentNumber.routeName){
            ResidentNumberPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel)}
        composable(NAV_ROUTE.Telecom.routeName){
            TelecomPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel,
                telecomViewModel = telecomViewModel)}
        composable(NAV_ROUTE.Check.routeName){
            CheckPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel,
                phoneNumberViewModel = phoneNumberViewModel, telecomViewModel = telecomViewModel)}
        composable(NAV_ROUTE.MainPage.routeName){ MainPageView() }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    TossCloneProjectTheme {
        RegisterNavigation()

    }
}