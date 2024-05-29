package com.example.myapp1.restart.base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, group = "t1", showBackground = true,name="pre1")
@Composable
fun previewV(){
    Text("hello world")
}
@Preview(showSystemUi = true, group = "t2", showBackground = true,name="pre1")
@Composable
fun previewV2(){
    Text("hello world2")
}