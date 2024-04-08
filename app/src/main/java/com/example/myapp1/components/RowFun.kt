package com.example.myapp1.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview(showBackground = true)
@Composable
fun RowFun(){
    Column(
        modifier = Modifier.width(300.dp).padding(4.dp).height(150.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("hello")
        Spacer(modifier = Modifier.padding(vertical = 3.dp))
        Text(Array(100){it}.joinToString(), maxLines = 4, overflow = TextOverflow.Ellipsis)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Favorite,null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.AccountBox,null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Share,null)
            }
        }
    }
}