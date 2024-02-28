package com.example.tosscloneproject.Login.Compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.Login.OnBoarding.NAV_ROUTE
import com.example.tosscloneproject.Login.OnBoarding.RouteAction
import com.example.tosscloneproject.ui.theme.TossBlue

@Composable
fun Button (buttonText : String, paddingValues: PaddingValues, shape: Shape = RoundedCornerShape(15.dp),
            route: NAV_ROUTE, routeAction: RouteAction) {
    val typography = MaterialTheme.typography

    Column ( modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        androidx.compose.material3.Button(
            enabled = true,
            shape = shape,
            colors = ButtonDefaults.buttonColors(TossBlue),
            contentPadding = paddingValues,
            onClick = { routeAction.navTo(route) }) {

            Text(text = "$buttonText",
                style = typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = Color.White)
        }
    }
}
