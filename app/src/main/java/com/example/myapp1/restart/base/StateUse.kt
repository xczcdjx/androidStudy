package com.example.myapp1.restart.base

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun StateUse() {
    val str = remember {
        mutableIntStateOf(100)
    }
    var str2 by remember { // 返回值的类型
        mutableIntStateOf(1)
    }
    val (v,setV)= remember {
        mutableIntStateOf(12)
    }
    TextButton(onClick = {
        str.intValue += 1
        str2+=1
        setV(v+1)
    }) {
        Text(text = str.value.toString()+str2+v)
    }
}