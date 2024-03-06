package com.example.tosscloneproject.Login.OnBoarding

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.Login.Compose.PhoneNumberViewModel
import com.example.tosscloneproject.Login.Compose.PhonenumberInput
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



@Composable
fun Page3 (phoneNumberViewModel: PhoneNumberViewModel,
                   routeAction: RouteAction) {

    Column {
        Page3TextContainer()
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(start = 28.dp, end = 28.dp)){
            PhonenumberInput(inputplaceholder = "휴대폰 번호",
                onDone = { phoneNumberViewModel.checkPhoneNumber() }) { newPhone ->
                phoneNumberViewModel.setPhoneNumber(newPhone)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        val phoneNumber = phoneNumberViewModel.phoneNumber.collectAsState().value
        val phoneResponse by phoneNumberViewModel.phoneResponse.collectAsState()

        LaunchedEffect(phoneResponse) {
            phoneResponse?.let {
                Log.d("Page3",it.message)
                Log.d("Page3", "LaunchedEffect executed")
                if (it.message == "전화번호 확인이 완료되었습니다.") {
                    routeAction.navTo(NAV_ROUTE.Login)
                } else if (
                    it.httpStatus.toString() == "404" &&
                    it.error == "NOT_FOUND" &&
                    it.message == "해당 전화번호로 가입된 계정이 없습니다.") {
                    routeAction.navTo(NAV_ROUTE.Name)
                }
            }
        }
    }
}


@Composable
fun Page3TextContainer() {
    val typography = MaterialTheme.typography

    Column ( modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, top = 76.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Text( text = "휴대폰 번호를 입력해주세요",
                style = typography.titleLarge.copy(fontSize = 25.sp))
            Column {
                Text( text = "회원가입 여부 확인에 이용됩니다.",
                    style = typography.bodyMedium,
                    color = TextColor2
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Page3Preview() {
    TossCloneProjectTheme {


    }
}