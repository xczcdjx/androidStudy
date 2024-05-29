package com.example.myapp1.restart.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PanoramaFishEye
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun TextFieldAd() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = username, onValueChange = { username = it }, label = {
            Text("账号")
        }, placeholder = {
            Text("请输入账号")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }, isError = true)
        TextField(value = password, onValueChange = { password = it }, label = {
            Text("密码")
        }, placeholder = {
            Text("请输入密码")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }, trailingIcon = {
            Icon(imageVector = Icons.Default.PanoramaFishEye, contentDescription = null)
        }, singleLine = true,
            keyboardActions = KeyboardActions(onDone = {

            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Phone
            )
        )
    }
}