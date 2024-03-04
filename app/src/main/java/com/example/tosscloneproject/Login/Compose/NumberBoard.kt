package com.example.tosscloneproject.Login.Compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun NumberBoard (
    //숫자 버튼을 클릭했을때 호출되는 콜백 함수
    onNumberClick: (String) -> Unit
) {

    NumberBoardRow (
        listOf ("1", "2", "3", "4", "5", "6", "7", "8", "9", "","0",""),
        onNumberClick
    )
}

@Composable
fun NumberBoardRow (num: List<String>,
                    onNumberClick: (num:String) -> Unit
) {
    val list = (1..9).map { it.toString() }.toMutableList()
    list.addAll(mutableListOf("","0",""))

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            itemsIndexed(items = list) { index, item ->
                NumberButton(
                    modifier = Modifier,
                    number = item,
                    onClick = { onNumberClick(it)}
                )
            }
        })
}