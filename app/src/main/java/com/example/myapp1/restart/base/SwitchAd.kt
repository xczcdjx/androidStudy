package com.example.myapp1.restart.base

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SwitchAd() {
    var check by remember {
        mutableStateOf(false)
    }
    Switch(checked = check, onCheckedChange = {
        check = it
    })
    Text(text = if (check) "hello" else "world")
}