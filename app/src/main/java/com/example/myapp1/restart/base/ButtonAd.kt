package com.example.myapp1.restart.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L

data class ButtonState(var text: String, var textColor: Color, var buttonColor: Color)

@Preview(showBackground = true)
@Composable
fun ButtonAd() {
    // 获取按钮的状态
    val interactionState = remember { MutableInteractionSource() }
    var count = remember { mutableStateOf(1) }
// 使用 Kotlin 的解构方法
    val (text, textColor, buttonColor) = when {
        interactionState.collectIsPressedAsState().value -> ButtonState(
            "Just Pressed",
            Color.Red,
            Color.Black
        )

        else -> ButtonState("Just Button", Color.White, Color.Red)
    }
    Button(
        onClick = {
            L.log("你点击了我")
            count.value += 1
        }, modifier = Modifier
            .background(Color.LightGray)
            .clickable() {
                L.log("111111111")
            }, colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor, // 除内容颜色
            contentColor = Color.Black // 内容颜色
        ), interactionSource = interactionState
    ) {
        Text(text = text + count.value, color = textColor)
    }
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "文字按钮")
    }
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "带边框按钮")
    }
}
