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
fun NumberInput (inputplaceholder:String) {
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }
    val typography = MaterialTheme.typography

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = phoneNumber,
        onValueChange = { newValue -> phoneNumber = newValue },
        placeholder = { Text(text = "$inputplaceholder", style = typography.labelMedium, color = TextColor1) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhonenumberInput (inputplaceholder:String, TrailingIcon: Boolean = true) {
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }
    val typography = MaterialTheme.typography

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = phoneNumber,
        onValueChange = { newValue -> phoneNumber = newValue },
        placeholder = { Text(text = "$inputplaceholder", style = typography.labelMedium, color = TextColor1) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        trailingIcon = { if (TrailingIcon) { IconButton(onClick = { phoneNumber = TextFieldValue() }) {
            Icon(painter = painterResource(id = R.drawable.clear), contentDescription = null)
        }
        }},
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