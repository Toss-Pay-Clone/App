package com.example.tosscloneproject.Consumption

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tosscloneproject.Login.Compose.Button
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Month() {
    val viewModel: TransactionViewModel = viewModel(factory = TransactionViewModelFactory(transactionApiService))
    var currentMonth by remember { mutableStateOf(LocalDate.now().monthValue) }
    val spentAmount = viewModel.spentAmount.value
    val typography = MaterialTheme.typography


    Column (
        Modifier
            .fillMaxWidth()
            .background(Color.White)){

        Spacer(modifier = Modifier.height(45.dp))
        Row( verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)) {

            IconButton(onClick = {
                if (currentMonth > 1) {
                    currentMonth--
                    viewModel.loadTransactionDates(2024, currentMonth)
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.monthleft),
                    contentDescription = "Previous month",
                    tint = if (currentMonth > 1) TextBlack else Color(0xffd9d9d9)
                )
            }

            Text(text = "${currentMonth}월 소비",
                style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                textDecoration = TextDecoration.Underline)

            IconButton(onClick = {
                if (currentMonth < 12) {
                    currentMonth++
                    viewModel.loadTransactionDates(2024,currentMonth)
                } }) {
                Icon(
                    painter = painterResource(id = R.drawable.monthright),
                    contentDescription = "Next month",
                    tint = if (currentMonth < 12) TextBlack else Color(0xffd9d9d9))
            }
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp),
            horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = "${spentAmount}원", style = typography.titleLarge)

            Box(modifier = Modifier.width(65.dp)) {
                Button(buttonText = "분석",
                    paddingValues = PaddingValues(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MonthPreview() {
    TossCloneProjectTheme {

        Month()
    }
}