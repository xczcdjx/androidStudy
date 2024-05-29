package com.example.myapp1.restart.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp1.R

@Preview(showBackground = true)
@Composable
fun ImageAd() {
    Image(
        painter = painterResource(id = R.drawable.mi), contentDescription = null,
        modifier = Modifier.size(100.dp), contentScale = ContentScale.Crop, colorFilter =
        ColorFilter.tint(Color.Red, blendMode = BlendMode.Color) // 滤镜颜色
    )
}