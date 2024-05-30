package com.example.myapp1.restart.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp1.utils.L

class News(var t: String, var f: Boolean) {
    override fun toString(): String {
        return "Newsttttt(t='$t', f=$f)"
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemAd() {
    val ns = List<News>(10) { News("day23_$it", false) }
    val nsB = List(10) { false }
    var list by remember {
        mutableStateOf(ns)
    }
    var list2 by remember {
        mutableStateOf(nsB)
    }
    list2.forEachIndexed { rowIndex, item ->
        ListItem(
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.AccountBox, contentDescription = null, modifier =
                    Modifier.size(50.dp)
                )
            },
            headlineContent = {
                // 主标题
                Text(text = list[rowIndex].t)
            },

            supportingContent = {
                Text(text = "详情")
            },
            overlineContent = {
                Text(text = "副标题")
            },
            trailingContent = {
                Checkbox(checked = item, onCheckedChange = {
                    /* list=list.mapIndexed{
                         ni,li->
                         if (i==ni) li.f=!li.f
                         else li.f=li.f
                         li
                     }*/
                    list2 = list2.mapIndexed { newIndex, li ->
                        if (rowIndex == newIndex) !li
                        else li
                    }
                })
            }
        )

    }
}