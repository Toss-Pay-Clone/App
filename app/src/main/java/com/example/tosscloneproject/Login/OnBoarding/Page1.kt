package com.example.tosscloneproject.Login.OnBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.Button
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossBlue


@Composable
fun Page1 (routeAction: RouteAction) {
    Column {
        Page1TextContainer()
        Button(buttonText = "시작하기",
            paddingValues = PaddingValues(start = 144.dp, end = 144.dp, top = 21.dp, bottom = 21.dp),
            route = NAV_ROUTE.Page2, routeAction = routeAction
        )
    }
}
@Composable
fun Page1TextContainer () {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.private_image)

    Column ( modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, top = 76.dp),
            verticalArrangement = Arrangement.spacedBy(34.dp)
        ) {
            Text( text = "금융의 모든 것\n토스에서 간편하게",
                style = typography.titleLarge)
            Column {
                Text( text = "토스는 안전합니다.",
                    style = typography.bodyMedium,
                    color = TextColor2
                )
                Row {
                    Text( text = "누적 다운로드",
                        style = typography.bodyMedium,
                        color = TextColor2
                    )
                    Text( text = " 4,000만",
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = TossBlue
                    )
                    Text( text = ", 누적 보안사고",
                        style = typography.bodyMedium,
                        color = TextColor2
                    )
                    Text( text = " 0건",
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = TossBlue
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(422.dp))
        Row ( horizontalArrangement = Arrangement.spacedBy(8.dp)){
            Image(
                painter = image,
                contentDescription = "Private",
                modifier = Modifier
                    .width(23.dp)
                    .height(27.dp)
            )
            Text(text = "개인 정보 보호 모드 작동 중",
                style = typography.bodyMedium,
                color = TextColor2
            )
        }
        Spacer(modifier = Modifier.height(34.dp))
    }

}


