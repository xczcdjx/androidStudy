package com.example.myapp1.base

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp1.R
import com.example.myapp1.ui.theme.MyApp1Theme

class MainActivity : ComponentActivity() {
    private val Tag="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1Theme {
                // A surface container using the 'background' color from the theme

                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
//    Text("6767")
}
@Composable
fun ListImg(){
    Row(Modifier.padding(3.dp).border(BorderStroke(1.dp, Color.Black))) {
        Image(painter = painterResource(id = R.drawable.img), modifier = Modifier.size(40.dp).clip(
            CircleShape), contentDescription = null)
        Spacer(modifier = Modifier.padding(4.dp))
        Column {
            Text("张三")
//            Spacer(modifier = Modifier.padding(4.dp))
            Text("qaz,lp")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp1Theme {
        ListImg()
    }
}