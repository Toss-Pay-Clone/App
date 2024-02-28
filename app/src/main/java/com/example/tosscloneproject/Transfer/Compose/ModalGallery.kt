package com.example.tosscloneproject.Transfer.Compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

// 송금 가능 은행 목록
val bankList = mutableListOf(
    Pair("KB국민", R.drawable.icon_kb_lite),
    Pair("카카오뱅크", R.drawable.icon_kk_lite),
    Pair("신한", R.drawable.icon_sh_lite),
    Pair("NH농협", R.drawable.icon_nh_lite),
    Pair("하나", R.drawable.icon_hn_lite),
    Pair("우리", R.drawable.icon_wr_lite),
    Pair("우체국", R.drawable.icon_kp_lite),
)

@Composable
fun GalleryTileButton(name: String, image: Int, onClose: () -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .width(110.dp)
            .height(90.dp)
            .padding(5.dp),
        color = Color(0xfff8f8fb),
        onClick = { onClose() }
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .size(42.dp)
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = name
                )
            }
            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun ModalGallery(onClose: (value: String?) -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color(0x60202020))) {
        Surface(
            shape = MaterialTheme.shapes.large,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(top = 160.dp, bottom = 10.dp)
        ) {
            Column {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .width(60.dp)
                            .height(24.dp)
                            .padding(10.dp),
                        color = Color.LightGray,
                        onClick = { onClose(null) }
                    ) {}
                }
                Text(
                    text = "은행을 선택해주세요",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(vertical = 15.dp, horizontal = 24.dp)
                )

                var curLine = 0
                val lastLine = bankList.size.div(3) + 1
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                ) {
                    repeat(lastLine) {
                        Row {
                            for (bankInfo in bankList.subList(
                                curLine++ * 3,
                                if (curLine >= lastLine) bankList.lastIndex + 1
                                else curLine * 3
                            )) {
                                GalleryTileButton(name = bankInfo.first, image = bankInfo.second) {
                                    onClose(bankInfo.first)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GalleryTileButtonPreview() {
    GalleryTileButton(name = "KB국민", image = R.drawable.icon_kb, {})
}

@Preview(showBackground = true)
@Composable
fun ModalGalleryPreview() {
    TossCloneProjectTheme {
        ModalGallery(onClose = {})
    }
}