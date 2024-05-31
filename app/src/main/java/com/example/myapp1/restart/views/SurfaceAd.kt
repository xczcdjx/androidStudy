package com.example.myapp1.restart.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp1.R

@Preview(showBackground = true)
@Composable
fun SurfaceAd() {
//    RectangleShape // 矩形
//    RoundedCornerShape // 圆角
//    CutCornerShape // 切角
//    CircleShape 50圆角胶囊形状
    Surface(
        shape = CutCornerShape(20),
        border = BorderStroke(1.dp, Color.Green),
        tonalElevation = 10.dp,
        shadowElevation = 10.dp
    ) {
        Image(painter = painterResource(id = R.drawable.img_1), contentDescription = null)
    }
}