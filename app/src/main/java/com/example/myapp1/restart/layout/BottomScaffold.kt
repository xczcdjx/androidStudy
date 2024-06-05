package com.example.myapp1.restart.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun BottomScaffoldTest() {
    val scope = rememberCoroutineScope()
    val scaffoldState =rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState=scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = "主页") }, navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }, actions = {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            })
        }, sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(38.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Swipe up to expand sheet")
            }
            Column (
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "展示")
                Spacer(modifier = Modifier.padding(10.dp))
                TextButton(onClick = {
                    scope.launch {
                            scaffoldState.bottomSheetState.collapse()
                    }
                }) {
                    Text(text = "Close")
                }
            }
        }, sheetPeekHeight = 128.dp) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(100) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }
        }
    }
    /* ModalBottomSheetLayout(sheetContent = ) {

     }*/
}