package com.example.tosscloneproject.Login.OnBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextColor2

@Composable
fun Page2 (routeAction: RouteAction) {
    Column {
        Page2TextContainer()
        Spacer(modifier = Modifier.height(90.dp))
        Button(buttonText = "동의하고 인증하기",
            paddingValues = PaddingValues(start = 105.dp, end = 105.dp, top = 21.dp, bottom = 21.dp),
            route = NAV_ROUTE.Page3, routeAction = routeAction)
    }
}
@Composable
fun Page2TextContainer() {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.message_image)

    Column ( modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, top = 76.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Text( text = "문자메시지를 보내주세요",
                style = typography.titleLarge.copy(fontSize = 25.sp))
            Column {
                Text( text = "문자 메시지를 통해 휴대폰 본인 확인에\n이용됩니다. 문자의 내용을 수정없이 보내주세요.",
                    style = typography.bodyMedium.copy(lineHeight = 25.sp),
                    color = TextColor2
                )

            }
        }
        Spacer(modifier = Modifier.height(90.dp))
        Image(
            painter = image,
            contentDescription = "message"
        )
    }

}