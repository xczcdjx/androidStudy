package com.example.myapp1.restart.base

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp1.R

@Preview(showBackground = true)
@Composable
fun IconAd() {
    Column {
        Icon(imageVector = Icons.Default.Translate
            , contentDescription = null)
        Icon(painter = painterResource(id = R.drawable.mi), contentDescription = null)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }
    }
}