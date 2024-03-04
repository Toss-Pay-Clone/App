package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun ContactListItem(
    contactName: String,
    phoneNumber: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .size(42.dp)
                    .padding(2.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "ProfileIcon",
                )
            }
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Column {
                Text(
                    text = contactName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = phoneNumber,
                    color = Color.Gray,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListItemPreview() {
    TossCloneProjectTheme {
        ContactListItem(
            "홍길동",
            "010-1234-5678"
        )
    }
}