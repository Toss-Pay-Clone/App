package com.example.tosscloneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                MainPageView()
            }
        }
    }
}










