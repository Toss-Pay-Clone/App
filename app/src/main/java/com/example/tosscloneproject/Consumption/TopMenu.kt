package com.example.tosscloneproject.Consumption

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TextColor3
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme



@Composable
fun TopMenu( ) {

    Column (modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)) {

        Spacer(modifier = Modifier.height(10.dp))
        IconButton(onClick = { }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "go home" )
        }
        Spacer(modifier = Modifier.height(22.dp))
        SelectMenu()
    }
}

@Composable
fun SelectMenu() {
    val MyConsumption = remember { mutableStateOf(true) }
    var typography = MaterialTheme.typography

    Box ( Modifier
        .padding(start = 28.dp, end = 28.dp)){

        Row {

            Surface(
                onClick = { MyConsumption.value = true }) {
                Column ( horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(177.dp)) {
                    Text(text = "내 소비",
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = if (MyConsumption.value) TextBlack else TextColor2,
                        modifier = Modifier.padding(bottom = 12.dp))
                    Divider( thickness = 2.dp,
                        color = if (MyConsumption.value) TextColor3 else Color(0xfff5f5f5))
                }
            }

            Surface(
                onClick = { MyConsumption.value = false }) {
                Column ( horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(177.dp)) {
                    Text(text = "카드 추천",
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = if (MyConsumption.value) TextColor2 else TextBlack,
                        modifier = Modifier.padding(bottom = 12.dp))
                    Divider( thickness = 2.dp,
                        color = if (MyConsumption.value) Color(0xfff5f5f5) else TextColor3)
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun TopMenuPreview() {
    TossCloneProjectTheme {

        TopMenu()
    }
}