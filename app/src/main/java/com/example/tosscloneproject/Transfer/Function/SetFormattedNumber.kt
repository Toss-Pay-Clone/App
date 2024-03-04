package com.example.tosscloneproject.Transfer.Function

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import java.text.NumberFormat
import java.util.Locale

@Composable
fun formattedNumber(number: String): String {
    val formattedString = NumberFormat.getNumberInstance(Locale.getDefault()).format(number.toLong())
    val annotatedString = buildAnnotatedString {
        append(formattedString)
        addStyle(
            style = SpanStyle(textDecoration = TextDecoration.None),
            start = 0,
            end = length
        )
    }
    return annotatedString.toString()
}