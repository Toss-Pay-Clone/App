package com.example.tosscloneproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                MainPageView()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPageView() {
    Scaffold(
        containerColor = Color(0xFFF3F4F6),
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar() },
    ) {
        ScrollContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFF3F4F6)
        ),
        title = {
            Image(
                painter = painterResource(id = R.drawable.toss_logo),
                contentDescription = "MainPageLogo"
            )
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "message",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color(0xFF9898A1)
                )
            }
        },
    )
}

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

@Composable
fun ScrollContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 70.dp, horizontal = 20.dp)
            .background(Color(0xFFF2F4F5)),
        ) {
        Container3()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container4()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container1()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container2()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container5()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Container6()
        Spacer(modifier = Modifier.padding(vertical = 20.dp))

    }
}
@Composable
fun Container1() {
    // wrapper
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // item1
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp)
        ) {
            Column{
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "계좌", fontSize = 13.sp)
                Text(text = "0원", fontSize = 18.sp)
            }
            Column{
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFF2F4F5), Color(0xFF6B7684)
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
        // item2
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "내 모든 계좌", fontSize = 13.sp)
                Text(text = "잔액 보기", fontSize = 18.sp)
            }
            Column {
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFF2F4F5), Color(0xFF6B7684)
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
        // item3
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "포인트・머니", fontSize = 13.sp)
                Text(text = "?원", fontSize = 18.sp)
            }
        }
        Column(
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Divider(thickness = 1.dp, color = Color(0xFFF2F4F5))
        }
        Row(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
        ) {
            Text(text = "계좌・대출・증권・포인트 보기", color = Color(0xFF6B7684), fontSize = 15.sp)
            Image(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = null,
            )
        }
    }
}
@Composable
fun Container2() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // item1
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "이번 달 쓴 금액", fontSize = 13.sp)
                Text(text = "0원", fontSize = 18.sp)
            }
            Column {
                Button(
                    onClick = {},
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.wrapContentSize(),
                    shape = RoundedCornerShape(25),
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFF2F4F5), Color(0xFF6B7684)
                    )
                ) {
                    Text(
                        text = "내역", style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
        // item2
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 20.dp)
                .height(45.6.dp)
        ) {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "내 모든 카드", fontSize = 13.sp)
                Text(text = "연결하고 내역보기", fontSize = 18.sp)
            }
        }
    }
}
@Composable
fun Container3() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "광고", fontSize = 22.sp, fontWeight = FontWeight.Bold )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,

                )
        }
    }
}
@Composable
fun Container4() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "토스뱅크", fontSize = 22.sp, fontWeight = FontWeight.Bold )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,

            )
        }
    }
}
@Composable
fun Container5() {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "계좌개설", color = Color(0xFF6B7684), fontSize = 16.sp)
        Divider(color = Color(0xFF6B7684), modifier = Modifier
            .height(18.dp)
            .width(1.dp))
        Text(text = "카드발급", color = Color(0xFF6B7684), fontSize = 16.sp)
        Divider(color = Color(0xFF6B7684), modifier = Modifier
            .height(18.dp)
            .width(1.dp))
        Text(text = "대출받기", color = Color(0xFF6B7684), fontSize = 16.sp)
    }
}
@Composable
fun Container6() {
    // wrapper
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "나희수 님을 위해 준비했어요",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        // item1
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
                Image(
                    painter = painterResource(id = R.drawable.toss_symbol),
                    contentDescription = null,
                )
                Text("보험 전문가에게 물어보기", fontSize = 16.sp, modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = null,
                )

        }
        // item2
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
            )
            Text("LG U+ 휴대폰 요금제", fontSize = 16.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )

        }
        // item3
        Row(
            modifier = Modifier
                .padding(20.dp, 20.dp, 20.dp, 0.dp)
                .height(45.6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.toss_symbol),
                contentDescription = null,
            )
            Text("내 통신 요금", fontSize = 16.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }
        Divider(thickness = 1.dp, color = Color(0xFFF2F4F5),
            modifier = Modifier.padding(20.dp))
        // item4
        Row(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
        ) {
            Text(text = "추천 서비스 더보기", color = Color(0xFF6B7684), fontSize = 16.sp)
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    TossCloneProjectTheme {
        Container6()
    }
}