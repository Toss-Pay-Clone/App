package com.example.tosscloneproject.Login.Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.BirthNumberInput
import com.example.tosscloneproject.Login.Compose.BirthNumberViewModel
import com.example.tosscloneproject.Login.Compose.GenderNumberInput
import com.example.tosscloneproject.Login.Compose.GenderNumberViewModel
import com.example.tosscloneproject.Login.Compose.UserInput
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class ResidentNumber : ComponentActivity() {
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
fun ResidentNumberPage(routeAction: RouteAction, userNameViewModel: UserNameViewModel,
                       birthNumberViewModel: BirthNumberViewModel, genderNumberViewModel: GenderNumberViewModel) {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.number_image)
    val userName by userNameViewModel.userName.collectAsState()
    val birthNumber by birthNumberViewModel.birthNumber.collectAsState()
    val genderNumber by genderNumberViewModel.genderNumber.collectAsState()

    Column (modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 84.dp),
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {

            Text(
                text = "주민등록번호를 입력해주세요.",
                style = typography.titleLarge
            )

            Column {
                Text(text = "주민등록번호", style = typography.labelSmall)
                Row ( verticalAlignment = Alignment.CenterVertically ){
                    Box(modifier = Modifier.width(134.dp)) {
                        BirthNumberInput(inputplaceholder = "") { newBirth ->
                            birthNumberViewModel.setBirthNumber(newBirth)
                        }
                    }
                    Text(text = " - ", style = typography.titleLarge)
                    Box(modifier = Modifier.width(45.dp)) {
                        GenderNumberInput(inputplaceholder = "",
                            onDone = {routeAction.navTo(NAV_ROUTE.Telecom)}) { newGender ->
                            genderNumberViewModel.setGenderNumber(newGender) }
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                    Image(painter = image, contentDescription = "Number")
                }
            }

            Column {
                Text(text = "이름", style = typography.labelSmall)
                UserInput (inputplaceholder = "$userName") { newName ->
                    userNameViewModel.setUserName(newName)
                }
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun ResidentNumberPagePreview() {
    TossCloneProjectTheme {

    }
}