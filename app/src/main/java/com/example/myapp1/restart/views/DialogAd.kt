package com.example.myapp1.restart.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DialogAd(){
    var show by remember {
        mutableStateOf(false)
    }
    var showUpdate by remember {
        mutableStateOf(false)
    }
    Column {
        TextButton(onClick = { show=true }) {
            Text(text = "展示对话框")
        }
        TextButton(onClick = { showUpdate=true }) {
            Text(text = "更新对话框")
        }
        if (show){
            Dialog(onDismissRequest = {
                show=false
            }) {
                Surface(modifier = Modifier.size(200.dp), shape = RoundedCornerShape(10.dp)) {
                    Text(text = "我是对话文字")
                }
            }
        }
        if (showUpdate){
            /*Dialog(onDismissRequest = { show=false}) {

            }*/
            /*DatePickerDialog(onDismissRequest = { showUpdate=false }, confirmButton = { *//*TODO*//* }) {
                
            }*/
            AlertDialog(onDismissRequest = {showUpdate=false}, title = {
              Text(text = "更新3.1")
            }, confirmButton = {
                TextButton(onClick = { showUpdate=false }) {
                    Text(text = "确认")
                }
            }, dismissButton = {
                TextButton(onClick = { showUpdate=false }) {
                    Text(text = "取消")
                }
            }, text = {
                Card(modifier = Modifier) {
                    Text(text = "新版本已可以下载")
                }
            })
        }
    }
}