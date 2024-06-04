package com.example.myapp1.restart.correspond

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
data class User(val name: String, val age: Int)
val localActiveUser = compositionLocalOf<User?> { error("empty!") }
@Preview(showBackground = true)
@Composable
fun MesAd() {
    val nav = rememberNavController()
    var user by remember {
        mutableStateOf<User?>(null)
    }
    CompositionLocalProvider(localActiveUser provides user) {
        NavHost(navController = nav, startDestination = "A") {
            composable("A") {
                A {
                    user = it
                    nav.navigate("B")
                }
            }
            composable("B") {
                B {
                    nav.popBackStack()
                }
            }
        }
    }
}
@Composable
private fun A(bind: (u: User) -> Unit) {
    Column {
        Text(text = "A ${localActiveUser.current}")
        val user = User("张三", 18)
        TextButton(onClick = { bind(user) }) {
            Text(text = "绑定数据 $user")
        }
    }
}

@Composable
private fun B(user: () -> Unit) {
   Column {
       Text(text = "Detail")
       Text(text = "A ${localActiveUser.current?.let { it.name + it.age }}")
       TextButton(onClick = { user() }) {
           Text(text = "Back")
       }
   }
}

@Composable
private fun Father() {

}

@Composable
private fun Son() {

}