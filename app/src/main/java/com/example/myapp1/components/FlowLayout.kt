package com.example.myapp1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FlowLayout(){
    val filters = List(6) { (it + 97).toChar() }.map { it + "$it$it" }
    val leadingIcon:@Composable ()->Unit={
        Icon(Icons.Default.Check,null)
    }
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        filters.forEach {
            var selected by remember {
                mutableStateOf(false)
            }
            FilterChip(
                selected = selected,
                onClick = { selected = !selected },
                label = { Text(it) },
                leadingIcon = if (selected) leadingIcon else null
            )
        }
    }
}