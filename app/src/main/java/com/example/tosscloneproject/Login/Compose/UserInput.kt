package com.example.tosscloneproject.Login.Compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.R
import com.example.tosscloneproject.ui.theme.TextBlack
import com.example.tosscloneproject.ui.theme.TextColor1
import com.example.tosscloneproject.ui.theme.TossBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInput (inputplaceholder:String, onValueChange: (String) -> Unit) {
    var text by remember { mutableStateOf(inputplaceholder) }
    val typography = MaterialTheme.typography

    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = text,
        onValueChange = { newText -> text = newText
                        onValueChange(newText)},
        placeholder = { Text(text = "$inputplaceholder", style = typography.labelMedium, color = TextBlack) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = { IconButton(onClick = { text = "" }) {
            Icon(painter = painterResource(id = R.drawable.clear), contentDescription = null)
        }
        },
        textStyle = typography.labelMedium,
        colors = TextFieldDefaults.textFieldColors(
            unfocusedTrailingIconColor = TextColor1,
            focusedTrailingIconColor = TextColor1,
            containerColor = Color.Transparent,
            unfocusedIndicatorColor = TextColor1,
            focusedIndicatorColor = TossBlue,
            focusedTextColor = TextBlack
        )
    )
}