package com.example.myapp1.restart.base

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TextAd() {
    val str = "我是可以复制的文字"
    val str2 = "请同意"
    val strList= listOf("protocal" to "http://baidu.com","privacy" to "http://jd.com")
    val ano = buildAnnotatedString {
        append(str2)
        pushStringAnnotation("protocal", "http://baidu.com")
        withStyle( // 设置样式 在下一个字体出现之前
            style = SpanStyle(
                color = Color.Blue, fontSize = 15.sp
            )
        ) {
            append("用户协议")
        }
        pop()
        append("和")
        pushStringAnnotation("privacy", "http://jd.com")
        withStyle(
            style = SpanStyle(
                color = Color.Cyan, fontSize = 15.sp
            )
        ) {
            append("隐私策略")
        }
        pop()
    }
    Column {
        // 文字复制
//        Text(text = "我是可以复制的文字")
       /* ClickableText(text = buildAnnotatedString {
            append(str) // 添加文字
            withStyle( // 设置样式 在下一个字体出现之前
                style = SpanStyle(
                    color = Color.Cyan, textDecoration = TextDecoration.Underline, fontSize = 15.sp
                )
            ) {
                append("123")
            }
            append("666")
        }, onClick = {
            Log.d("=====", "你点击了$it") // 该it可获得点击的字符索引
        })*/
        ClickableText(text = ano, onClick = { offset->
            ano.getStringAnnotations("protocal", start = offset,end=offset).firstOrNull()?.let {
                Log.d("========", it.item)
            }
            ano.getStringAnnotations("privacy", start = offset,end=offset).firstOrNull()?.let {
                Log.d("========", it.item)
            }
        })
    }
}