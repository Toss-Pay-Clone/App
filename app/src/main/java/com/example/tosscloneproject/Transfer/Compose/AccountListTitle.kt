package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun MyAccount() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "내 계좌", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text(text = "+n개 >", fontSize = 11.sp, fontWeight = FontWeight.Normal)
        }
    }
}

@Composable
fun RecentlyAccount() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "최근 보낸 계좌", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAccountPreview() {
    TossCloneProjectTheme {
        MyAccount()
    }
}

@Preview(showBackground = true)
@Composable
fun RecentlyAccountPreview() {
    TossCloneProjectTheme {
        RecentlyAccount()
    }
}