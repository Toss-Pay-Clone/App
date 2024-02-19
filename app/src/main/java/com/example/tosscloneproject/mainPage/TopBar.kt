package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFF3F4F6)
        ),
        title = {
            Image(
                painter = painterResource(id = R.drawable.toss_logo),
                contentDescription = "MainPageLogo"
            )
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "message",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color(0xFF9898A1)
                )
            }
        },
    )
}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TossCloneProjectTheme {
        TopBar()
    }
}