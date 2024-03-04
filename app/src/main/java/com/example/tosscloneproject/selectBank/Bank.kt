package com.example.tosscloneproject.selectBank

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossBlue
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Bank(navController: NavHostController) {
    val selectedBanks = remember { mutableStateListOf<String>() } // 선택된 은행 리스트를 추적합니다.
    val selectedCount = remember { mutableIntStateOf(0) } // 선택된 은행의 개수를 추적합니다.
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "은행", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = if (selectedCount.intValue == bankList.entries.size) "전체 해제" else "전체 선택", // 전체 선택 텍스트를 동적으로 설정합니다.
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.clickable(onClick = {
                        if (selectedBanks.size == bankList.entries.size) {
                            DeselectAll(selectedBanks, selectedCount)
                        } else {
                            SelectAll(selectedBanks, selectedCount)
                        }
                    })
                )
            }

        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            BankInfo(bankIcon = painterResource(id = R.drawable.woori),
                id = bankList.WOORI_GLOBAL_BANKING.id,
                isSelected = selectedBanks.contains(bankList.WOORI_GLOBAL_BANKING.id),
                onClickAction = { ToggleCheck(bankList.WOORI_GLOBAL_BANKING.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.nonghyup),
                id = bankList.NONGHYUP_BANK.id,
                isSelected = selectedBanks.contains(bankList.NONGHYUP_BANK.id),
                onClickAction = { ToggleCheck(bankList.NONGHYUP_BANK.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.kakao),
                id = bankList.KAKAO_BANK.id,
                isSelected = selectedBanks.contains(bankList.KAKAO_BANK.id),
                onClickAction = { ToggleCheck(bankList.KAKAO_BANK.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.kookmin),
                id = bankList.KOOKMIN_BANK.id,
                isSelected = selectedBanks.contains(bankList.KOOKMIN_BANK.id),
                onClickAction = { ToggleCheck(bankList.KOOKMIN_BANK.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.korea_post_office),
                id = bankList.KOREA_POST_OFFICE.id,
                isSelected = selectedBanks.contains(bankList.KOREA_POST_OFFICE.id),
                onClickAction = { ToggleCheck(bankList.KOREA_POST_OFFICE.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.shinhan),
                id = bankList.SHINHAN_BANK.id,
                isSelected = selectedBanks.contains(bankList.SHINHAN_BANK.id),
                onClickAction = { ToggleCheck(bankList.SHINHAN_BANK.id, selectedBanks, selectedCount) }
            )
            BankInfo(bankIcon = painterResource(id = R.drawable.hana),
                id = bankList.HANA_BANK.id,
                isSelected = selectedBanks.contains(bankList.HANA_BANK.id),
                onClickAction = { ToggleCheck(bankList.HANA_BANK.id, selectedBanks, selectedCount) }
            )

            if (selectedCount.intValue > 0) { // 선택된 은행이 하나 이상일 때만 버튼을 표시합니다.
                Button(
                    onClick = {
                        navController.navigate(route = "TossCertification")
                    },
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(TossBlue),

                    ) {
                    Text(
                        text = "${selectedCount.intValue}개 연결하기",
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = Color.White
                    )
                }
            }
        }
    }

}
@Composable

fun BankInfo(bankIcon: Painter, id: String, isSelected: Boolean, onClickAction: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClickAction() }
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = bankIcon,
            contentDescription = id,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = id,
            modifier = Modifier
                .padding(bottom = 5.dp, start = 20.dp)
                .weight(1f)
        )
        if(isSelected){
            Image(
                painter = painterResource(id = R.drawable.checked_circle),
                contentDescription = "check",
                modifier = Modifier.size(30.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.check_circle),
                contentDescription = "check",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

fun ToggleCheck(id: String, selectedBanks: MutableList<String>, selectedCount: MutableState<Int>) {
    val TAG = "로그"

    if (selectedBanks.contains(id)) {
        selectedBanks.remove(id) // 선택된 은행 리스트에서 제거합니다.
        selectedCount.value -= 1 // 선택된 은행의 개수를 감소합니다.
    } else {
        selectedBanks.add(id) // 선택된 은행 리스트에 추가합니다.
        selectedCount.value += 1 // 선택된 은행의 개수를 증가합니다.
    }
}
fun SelectAll(selectedBanks: MutableList<String>, selectedCount: MutableState<Int>) {
    selectedBanks.clear() // 선택된 은행 리스트를 비웁니다.
    selectedBanks.addAll(bankList.entries.map { it.id }) // 모든 은행을 선택합니다.
    selectedCount.value = bankList.entries.size // 선택된 은행의 개수를 전체 은행의 개수로 설정합니다.
}
fun DeselectAll(selectedBanks: MutableList<String>, selectedCount: MutableState<Int>) {
    selectedBanks.clear() // 선택된 은행 리스트를 비웁니다.
    selectedCount.value = 0 // 선택된 은행의 개수를 전체 은행의 개수로 설정합니다.
}
@Composable
@Preview(showBackground = true)
fun BankPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        Bank(navController = navController)
    }
}