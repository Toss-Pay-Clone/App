package com.example.tosscloneproject.Transfer.Page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.tosscloneproject.Transfer.Compose.InputBoxUnderlineVersionDeco
import com.example.tosscloneproject.Transfer.Compose.ModalGallery
import com.example.tosscloneproject.Transfer.Compose.TransferHeader
import com.example.tosscloneproject.Transfer.Compose.TransferTitle
import com.example.tosscloneproject.Transfer.Compose.inputBoxUnderlineVersion
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun InputAccountPage() {
    val isModalOpen = remember {
        mutableStateOf(false)
    }
    val selectedBank = remember {
        mutableStateOf("")
    }
    val accountNumber = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.padding(horizontal = 20.dp)) {
                TransferHeader("")
                Spacer(Modifier.padding(vertical = 10.dp))
                TransferTitle(title = "어느 계좌로 보낼까요?")
                Spacer(Modifier.padding(vertical = 10.dp))
                accountNumber.value = inputBoxUnderlineVersion(placeHolder = "계좌번호 입력")
                Spacer(Modifier.padding(vertical = 10.dp))
                InputBoxUnderlineVersionDeco(placeHolder = "은행 선택", selectedBank.value) {
                    isModalOpen.value = true
                }
            }

            if (selectedBank.value.isNotEmpty() && accountNumber.value.isNotEmpty()) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(15.dp),
                    color = Color(0xFF0077FF),
                    onClick = {}
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "확인",
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
    if (isModalOpen.value) {
        ModalGallery { newValue ->
            if (!newValue.isNullOrEmpty())
                selectedBank.value = newValue
            isModalOpen.value = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputAccountPagePreview() {
    TossCloneProjectTheme {
        InputAccountPage()
    }
}