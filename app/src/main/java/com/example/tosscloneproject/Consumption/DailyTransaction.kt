package com.example.tosscloneproject.Consumption

import android.os.Build
import android.view.SurfaceControl.Transaction
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor1
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TextColor3
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyTransactionList() {
    val transactionViewModel: TransactionViewModel = viewModel(factory = TransactionViewModelFactory(transactionApiService))
    val transactions = transactionViewModel.transactions.collectAsState()
    val typography = MaterialTheme.typography

    Column (
        Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, end = 28.dp)
            .background(Color.White)){

        Column {
            Text(
                text = LocalDate.now().format(DateTimeFormatter.ofPattern("dd일 EEE요일")),
                style = typography.labelSmall.copy(color = TextColor2))

            Spacer(modifier = Modifier.height(22.dp))

            LazyColumn {
                itemsIndexed(transactions.value) {index, transaction ->
                    TransactionItem(transaction)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionItem (transaction: TransactionData) {
    val typography = MaterialTheme.typography
    val formattedSpentAmount = NumberFormat.getInstance().format(transaction.amount)

    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 25.dp)
            .fillMaxWidth()){
        Image(painter = painterResource(id = R.drawable.toss_symbol), 
            contentDescription = "BankImage",
            modifier = Modifier.size(24.dp))

        Spacer(modifier = Modifier.width(10.dp))

        Column (Modifier.padding(start = 16.dp)){
            val amount = if (transaction.transactionType == "DEPOSIT") {
                "${formattedSpentAmount}원"
            } else {
                "-${formattedSpentAmount}원"
            }
            Text(text = amount,
                style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = if (transaction.transactionType == "DEPOSIT") TextColor1
            else TextBlack)
            Text(text = transaction.depositDestination.name,
                style = typography.labelSmall.copy(color = TextColor2))
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DailyTransactionListPreview() {
    val transaction = TransactionData(
        id = 1,
        amount = 1000L,
        transactionType = "WITHDRAW",
        description = "Test",
        depositDestination = BankAccount(
            bank = "Test Bank",
            name = "Test Account",
            bankAccountNumber = 1234567890L
        ),
        withdrawalDestination = BankAccount(
            bank = "Test Bank",
            name = "Test Account",
            bankAccountNumber = 1234567890L
        ),
        transactionTime = "2024-02-27T12:34:56",
        balanceAfterTransaction = 2000L
    )
    val transactions = listOf(transaction)

    TossCloneProjectTheme {
        Column (
            Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp)
                .background(Color.White)){

            Column {
                Text(
                    text = LocalDate.now().format(DateTimeFormatter.ofPattern("dd일 EEE요일")),
                    style = MaterialTheme.typography.labelSmall.copy(color = TextColor2))

                Spacer(modifier = Modifier.height(22.dp))

                LazyColumn {
                    itemsIndexed(transactions) { index, transaction -> // 인덱스와 값을 함께 제공합니다.
                        TransactionItem(transaction) // TransactionData 객체를 전달합니다.
                    }
                }
            }
        }
    }
}
