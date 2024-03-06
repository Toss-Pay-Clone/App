package com.example.tosscloneproject.publicComposable//package com.example.tosscloneproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomNumKeyboard() {
    val inputVal = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NumberBtn(number = 1, modifier = Modifier.weight(1f))
            NumberBtn(number = 2, modifier = Modifier.weight(1f))
            NumberBtn(number = 3, modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NumberBtn(number = 4, modifier = Modifier.weight(1f))
            NumberBtn(number = 5, modifier = Modifier.weight(1f))
            NumberBtn(number = 6, modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NumberBtn(number = 7, modifier = Modifier.weight(1f))
            NumberBtn(number = 8, modifier = Modifier.weight(1f))
            NumberBtn(number = 9, modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            NumberBtn(number = 0, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun NumberBtn( number: Int, modifier: Modifier = Modifier) {
    val number = number
    OutlinedButton(
        onClick = { },
        modifier = modifier
//            .aspectRatio(1f)
            .padding(4.dp),
        border = null
    ) {
        Text(text = number.toString(),
            fontSize = 35.sp,
            color = Color.White)
    }
}
