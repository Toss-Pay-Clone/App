package com.example.tosscloneproject.Login.Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.BirthNumberInput
import com.example.tosscloneproject.Login.Compose.BirthNumberViewModel
import com.example.tosscloneproject.Login.Compose.Button
import com.example.tosscloneproject.Login.Compose.GenderNumberInput
import com.example.tosscloneproject.Login.Compose.GenderNumberViewModel
import com.example.tosscloneproject.Login.Compose.PhoneNumberViewModel
import com.example.tosscloneproject.Login.Compose.PhonenumberInput
import com.example.tosscloneproject.Login.Compose.TelecomViewModel
import com.example.tosscloneproject.Login.Compose.UserInput
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor1
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class Check : ComponentActivity() {
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
fun CheckPage(routeAction: RouteAction, userNameViewModel: UserNameViewModel,
              birthNumberViewModel: BirthNumberViewModel, genderNumberViewModel: GenderNumberViewModel,
              phoneNumberViewModel: PhoneNumberViewModel, telecomViewModel: TelecomViewModel) {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.number_image)
    val arrow = painterResource(R.drawable.arrow_bottom)
    val userName by userNameViewModel.userName.collectAsState()
    val birthNumber by birthNumberViewModel.birthNumber.collectAsState()
    val genderNumber by genderNumberViewModel.genderNumber.collectAsState()
    val phoneNumber by phoneNumberViewModel.phoneNumber.collectAsState()
    val telecom by telecomViewModel.telecom.collectAsState()

    var showSheet by remember { mutableStateOf(false) }
    var selectedTelecom by remember { mutableStateOf("$telecom") }

    if (showSheet) {
        BottomSheet(onDismiss = { showSheet = false }) { telecom ->
            selectedTelecom = telecom
            showSheet = false
        }
    }

    Column (modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 84.dp),
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {

            Text(
                text = "입력한 정보를 확인해 주세요.",
                style = typography.titleLarge
            )

            PhonenumberInput(inputplaceholder = "$phoneNumber") { newPhone ->
                phoneNumberViewModel.setPhoneNumber(newPhone)
            }

            Column {
                Text(text = "통신사", style = typography.labelSmall)
                Row ( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = if (selectedTelecom == "$telecom") "$telecom" else selectedTelecom,
                        style = typography.labelMedium,
                        color = TextBlack,
                        modifier = Modifier.padding(top = 10.dp, start = 17.dp))
                    IconButton(onClick = { showSheet = true }) {
                        Image(painter = arrow, contentDescription = "arrow_bottom")
                    }
                }
                Divider( color = TextColor1, modifier = Modifier.padding(top = 10.dp))
            }

            Column {
                Text(text = "주민등록번호", style = typography.labelSmall)
                Row ( verticalAlignment = Alignment.CenterVertically ){
                    Box(modifier = Modifier.width(134.dp)) {
                        BirthNumberInput(inputplaceholder = "$birthNumber") { newBirth ->
                            birthNumberViewModel.setBirthNumber(newBirth)
                        }
                    }
                    Text(text = " - ", style = typography.titleLarge)
                    Box(modifier = Modifier.width(45.dp)) {
                        GenderNumberInput(inputplaceholder = "$genderNumber") { newGender ->
                            genderNumberViewModel.setGenderNumber(newGender)
                        }
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

            Spacer(modifier = Modifier.height(100.dp))
            Button(buttonText = "확인",
                paddingValues = PaddingValues(start = 152.dp, end = 152.dp, top = 21.dp, bottom = 21.dp),
                route = NAV_ROUTE.MainPage, routeAction = routeAction)
        }
    }
}


