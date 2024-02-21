package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun SelectTransfer() {
    val isAccountMode = remember {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()) {
        Text(text = "어디로 돈을 보낼까요?", style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp))

        Spacer(modifier = Modifier.height(30.dp))

        Surface(shape = MaterialTheme.shapes.small, color = Color.LightGray, modifier = Modifier.height(45.dp)) {
            val textModifier = Modifier.padding(10.dp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .padding(3.dp)
                        .weight(1f),
                    color = if (isAccountMode.value) Color.White else Color.LightGray,
                    onClick = { isAccountMode.value = true },
                ) {
                    Text(
                        text = "계좌",
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(fontSize = 12.sp),
                        modifier = textModifier,
                    )
                }
                Surface(
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .padding(3.dp)
                        .weight(1f),
                    color = if (isAccountMode.value) Color.LightGray else Color.White,
                    onClick = { isAccountMode.value = false },
                ) {
                    Text(
                        text = "연락처",
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(fontSize = 12.sp),
                        modifier = textModifier,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectTransferPreview() {
    TossCloneProjectTheme {
        SelectTransfer()
    }
}