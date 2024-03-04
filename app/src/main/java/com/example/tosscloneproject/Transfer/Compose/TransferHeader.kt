package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun TransferHeader(location: String) {
    Row(Modifier.padding(top = 10.dp, bottom = 10.dp)) {
        val imageModifier = Modifier
            .size(24.dp)
        Surface (
            shape = MaterialTheme.shapes.small,
            modifier = imageModifier,
            onClick = {
                /* Redirect TO DO */
            }
        ) {
            Image(
                painter = painterResource(R.drawable.transfer_header_back),
                contentDescription = "Page Backward",
            )
        }
        if (location != "") {
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = location, modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferHeaderPreview() {
    TossCloneProjectTheme {
        TransferHeader("토스뱅크 송금")
    }
}