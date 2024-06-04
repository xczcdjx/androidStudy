package com.example.myapp1.restart.life

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.utils.L
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
// 生命周期
fun LifeAd() {
    var count by remember {
        mutableStateOf(0)
    }
    var state by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaff = rememberBottomSheetScaffoldState()
//    val currentOnTimeout by rememberUpdatedState()rememberUpdatedStatez
    // Unit 只会挂载时执行一次
    LaunchedEffect(count) {
        L.log("yyyyyyyyyy$count")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "当前count $count,当前state $state", modifier = Modifier.statusBarsPadding())
        TextButton(onClick = {
            count += 1
            scope.launch {
                scaff.snackbarHostState.showSnackbar("message $count")
            }
        }) {
            Text(text = "count $count")
        }
        TextField(value = state, onValueChange = { state = it }, label = {
            Text("账号")
        })
        if (count % 2 == 0) SonAd(c = count)
    }
}

@Composable
fun SonAd(c: Int) {
    DisposableEffect(Unit) {
        L.log("执行 $c")
        onDispose {
            L.log("销毁 $c")
        }
    }
    Text(text = "子组件count $c")
}