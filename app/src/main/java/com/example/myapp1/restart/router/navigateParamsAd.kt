package com.example.myapp1.restart.router

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
                navController.navigate("third")
            }
        }
        composable("third") {
            ThirdPage2 {
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
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
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

@Composable
fun SecondPage2(pathName: String?, pathAge: Int?, push: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Second Page ${pathName}, ${pathAge}")
        TextButton(onClick = {
            push()
        }) {
            Text(text = "to third")
        }
    }
}

@Composable
fun ThirdPage2(back: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Third Page")
        TextButton(onClick = {
            back()
        }) {
            Text(text = "to root")
        }
    }
}