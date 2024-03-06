package com.example.tosscloneproject.Consumption

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.Register.NamePage
import com.example.tosscloneproject.ui.theme.ContainerColor
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Consumption : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = ContainerColor
                ) {
                    ConsumptionPage()

                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ConsumptionPage() {

    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = ContainerColor)) {

        TopMenu()

        LazyColumn (){
            item {Month()}
            item {Graph()}

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item { Calendar() }
//            DailyTransactionList()
        }

    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ConsumptionPreview() {
    TossCloneProjectTheme {

        ConsumptionPage()
    }
}