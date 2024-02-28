package com.example.tosscloneproject.Consumption

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tosscloneproject.ui.theme.TextColor1
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calendar() {
    val typography = MaterialTheme.typography
    val transactionViewModel: TransactionViewModel = viewModel(factory = TransactionViewModelFactory(transactionApiService))
    val transactionDateSet by transactionViewModel.transactionDateSet
    val currentDate = remember { mutableStateOf(LocalDate.now()) }
    val daysOfWeek = remember { mutableStateOf(listOf("일","월","화", "수", "목","금","토")) }

    Column (
        Modifier
            .fillMaxWidth()
            .background(Color.White)) {

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "전체 내역",
            style = typography.bodyLarge,
            modifier = Modifier.padding(start = 28.dp, end = 28.dp))
        Spacer(modifier = Modifier.height(30.dp))
        Column (
            Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp)) {
//            Text (text = currentDate.value.month.name,
//                modifier = Modifier.align(Alignment.CenterHorizontally))

            Row (Modifier.fillMaxWidth()){
                daysOfWeek.value.forEach { day ->
                    Box(modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center) {
                        Text(text = day, style = typography.labelSmall)
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            val daysInMonth = currentDate.value.lengthOfMonth()
            val firstDayOfWeek = currentDate.value.withDayOfMonth(1).dayOfWeek.value % 7
            val weeksInMonth = ((daysInMonth + firstDayOfWeek - 1) / 7) + 1

            for (week in 0 until weeksInMonth) {

                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)){
                    for (dayOfWeek in 0 until 7) {

                        Box(modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.Center) {

                            val dayOfMonth = week * 7 + dayOfWeek - firstDayOfWeek + 1
                            if (dayOfMonth in 1..daysInMonth) {
                                val dateColor = if (currentDate.value.withDayOfMonth(dayOfMonth) in transactionDateSet)
                                    TextColor2 else TextColor1

                                Text(text = dayOfMonth.toString(),
                                    style = typography.bodyMedium,
                                    color = dateColor)
                            } else {
                                Spacer(Modifier)
                            }
                        }
                    }
                }
            }
        }
    }

}




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    TossCloneProjectTheme {

        Calendar()
    }
}