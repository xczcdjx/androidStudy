package com.example.myapp1.restart.mixin

import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapp1.Common
import com.example.myapp1.R

// 查看主函数
private fun mixinAd(){/*
    setContentView(R.layout.main)
    val comXml: ComposeView = findViewById(R.id.composeView)
    comXml.setContent {
        Column {
            Common(str = "compose") {
                Text(text = "我是xml的compose")
            }
            AndroidView(factory = {
                TextView(it)
//                    LayoutInflater.from()
            }) {
                it.apply {
                    text = "compose的xml"
                }
            }
        }
    }*/
}