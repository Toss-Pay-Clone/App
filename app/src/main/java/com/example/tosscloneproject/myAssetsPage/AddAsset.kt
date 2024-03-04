package com.example.tosscloneproject.myAssetsPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAsset(navController: NavHostController, isSheetOpen: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { isSheetOpen() },
        containerColor = Color.White,
    ) {
        // Sheet content
        AssetList(navController = navController)
    }
}
@Composable
fun AssetList(navController: NavHostController) {
    Column(
        modifier = Modifier
            .width(340.dp)
            .height(510.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "자산추가", fontSize = 20.sp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route = "SelectBank") // 은행선택으로 이동
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "은행", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "카드", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "증권", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "포인트・페이머니", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "보험", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "할부금융(캐피탈)", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "부동산", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(26.dp))
            Text(text = "자동차", fontSize = 18.sp, modifier = Modifier.padding(start = 6.dp))
        }
    }
}
@Composable
@Preview(showBackground = true)
fun AddAssetPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        AssetList(navController = navController)
    }
}