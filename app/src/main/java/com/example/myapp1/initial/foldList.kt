package com.example.myapp1.initial

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapp1.R

@Composable
fun FoldList(messages: List<Message>) {
    val selectIndex = remember { mutableStateOf<Int>(-1) }
    LazyColumn {
        items(messages.size) { index ->
            CardL(msg = messages[index], index, selectIndex) {
                Log.i("info","selectIndex=${selectIndex.value},it=${it}")
                if (it==selectIndex.value) selectIndex.value=-1
                else selectIndex.value=it
            }
        }
    }
}

@Composable
fun CardL(msg: Message, i: Int, selectI: MutableState<Int>, onClick: (Int) -> Unit) {
    val surfaceColor by animateColorAsState(
        targetValue = if (i==selectI.value) Color(0xFFCCCCCC) else MaterialTheme.colorScheme.surface
    )
    Surface(
        shape = MaterialTheme.shapes.medium, // 使用 MaterialTheme 自带的形状
        shadowElevation = 5.dp,
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable { // 添加一个新的 Modifier 扩展方法，可以让元素具有点击的效果
                onClick(i) // 编写点击的事件内容
                /*if (i==selectI.value) selectI.value=-1
                else selectI.value = i*/
            },
        color = surfaceColor
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, shape = CircleShape)
            ) // 添加边框
            Spacer(Modifier.padding(horizontal = 8.dp))
            Column {
                Text(
                    msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.padding(vertical = 4.dp))
                Text(
                    msg.msg,
                    // 修改 maxLines 参数，在默认情况下，只显示一行文本内容
                    maxLines = if (i==selectI.value) Int.MAX_VALUE else 1,
                    // Composable 大小的动画效果
                    modifier = Modifier.animateContentSize()
                )
            }
        }
    }
}