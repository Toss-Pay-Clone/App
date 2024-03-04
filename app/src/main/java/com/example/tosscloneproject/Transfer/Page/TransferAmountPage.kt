package com.example.tosscloneproject.Transfer.Page

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.tosscloneproject.R
import com.example.tosscloneproject.Transfer.Compose.InputBoxCleanVersion
import com.example.tosscloneproject.Transfer.Compose.TransferHeader
import com.example.tosscloneproject.Transfer.ViewModel.TransferAmountVM
import com.example.tosscloneproject.Transfer.ViewModel.TransferAmountVMFactory
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import java.text.NumberFormat
import java.util.Locale

//class TransferAmountObject {
//    private val _myAccount = mutableStateOf<String>("")
//    private val _accountBalance = mutableStateOf<String>("123000")
//    private val _remittanceName = mutableStateOf<String>("[송금 대상]")
//    private val _remittanceAccount = mutableStateOf<String>("[송금 계좌]")
//
//    val myAccount: MutableState<String>
//        get() = _myAccount
//    val accountBalance: MutableState<String>
//        get() = _accountBalance
//    val remittanceName: MutableState<String>
//        get() = _remittanceName
//    val remittanceAccount: MutableState<String>
//        get() = _remittanceAccount
//}

val myAccountName = "[본인 계좌명]"
val myAccount = "[본인 계좌번호]"
val accountBalance = "123000"
val remittanceName = "[송금 대상]"
val remittanceAccount = "[송금 계좌]"

@Composable
fun formattedNumber(number: String): String {
    val formattedString = NumberFormat.getNumberInstance(Locale.getDefault()).format(number.toLong())
    val annotatedString = buildAnnotatedString {
        append(formattedString)
        addStyle(
            style = SpanStyle(textDecoration = TextDecoration.None),
            start = 0,
            end = length
        )
    }
    return annotatedString.toString()
}

@Composable
fun SubTitleText(titleMain: String, titleSub: String, context: String) {
    Column {
        Row(
            modifier = Modifier.padding(3.dp)
        ) {
            Text(
                text = titleMain,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = titleSub,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            )
        }
        Text(
            text = context,
            fontSize = 14.sp,
            color = Color(0xFF909099),
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SubTitleTextPreview() {
    TossCloneProjectTheme {
        SubTitleText("내 토스뱅크 통장", "에서", "잔액 123,456원")
    }
}

@Composable
fun TransferAmountPage() {
    val isRemittanceCheck = remember {
        mutableStateOf(false)
    }
    val amount = remember {
        mutableStateOf(TextFieldValue())
    }
//    val transferAmountVM = ViewModelProvider(
//        LocalContext.current as ViewModelStoreOwner,
//        TransferAmountVMFactory()
//    )[TransferAmountVM::class.java]

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.padding(horizontal = 20.dp)) {
                TransferHeader(location = "토스뱅크 송금")
                Spacer(Modifier.padding(vertical = 20.dp))
                if (isRemittanceCheck.value) {
//                    TransferAmountCheck(amount = transferAmountVM.amount.value) {
                    TransferAmountCheck(amount = amount.value.text) {
                        isRemittanceCheck.value = false
                    }
                } else {
                    SubTitleText("내 $myAccountName", "에서", "잔액 ${formattedNumber(accountBalance)}원")
                    Spacer(Modifier.padding(vertical = 10.dp))
                    SubTitleText(remittanceName, "님에게", remittanceAccount)
                    Spacer(Modifier.padding(vertical = 10.dp))
//                    InputBoxCleanVersion(placeHolder = "얼마나 보낼까요?", transferAmountVM)
                    InputBoxCleanVersion(placeHolder = "얼마나 보낼까요?", value = amount.value.text) { newText ->
                        amount.value = amount.value.copy(newText)
                    }
                    Spacer(Modifier.padding(vertical = 10.dp))
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .height(44.dp),
                        color = Color(0xFFF0F0F0),
                        onClick = {
//                            transferAmountVM.setAmount(accountBalance)
                            amount.value = amount.value.copy(text = accountBalance)
                        }
                    ) {
                        Text(
                            text = "잔액  ${formattedNumber(accountBalance)}원 입력",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
//            if (transferAmountVM.amount.value.isNotEmpty()) {
            if (amount.value.text.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Color(0xFF0077FF), shape = RectangleShape)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            isRemittanceCheck.value = true
                        }
                ) {
                    Text(
                        text = "다음",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferAmountPagePreview() {
    TossCloneProjectTheme {
        TransferAmountPage()
    }
}

@Composable
fun TransferAmountCheck(amount: String, onClick: () -> Unit) {
    val labelStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 상단부
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(
                            text = remittanceName,
                            color = Color(0xFF0077FF),
                            style = labelStyle
                        )
                        Text(text = "으로", style = labelStyle)
                    }
                    Text(text = "${amount}원을", style = labelStyle)
                    Text(text = "옮길까요?", style = labelStyle)
                }
            }
        }

        // 하단부
        val checkPageFontStyle = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Column {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "받는 분에게 표시", style = checkPageFontStyle)
                    Text(text = "E형 Stone", style = checkPageFontStyle, color = Color(0xFF202020))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "출금 계좌", style = checkPageFontStyle)
                    Text(text = myAccountName, style = checkPageFontStyle, color = Color(0xFF202020))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "입금 계좌", style = checkPageFontStyle)
                    Text(text = remittanceName, style = checkPageFontStyle, color = Color(0xFF202020))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onClick()
                    },
                color = Color(0xFF0077FF)
            ) {
                Text(
                    text = "옮기기",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                text = "평생 수수료 무료",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                style = checkPageFontStyle
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferAmountCheckPreview() {
    TossCloneProjectTheme {
        TransferAmountCheck("123,000", {})
    }
}

@Composable
fun TransferSuccessPage(amount: String, onClick: () -> Unit) {
    val labelStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 상단부
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "success",
                        modifier = Modifier.size(100.dp))
                    Row {
                        Text(
                            text = remittanceName,
                            style = labelStyle
                        )
                        Text(text = "으로", style = labelStyle)
                    }
                    Text(text = "${amount}원을", style = labelStyle)
                    Text(text = "옮겼어요", style = labelStyle)
                }
            }
        }

        // 하단부
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 10.dp)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    onClick()
                },
            color = Color(0xFF0077FF)
        ) {
            Text(
                text = "확인",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransferSuccessPagePreview() {
    TossCloneProjectTheme {
        TransferSuccessPage(amount = "123,000") {
            
        }
    }
}