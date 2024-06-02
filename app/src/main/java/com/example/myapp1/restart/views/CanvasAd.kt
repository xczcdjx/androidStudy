package com.example.myapp1.restart.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.myapp1.R

@Preview(showBackground = true)
@Composable
fun CanvasAd() {
    var img: ImageBitmap? = null
    with(LocalContext.current) {
        img = ImageBitmap.imageResource(id = R.drawable.img_1)
    }
    Canvas(modifier = Modifier.size(375.dp)) {
        drawLine(
            Color(0xFFF44336),
            start = Offset(0f, 10f),
            end = Offset(200f, 200f),
            strokeWidth = 10f,
            cap = StrokeCap.Round
        )
        drawRect(
            topLeft = Offset(220f, 220f),
            size = Size(150f, 150f),
            color = Color(0xFFFF00FF),
        )
        img?.let {
            drawImage(
                it, dstOffset =
                IntOffset(220, 220),
                srcSize = IntSize(500, 350)
            )
        }
        drawRoundRect(Color(0xFF2196F3),
            topLeft = Offset(220f, 580f),
            size = Size(150f, 150f),
            cornerRadius = CornerRadius(20f))
        drawCircle(
          color=Color.Green,
            style = Stroke(width = 10f)
        )
    }
}