package com.example.myapp1.restart.views

import androidx.compose.foundation.background
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

data class OptionCls(val label: String, val value: Int)

@Preview(showBackground = true)
@Composable
fun DropDownMenuAd() {
    val sexOptions = listOf(OptionCls("男", 0), OptionCls("女", 1))
    var selectSex by remember {
        mutableStateOf(-1)
    }
    var state by remember {
        mutableStateOf(false)
    }
    TextButton(onClick = { state = true }) {
        Text(text =
            if (selectSex==-1) "请选择性别"
            else "已选择${sexOptions[selectSex].label}"
        )
    }
    DropdownMenu(expanded = state,
        // 非焦点时触发
        onDismissRequest = { state = false }) {
        sexOptions.forEach {
            DropdownMenuItem(text = {
                Text(text = it.label, color =
                    if (selectSex==it.value) Color.White
                    else Color.Black
                )
            }, onClick = {
                selectSex = it.value
                state = false }, modifier = Modifier.background(
                if (selectSex==it.value) Color.Green
                else Color.White
            ))

        }
    }
}