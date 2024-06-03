package com.example.myapp1.restart.life

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L

@Preview(showBackground = true)
@Composable
fun LifeAd() {
    var count by remember {
        mutableStateOf(0)
    }
    var state by remember {
        mutableStateOf("")
    }
    // 只会挂载时执行一次
    LaunchedEffect(Unit) {
        L.log("yyyyyyyyyy$count")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "当前count $count,当前state $state", modifier = Modifier.statusBarsPadding())
        TextButton(onClick = { count += 1 }) {
            Text(text = "count $count")
        }
        TextField(value = state, onValueChange = { state = it }, label = {
            Text("账号")
        })
    }
}