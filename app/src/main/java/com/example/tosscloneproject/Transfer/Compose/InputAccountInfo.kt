package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun InputAccountInfo() {
    Column(
        Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        TransferTitle(title = "어떤 계좌로 보낼까요?")
        Column(Modifier.padding(vertical = 15.dp)) {
            inputBoxUnderlineVersion(placeHolder = "계좌번호 입력")
            Spacer(modifier = Modifier.height(10.dp))
            inputBoxUnderlineVersion(placeHolder = "은행 선택")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputAccountInfoPreview() {
    TossCloneProjectTheme {
        InputAccountInfo()
    }
}