package com.example.tosscloneproject.mainPage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun BottomNavigationBar() {
    val items = listOf("홈", "내 소비", "혜택", "주식", "전체")
    val icons = listOf(
        Icons.Filled.Home,
        Icons.Filled.ShoppingCart,
        Icons.Filled.Star,
        Icons.Filled.Send,
        Icons.Filled.Menu
    )
    var selectedItem by remember { mutableStateOf(0) }

    BottomAppBar(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)),
    ) {
        BottomNavigation(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)),
            backgroundColor = Color.White,
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            icons[index],
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 4.dp)
                                .size(30.dp),
                            tint = Color(0xFF9898A1)
                        )
                    },
                    label = { Text(item,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .padding(bottom= 18.dp)) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index}
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomBottomNavigationBarPreview() {
    TossCloneProjectTheme {
        BottomNavigationBar()
    }
}