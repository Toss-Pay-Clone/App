package com.example.tosscloneproject.Login.Login

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tosscloneproject.Login.Compose.NumberInput
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor1
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme
import kotlinx.coroutines.launch

class Telecom : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TossCloneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelecomPage()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit, onTelecomSelected: (String) -> Unit) {
    val typography = MaterialTheme.typography
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }) {

        Text(text = "통신사 선택", style = typography.titleLarge.copy(fontSize = 23.sp))
        TelecomList(onTelecomSelected)
    }
}

@Composable
fun TelecomList( onTelecomSelected: (String) -> Unit) {
    val telecoms = listOf("SKT", "KT", "LG U+")

    LazyColumn{
        items(telecoms) { telecom ->
            Row (modifier = Modifier.clickable{onTelecomSelected(telecom)}) {
                Text(text = telecom)
            }
        }
    }
}



@Composable
fun TelecomPage() {
    val typography = MaterialTheme.typography
    val image = painterResource(R.drawable.number_image)
    val arrow = painterResource(R.drawable.arrow_bottom)

    var showSheet by remember { mutableStateOf(false) }
    var selectedTelecom by remember { mutableStateOf("통신사") }

    if (showSheet) {
        BottomSheet(onDismiss = { showSheet = false }) { telecom ->
            selectedTelecom = telecom
            showSheet = false
        }
    }

    Column (modifier = Modifier.fillMaxSize()){

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 84.dp),
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {

            Text(
                text = "통신사를 선택해주세요.",
                style = typography.titleLarge
            )

            Column {
                Row ( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "통신사", style = typography.labelMedium, color = TextColor1,
                        modifier = Modifier.padding(top = 10.dp))
                    IconButton(onClick = { showSheet = true }) {
                        Image(painter = arrow, contentDescription = "arrow_bottom")
                    }
                }
                Divider( color = TextColor1, modifier = Modifier.padding(top = 10.dp))
            }

            Column {
                Text(text = "주민등록번호", style = typography.labelSmall)
                Row ( verticalAlignment = Alignment.CenterVertically ){
                    Box(modifier = Modifier.width(157.dp)) {
                        NumberInput(inputplaceholder = "", TrailingIcon = false)
                    }
                    Text(text = " - ", style = typography.titleLarge)
                    Box(modifier = Modifier.width(22.dp)) {
                        NumberInput(inputplaceholder = "", TrailingIcon = false)
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                    Image(painter = image, contentDescription = "Number")
                }
            }

            Column {
                Text(text = "이름", style = typography.labelSmall)
                Text(text = "오채영", style = typography.labelMedium, color = TextBlack,
                    modifier = Modifier.padding(top = 10.dp))
                Divider( color = TextColor1, modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TelecomPreview() {
    TossCloneProjectTheme {

        TelecomPage()
    }
}