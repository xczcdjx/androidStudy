package com.example.myapp1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview
@Composable
fun BoxFun(){
    Box(modifier = Modifier
        .size(150.dp)
        .background(Color.Blue),
        contentAlignment = Alignment.Center
        ){
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red))
        Text("hello")
    }
}