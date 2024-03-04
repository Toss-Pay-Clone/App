package com.example.tosscloneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tosscloneproject.Login.OnBoarding.NavigationGraph
import com.example.tosscloneproject.mainPage.MainPageView
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TossCloneProjectTheme {

                MainPageView()

            }
        }
    }
}