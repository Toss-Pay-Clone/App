package com.example.tosscloneproject.Login.OnBoarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TossBlue
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

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
    Page3("Page3", "휴대폰 입력 화면")
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

    // NavHost로 네비게이션 결정
    // 네비게이션 연결할 페이지 설정
    NavHost( navController, startRoute.routeName ) {

        // 라우트 이름 = 화면의 키
        composable(NAV_ROUTE.Page1.routeName) {
            // 화면 = 값
            Page1(routeAction = routeAction) }
        composable(NAV_ROUTE.Page2.routeName){
            Page2(routeAction = routeAction)
        }
        composable(NAV_ROUTE.Page3.routeName){
            Page3()
        }
    }
}


// 라우터로 인해 로그인 페이지에도 네비게이션 설정하면 다시 정리할 예정
@Composable
fun Button (buttonText : String, paddingValues: PaddingValues, route: NAV_ROUTE, routeAction: RouteAction) {
    val typography = MaterialTheme.typography

    Column ( modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        androidx.compose.material3.Button(
            enabled = true,
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(TossBlue),
            contentPadding = paddingValues,
            onClick = { routeAction.navTo(route) }) {

            Text(text = "$buttonText",
                style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color.White)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    TossCloneProjectTheme {

        NavigationGraph()
    }
}