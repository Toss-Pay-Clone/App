package com.example.tosscloneproject.Transfer.Compose

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .padding(horizontal = 10.dp)
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

@Preview(showBackground = true)
@Composable
fun InputBoxUnderlineVersionPreview() {
    TossCloneProjectTheme {
        InputBoxUnderlineVersion("계좌번호 입력")
    }
}