package com.example.myapp1.restart.layout

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L
import kotlinx.coroutines.launch

data class Tips(val t: String, val st: String)

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun LazyColumnAd() {
    val scrollable = rememberScrollState()
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val data = List(30) { Tips("News_$it", "sub_news_$it") }
    /*Column(modifier = Modifier.verticalScroll(scrollable)) {
        data.forEach {
            ListItem(headlineContent = {
                Text(text = it.t, color = Color.Red)
            }, supportingContent = {
                Text(text = it.st, modifier = Modifier.clickable{
                    coroutineScope.launch {
                        // 该方法需要在渲染函数内使用
//                        scrollable.scrollBy(200f) // 滚动距离加当前距离，可多次滚动
//                        scrollable.scrollTo(200) // 只滚动到指定位置一次
                        scrollable.animateScrollBy(scrollable.maxValue.toFloat()) // 动画滚动
                    }
                })
                DisposableEffect(Unit) {
                    L.log("effect$it")
                    onDispose {
                        L.log("dispose $it")
                    }
                }
            })
        }
    }*/
    LazyColumn(state = lazyListState) {
        // 单个item
        /* item {
             Text(text = "111")
         }*/
        stickyHeader {
            Text(text = "222", modifier = Modifier.background(Color.Yellow),color= Color.Red)
        }
        items(data.size) {
            ListItem(headlineContent = {
                Text(text = data[it].t, color = Color.Blue)
            }, supportingContent = {
                Text(text = data[it].st, modifier = Modifier.clickable {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(data.size)
                    }
                })
                DisposableEffect(Unit) {
                    L.log("effect$it")
                    onDispose {
                        L.log("dispose $it")
                    }
                }
            })
        }
    }
}