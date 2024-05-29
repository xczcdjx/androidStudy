package com.example.myapp1.restart.layout

import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L

class News(var t:String,var f:Boolean){
    override fun toString(): String {
        return "Newsttttt(t='$t', f=$f)"
    }
}
@Preview(showBackground = true)
@Composable
fun ListItemAd(){
    val ns= List<News>(10){News("day23_$it",false)}
    val nsB= List(10){false}
    var list by remember {
        mutableStateOf(ns)
    }
    var list2 by remember {
        mutableStateOf(nsB)
    }
    L.log("list111=$list")
    L.log("list222=$list2")
    list2.forEachIndexed{i,it->
        ListItem(
            headlineContent = {
                Text(text = list[i].t)
            },
            trailingContent = {
                Checkbox(checked = list2[i], onCheckedChange = {
                   /* list=list.mapIndexed{
                        ni,li->
                        if (i==ni) li.f=!li.f
                        else li.f=li.f
                        li
                    }*/
                    list2=list2.mapIndexed{
                            ni,li->
                        if (i==ni) !it
                        else li
                    }
                    L.log("list22=$list")
                    L.log("list2222=$list2")
                })
            }
        )

    }
}