package com.example.myapp1.restart.base

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ModifyAd() {
    Text(text = "test 123", modifier = Modifier.border(1.dp, Color.Red)
        .background(Color.Blue)
        .padding(10.dp)
        // modify包含点击事件，但是无任何效果
        .clickable{
        Log.d("=======","你点击到了")
    })
}