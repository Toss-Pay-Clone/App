package com.example.tosscloneproject.publicComposable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tosscloneproject.ui.theme.TossBlue
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme

@Composable
fun CustomButton(contents: String, navController: NavHostController, route: String) {
    Button(
        onClick = {
            navController.navigate(route = route)
        },
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(TossBlue),
        ) {
        Text(
            text = contents,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
            color = Color.White
        )
    }
}
@Composable
@Preview(showBackground = true)
fun CustomButtonPreview() {
    TossCloneProjectTheme {
        val navController = rememberNavController()
        CustomButton(contents = "커스텀", navController = navController, route="")
    }
}