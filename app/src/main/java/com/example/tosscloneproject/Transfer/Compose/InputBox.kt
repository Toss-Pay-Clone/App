package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun InputBoxUnderlineVersion(placeHolder: String) {
    val textState = remember { mutableStateOf("") }

    BasicTextField(
        value = textState.value,
        onValueChange = { newText -> textState.value = newText },
        textStyle = TextStyle(fontSize = 18.sp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Column {
                when {
                    textState.value.isEmpty() -> {
                        Text(
                            text = placeHolder,
                            fontSize = 16.sp,
                            color = Color.Gray,
                        )
                    }
                    else -> {
                        Text(
                            text = placeHolder,
                            fontSize = 10.sp,
                            color = Color.Blue,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = textState.value,
                                maxLines = 1,
                                modifier = Modifier.widthIn(240.dp, 350.dp),
                            )
                            Surface(
                                shape = MaterialTheme.shapes.large,
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(20.dp)
                                    .align(Alignment.CenterVertically)
                                    .padding(horizontal = 10.dp),
                                color = Color.Gray,
                                onClick = { textState.value = "" }
                            ) {}
                        }
                    }
                }
                Spacer(modifier = Modifier
                    .padding(top = 4.dp)
                    .height(2.dp)
                    .fillMaxWidth()
                    .background(color = if (textState.value.isEmpty()) Color.LightGray else Color.Blue))
            }
        }
    }
}

@Composable
fun InputBoxRectVersion(placeHolder: String) {
    val textState = remember { mutableStateOf("") }

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .height(40.dp),
        color = Color.LightGray,
    ) {
        BasicTextField(
            value = textState.value,
            onValueChange = { newText -> textState.value = newText },
            textStyle = TextStyle(fontSize = 18.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.transfer_input_search),
                    contentDescription = "search",
                    Modifier
                        .padding(end = 8.dp)
                        .size(20.dp),
                )
                when {
                    textState.value.isEmpty() -> {
                        Text(
                            text = placeHolder,
                            fontSize = 14.sp,
                            color = Color.Gray,
                        )
                    }
                    else -> {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = textState.value,
                                maxLines = 1,
                                fontSize = 14.sp,
                            )
                            Surface(
                                shape = MaterialTheme.shapes.large,
                                modifier = Modifier
                                    .size(20.dp)
                                    .align(Alignment.CenterVertically),
                                color = Color.Gray,
                                onClick = { textState.value = "" }
                            ) {}
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputBoxUnderlineVersionPreview() {
    TossCloneProjectTheme {
        InputBoxUnderlineVersion("계좌번호 입력")
    }
}

@Preview(showBackground = true)
@Composable
fun InputBoxRectVersionPreview() {
    TossCloneProjectTheme {
        InputBoxRectVersion("검색/직접 입력")
    }
}