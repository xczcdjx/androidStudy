package com.example.myapp1

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp1.components.Btn
import com.example.myapp1.ui.theme.MyApp1Theme

class MainActivity : ComponentActivity() {
    private val Tag="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingPreview()
                    Btn()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    BirthCard("Happy birthday zhangSan","liShi", modifier = Modifier.padding(8.dp))
}
@Composable
fun BirthCard(t:String,a:String,modifier: Modifier=Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(t, fontSize = 80.sp, lineHeight = 116.sp, textAlign = TextAlign.Center)
        Text(a, fontSize = 36.sp, modifier = Modifier
            .padding(15.dp)
            .align(Alignment.End))
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp1Theme {
        BirthCard("Happy birthday zhangSan","liShi", modifier = Modifier.padding(8.dp))
    }
}