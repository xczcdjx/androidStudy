package com.example.myapp1.restart.router

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun NavigateAd() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {
        composable("first") {
            FirstPage(navController)
        }
        composable("second") {
            SecondPage(navController)
        }
        composable("third") {
            ThirdPage(navController)
        }
    }
}

@Composable
fun FirstPage(router: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "First Page")
        TextButton(onClick = {
            router.navigate("second")
        }) {
            Text(text = "to second")
        }
    }
}

@Composable
fun SecondPage(router: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Page")
        TextButton(onClick = {
//            router.navigate("third")
            // 该配置只会跳转一次（用户消息推送页面）
            router.navigate("third") { launchSingleTop = true }
        }) {
            Text(text = "to third")
        }
    }
}

@Composable
fun ThirdPage(router: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Third Page")
        TextButton(onClick = {
//            router.popBackStack("first",true) // 返回不包含上级页面会报错
//            router.popBackStack("first",false)
//            router.popBackStack("second", true)// 返回包含second
        }) {
            Text(text = "to root")
        }
    }
}