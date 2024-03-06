package com.example.tosscloneproject.Login.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.Login.Compose.InputDots
import com.example.tosscloneproject.Login.Compose.NumberBoard
import com.example.tosscloneproject.Login.Compose.UserNameViewModel
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TextColor3
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import kotlinx.coroutines.delay

@Composable
fun SuccessPage ( routeAction: RouteAction) {
    val typography = MaterialTheme.typography

    LaunchedEffect(Unit) {
        delay(2000L)
        routeAction.navTo(NAV_ROUTE.MainPage)
    }

    Surface ( modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background ){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "로그인 완료!",
                style = typography.labelMedium,
                color = TextColor2
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "환영합니다!",
                textAlign = TextAlign.Center,
                style = typography.titleLarge.copy(lineHeight = 45.sp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessPreview() {
    TossCloneProjectTheme {

    }
}