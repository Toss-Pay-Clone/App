package com.example.tosscloneproject.Transfer.Page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Transfer.Compose.AccountListItem
import com.example.tosscloneproject.Transfer.Compose.ContactListItem
import com.example.tosscloneproject.Transfer.Compose.InputBoxRectVersion
import com.example.tosscloneproject.Transfer.Compose.MyAccount
import com.example.tosscloneproject.Transfer.Compose.RecentlyAccount
import com.example.tosscloneproject.Transfer.Compose.SelectTransfer
import com.example.tosscloneproject.Transfer.Compose.TransferHeader
import com.example.tosscloneproject.Transfer.Compose.inputBoxUnderlineVersion
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun TransferSelectPage(modifier: Modifier = Modifier) {
    val isAccountMode = remember {
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.padding(horizontal = 20.dp)) {
            TransferHeader("")
            Spacer(Modifier.padding(vertical = 10.dp))
            SelectTransfer(isAccountMode.value) { newValue ->
                isAccountMode.value = newValue
            }

            if (isAccountMode.value)
                Column(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                    Surface(
                        onClick = { /* */}
                    ) {
                        inputBoxUnderlineVersion(placeHolder = "계좌번호 입력")
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Column {
                        MyAccount()
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                        AccountListItem(
                            "토스뱅크 통장",
                            "토스뱅크",
                            "123400009876",
                            true
                        )
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))

                        RecentlyAccount()
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                        AccountListItem(
                            "홍길동",
                            "KB국민",
                            "000000000002",
                            false
                        )
                        AccountListItem(
                            "강호동",
                            "하나",
                            "000000000003",
                            false
                        )
                    }
                }
            else {
                Column(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                    Spacer(modifier = Modifier.height(10.dp))
                    InputBoxRectVersion("검색/직접 입력")
                    Spacer(modifier = Modifier.height(10.dp))
                    Column {
                        ContactListItem(
                            "홍길동",
                            "010-1234-5678"
                        )
                        ContactListItem(
                            "강호동",
                            "010-9999-8888"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferSelectPagePreview() {
    TossCloneProjectTheme {
        TransferSelectPage()
    }
}