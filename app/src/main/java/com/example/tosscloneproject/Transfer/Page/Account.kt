package com.example.tosscloneproject.Transfer.Page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Transfer.Compose.InputBoxUnderlineVersion
import com.example.tosscloneproject.Transfer.Compose.SelectTransfer
import com.example.tosscloneproject.Transfer.Compose.TransferHeader
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Account(myAccount: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.padding(horizontal = 20.dp)) {
            TransferHeader("")
            Spacer(Modifier.padding(vertical = 10.dp))
            SelectTransfer()

            Column(Modifier.padding(vertical = 5.dp)) {
                InputBoxUnderlineVersion(placeHolder = "계좌번호 입력")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    TossCloneProjectTheme {
        Account("토스뱅크 1004")
    }
}