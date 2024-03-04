package com.example.tosscloneproject.myAssetsPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun Container1() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(333.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // item1
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "총자산", fontSize = 16.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "0원", fontSize = 31.sp)
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_down),
                        contentDescription = null)
                }
            }
            Button(
                onClick = {},
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.wrapContentSize(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF2196F3), Color(0xFFFFFFFF)
                )
            ) {
                Text(
                    text = "분석", style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        // item2
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "계좌", fontSize = 16.sp)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "0원", fontSize = 26.sp)
                }
            }
        }
        // item3
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "입출금", fontSize = 13.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.toss_symbol),
                            contentDescription = null)
                        Column(
                            modifier = Modifier
                                .padding(start = 14.dp)
                        ) {
                            Text(text = "- - - - -계좌", fontSize = 13.sp)
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = "0원", fontSize = 16.sp)
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_down),
                                    contentDescription = null)
                            }
                        }
                    }
                }
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFAAAEB3), Color(0xFF413E3E)
                    )
                ) {
                    Text(
                        text = "송금", style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun Container1Preview() {
    TossCloneProjectTheme {
        Container1()
    }
}