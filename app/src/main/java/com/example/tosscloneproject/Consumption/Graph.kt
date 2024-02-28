package com.example.tosscloneproject.Consumption

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tosscloneproject.ui.theme.TextColor2
import com.example.tosscloneproject.ui.theme.TossBlue
import com.example.tosscloneproject.ui.theme.TossCloneProjectTheme


@Composable
fun Graph () {
    var typography = MaterialTheme.typography
    var currentMonth by remember { mutableStateOf(2)}

    Column (
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 28.dp, end = 28.dp, top = 34.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Box (
            Modifier
                .fillMaxWidth()
                .height(138.dp)
                .padding(bottom = 20.dp)
                .background(Color.White)){

            PreviousGraph()
            CurrentGraph()
        }
        Row (verticalAlignment = Alignment.CenterVertically){
            Divider(modifier = Modifier
                .width(33.dp)
                .padding(end = 10.dp),
                thickness = 5.dp,
                color = TossBlue)

            Text(text = "${currentMonth}월",
                style = typography.labelSmall,
                color = TextColor2)

            Divider(modifier = Modifier
                .width(48.dp)
                .padding(start = 15.dp, end = 10.dp),
                thickness = 5.dp,
                color = Color(0xffd9d9d9))

            Text(text = "${currentMonth-1}월",
                style = typography.labelSmall,
                color = TextColor2)
        }
    }
}


@Composable
fun CurrentGraph () {

    Column {
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            onDraw = {
                val fromPoint = Offset( x = 0f, y = size.height )
                val toPoint = Offset( x = size.width, y = 0f)

                drawLine(
                    color = TossBlue,
                    start = fromPoint,
                    end = toPoint,
                    strokeWidth = 3f
                )
            })
    }

}

@Composable
fun PreviousGraph () {

    Column {
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            onDraw = {
                val fromPoint = Offset( x = 0f, y = size.height )
                val toPoint = Offset( x = size.width, y = 0f)

                drawLine(
                    color = Color(0xffd9d9d9),
                    start = fromPoint,
                    end = toPoint,
                    strokeWidth = 3f
                )

                val path = androidx.compose.ui.graphics.Path().apply {
                    moveTo(fromPoint.x, fromPoint.y)
                    lineTo(toPoint.x, toPoint.y)
                    lineTo(toPoint.x, fromPoint.y)
                    lineTo(fromPoint.x, fromPoint.y)
                    close()
                }

                drawPath(
                    path = path,
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xffd9d9d9), Color.Transparent),
                        startY = 0f,
                        endY = size.height
                    )
                )
            })
    }
}


@Preview(showBackground = true)
@Composable
fun GraphPreview() {
    TossCloneProjectTheme {

        Graph()
    }
}