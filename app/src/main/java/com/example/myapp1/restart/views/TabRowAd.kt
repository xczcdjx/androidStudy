package com.example.myapp1.restart.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TabRowAd() {
    var selectTabI by remember {
        mutableStateOf(0)
    }
    Column {
        // 不可滚动
        // TabRow
        TabRow(selectedTabIndex = selectTabI) {
            for (i in 0 until 4){
                // Tab有两个重载方法
                /*Tab(selected = true, onClick = { *//*TODO*//* }) {
                    
                }*/
                // 可实现底部图标导航
                Tab(selected = selectTabI==i, onClick = { selectTabI=i }, icon = {
                    Icon(imageVector = Icons.Default.AccountBalance, contentDescription = null)
                }, text = {
                    Text(text = "Tab ${i+1}")
                })
            }
            // 左图标
            LeadingIconTab(selected = selectTabI==5, onClick = { selectTabI=5 }, icon = {
                Icon(imageVector = Icons.Default.AccountBalance, contentDescription = null)
            }, text = {
                Text(text = "Tab ${5+1}")
            })
        }
        // 带滚动,有边缘距离
        /*ScrollableTabRow(selectedTabIndex = selectTabI, edgePadding = 0.dp) {
            for (i in 0 until 10) {
                Text(
                    text = "Tab${i + 1}", modifier = Modifier
                        .width(100.dp)
                        .padding(5.dp)
                        .clickable {
                            selectTabI = i
                        }, color = if (i == selectTabI) Color.Red else Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }*/
        Text(text = "Content${selectTabI+1}")
    }
}