package com.example.tosscloneproject.myAssetsPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun MyAssetsPageView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        Container1()
        Container2()
    }
}

@Preview(showBackground = true)
@Composable
fun MyAssetsPagePreview() {
    TossCloneProjectTheme {
        MyAssetsPageView()
    }
}