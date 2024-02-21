package com.example.tosscloneproject.Login.OnBoarding

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Page3 () {
    Column {
        Page3TextContainer()
        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(start = 28.dp, end = 28.dp)){
            com.example.tosscloneproject.Login.Compose.NumberInput(
                inputplaceholder = "휴대폰 번호")
        }
        Spacer(modifier = Modifier.height(40.dp))
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

        Page3()
    }
}