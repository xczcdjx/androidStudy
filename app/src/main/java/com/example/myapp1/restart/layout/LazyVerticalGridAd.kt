package com.example.myapp1.restart.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LazyVerticalGridAd() {
    val nums = (0..20).toList()
    // 需设置columns列数
    LazyVerticalGrid(columns = GridCells.Fixed(4), contentPadding = PaddingValues(4.dp)) {
        items(nums.size) {
            Column(
                modifier = Modifier
                    .border(1.dp, Color.Blue)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "$it")
                Text(text = "${it * it}")
            }
        }
    }
}