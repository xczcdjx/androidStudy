package com.example.myapp1.restart.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L
import kotlinx.coroutines.launch

data class Mes(val t: String, val st: String?, var check: Boolean)

@Preview(showBackground = true)
@Composable
fun TestAd() {
    val data = List(30) { Mes("Mes_$it", "sub_mes_2$it", false) }
    val dataf = List(30) {false}
    var reData by remember {
        mutableStateOf(data)
    }
    var state by remember {
        mutableStateOf(1)
    }
    var reDataf by remember {
        mutableStateOf(dataf)
    }
    L.log("render"+reData.toString())
    Button(onClick = {
        state+=1
    }) {
        Text(text = "我是按钮 $state")
    }
    LazyColumn {
        items(reData.size) { index ->
            val item = reData[index]
            ListItem(headlineContent = {
                Text(text = item.t, color = Color.Blue)
            }, supportingContent = {
                Text(text = item.st ?: " ", modifier = Modifier.clickable {

                })
            }, trailingContent = {
                Checkbox(checked = item.check, onCheckedChange = {
                    reData=reData.mapIndexed { sindex, mes ->
                        val nList = item.copy()
                        L.log((nList===item).toString())
                        if (index == sindex) nList.check = !mes.check
                        else nList.check = mes.check
                        return@mapIndexed nList
                    }
                   /* reData=reData.mapIndexed { sindex, mes ->
                        if (index == sindex) mes.check = !mes.check
                        else mes.check = mes.check
                        return@mapIndexed mes
                    }*/
                    L.log("re"+reData.toString())
                })
            })
        }
    }
}