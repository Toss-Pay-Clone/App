package com.example.tosscloneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Register.CheckPage
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossBlue
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Container()
                    CheckPage()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//온보딩 페이지
@Composable
fun Container () {
    Column {
        TextContainer()
    }
}


@Composable
fun TextContainer () {
    val typography = MaterialTheme.typography

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
                color = TextColor2)
            Row(
            ) {
                Text( text = "누적 다운로드",
                    style = typography.bodyMedium,
                    color = TextColor2)
                Text( text = " 4,000만",
                    style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = TossBlue)
                Text( text = ", 누적 보안사고",
                    style = typography.bodyMedium,
                    color = TextColor2)
                Text( text = " 0건",
                    style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = TossBlue)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TossCloneProjectTheme {
//        Greeting("Android")
//        Container()
        CheckPage()

    }
}