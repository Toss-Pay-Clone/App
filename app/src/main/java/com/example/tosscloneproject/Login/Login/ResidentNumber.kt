package com.example.tosscloneproject.Login.Login

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Compose.Button
import com.example.tosscloneproject.Login.Compose.NumberInput
import com.example.tosscloneproject.Login.Compose.UserInput
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor1
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
                    ResidentNumberPage()
                }
            }
        }
    }
}

@Composable
fun ResidentNumberPage() {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.number_image)

    Column (modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, top = 84.dp),
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {

            Text(
                text = "주민등록번호를 입력해주세요.",
                style = typography.titleLarge
            )

            Column {
                Text(text = "주민등록번호", style = typography.labelSmall)
                Row ( verticalAlignment = Alignment.CenterVertically ){
                    Box(modifier = Modifier.width(157.dp)) {
                        NumberInput(inputplaceholder = "", TrailingIcon = false)
                    }
                    Text(text = " - ", style = typography.titleLarge)
                    Box(modifier = Modifier.width(22.dp)) {
                        NumberInput(inputplaceholder = "", TrailingIcon = false)
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                    Image(painter = image, contentDescription = "Number")
                }
            }

            Column {
                Text(text = "이름", style = typography.labelSmall)
                Text(text = "오채영", style = typography.labelMedium, color = TextBlack,
                    modifier = Modifier.padding(top = 8.dp))
                Divider( color = TextColor1, modifier = Modifier.padding(top = 8.dp, end = 28.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ResidentNumberPagePreview() {
    TossCloneProjectTheme {

        ResidentNumberPage()
    }
}