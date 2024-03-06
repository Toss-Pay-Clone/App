package com.example.tosscloneproject.Login.OnBoarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.Login.Compose.AnimatedPageSlide
import com.example.tosscloneproject.Login.Compose.BirthNumberViewModel
import com.example.tosscloneproject.Login.Compose.GenderNumberViewModel
import com.example.tosscloneproject.Login.Compose.PhoneNumberViewModel
import com.example.tosscloneproject.Login.Compose.TelecomViewModel
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.Login.LoginFailedPage
import com.example.tosscloneproject.Login.Login.LoginPage
import com.example.tosscloneproject.Login.Login.SuccessPage
import com.example.tosscloneproject.Login.LoginViewModel
import com.example.tosscloneproject.Login.Register.CheckPage
import com.example.tosscloneproject.Login.Register.NamePage
import com.example.tosscloneproject.Login.Register.ResidentNumberPage
import com.example.tosscloneproject.Login.Register.TelecomPage
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import kotlinx.coroutines.delay

class OnBoarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph()
                }
            }
        }
    }
}

// 네이게이션 라우트 enum (값을 가지는 enum)
enum class NAV_ROUTE (val routeName: String, val description: String) {
    Page1("Page1", "소개 화면"),
    Page2("Page2", "메세지 전송 화면"),
    Page3("Page3", "휴대폰 입력 화면"),
    Login("Login","비밀번호 입력 화면"),
    LoginFailed("LoginFailed","비밀번호 다시 입력"),
    Success("Success","로그인 성공시 나오는 화면"),
    Name("Name","회원가입 이름 입력 화면"),
    ResidentNumber("ResidentNumber","주민등록번호 입력 화면"),
    Telecom("Telecom","통신사 선택 화면"),
    Check("Check","정보 확인 화면"),
    MainPage("MainPage","메인화면")
}

// 네비게이션 라우트 액션
class RouteAction(navHostController: NavHostController) {

    // 특정 라우트로 이동
    val navTo: (NAV_ROUTE) -> Unit = { route ->
        navHostController.navigate(route.routeName)
    }

}


@Composable
fun NavigationGraph (startRoute: NAV_ROUTE = NAV_ROUTE.Page1) {

    // 네비게이션 컨트롤러
    val navController = rememberNavController()
    // 네비게이션 라우트 액션
    val routeAction = remember(navController) { RouteAction(navController) }
    val phoneNumberViewModel : PhoneNumberViewModel = viewModel()
    val userNameViewModel : UserNameViewModel = viewModel()
    val birthNumberViewModel : BirthNumberViewModel = viewModel()
    val genderNumberViewModel : GenderNumberViewModel = viewModel()
    val telecomViewModel : TelecomViewModel = viewModel()

    // 애니메이션
    val visible = remember { mutableStateOf(false) }
    val currentDestination = navController.currentBackStackEntryAsState()
    LaunchedEffect(currentDestination.value) {
        visible.value = false
        delay(80L)
        visible.value = true
    }


    // NavHost로 네비게이션 결정
    // 네비게이션 연결할 페이지 설정
    NavHost( navController, startRoute.routeName ) {

        // 라우트 이름 = 화면의 키, 화면 = 값
        composable(NAV_ROUTE.Page1.routeName) {
            AnimatedPageSlide(visible = visible.value) {
                Page1(routeAction = routeAction)
            }}
        composable(NAV_ROUTE.Page2.routeName){
            AnimatedPageSlide(visible = visible.value) {
                Page2(routeAction = routeAction)
            }}
        composable(NAV_ROUTE.Page3.routeName){
            AnimatedPageSlide(visible = visible.value) {
                Page3(phoneNumberViewModel = phoneNumberViewModel,
                    routeAction = routeAction)
            } }
        composable(NAV_ROUTE.Name.routeName){
            NamePage(routeAction=routeAction, userNameViewModel = userNameViewModel)
        }
        composable(NAV_ROUTE.ResidentNumber.routeName){
            ResidentNumberPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel)
        }
        composable(NAV_ROUTE.Telecom.routeName){
            TelecomPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel,
                telecomViewModel = telecomViewModel)
        }
        composable(NAV_ROUTE.Check.routeName){
            CheckPage(routeAction=routeAction, userNameViewModel = userNameViewModel,
                birthNumberViewModel = birthNumberViewModel, genderNumberViewModel = genderNumberViewModel,
                phoneNumberViewModel = phoneNumberViewModel, telecomViewModel = telecomViewModel)
        }
        composable(NAV_ROUTE.Login.routeName) {
            LoginPage (routeAction = routeAction,
                loginViewModel = LoginViewModel()
            )
        }
        composable(NAV_ROUTE.Success.routeName) {
            SuccessPage(routeAction = routeAction)
        }
        composable(NAV_ROUTE.LoginFailed.routeName) {
            LoginFailedPage(routeAction = routeAction,
                loginViewModel = LoginViewModel())
        }
        composable(NAV_ROUTE.MainPage.routeName){ MainPageView() }


    }
}


// 라우터로 인해 로그인 페이지에도 네비게이션 설정하면 다시 정리할 예정




@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    TossCloneProjectTheme {

        NavigationGraph()
    }
}