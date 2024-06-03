package com.example.myapp1.restart.router

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun NavigateParamsAd() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {
        composable("first") {
            FirstPage2 { name, age ->
                // 动态导航
                navController.navigate("second/${name}/$age")
            }
        }
        composable("second/{name}/{age}", arguments = listOf(
            navArgument("age") {
                type = NavType.IntType
            }
        )) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age")
            SecondPage2(name, age) {
                // 可选参数并带默认参数导航
                navController.navigate("third?id=8888")
            }
        }
        composable("third?id={id}", arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
                nullable = true
                defaultValue = "100101"
            }
        )) {
            val id = it.arguments?.getString("id")
            ThirdPage2(id) {
                navController.popBackStack("first", false)
            }
        }
    }
}

@Composable
fun FirstPage2(push: (name: String, age: Int) -> Unit) {
    var age by remember {
        mutableStateOf(18)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            // 导航条及状态栏
//            .statusBarsPadding().navigationBarsPadding()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "首页", fontSize = 30.sp, modifier = Modifier.statusBarsPadding())
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                TextButton(onClick = {
                    age += 1
                }) {
                    Text(text = "age+1")
                }
                Text(text = "First Page123")
                TextButton(onClick = {
                    push("lily", age)
                }) {
                    Text(text = "to second")
                }
            }
        }
    }
}

@Composable
fun SecondPage2(pathName: String?, pathAge: Int?, push: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
//        contentPadding = rememberI
    ) {
        item{
            Text(text = "Second Page ${pathName}, ${pathAge}")
            TextButton(onClick = {
                push()
            }) {
                Text(text = "to third")
            }
        }
        items(100) {
            Text(text = "test ...... $it")
        }
    }
}

@Composable
fun ThirdPage2(id: String?, back: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Third Page, id=$id")
        TextButton(onClick = {
            back()
        }) {
            Text(text = "to root")
        }
    }
}