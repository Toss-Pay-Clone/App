package com.example.tosscloneproject.Login.Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.Button
import com.example.tosscloneproject.Login.Compose.UserInput
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class Name : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun NamePage(routeAction: RouteAction, userNameViewModel: UserNameViewModel) {
    val typography = MaterialTheme.typography
//    val viewModel : UserNameViewModel = viewModel()
    val userName by userNameViewModel.userName.collectAsState()

    Column (modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 84.dp)
        ) {

            Text(
                text = "이름을 입력해주세요.",
                style = typography.titleLarge
            )

            Spacer(modifier = Modifier.height(36.dp))
            Column {
                Text(text = "이름", style = typography.labelSmall)
                UserInput (inputplaceholder = "") { newName ->
                    userNameViewModel.setUserName(newName)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            buttonText = "확인",
            paddingValues = PaddingValues(start = 189.5.dp, end = 189.5.dp, top = 21.dp, bottom = 21.dp),
            shape = RectangleShape, route = NAV_ROUTE.ResidentNumber, routeAction = routeAction
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NamePreview() {
    TossCloneProjectTheme {


    }
}