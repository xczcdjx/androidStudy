package com.example.myapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp1.components.FlowLayout
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
//                    BirthCard(t = "Happy birthday", a = "zhangSan", modifier = Modifier.background(MaterialTheme.colorScheme.background))
//                    Btn()
                }
//                Conversation(messages = MsgData.messages)
//                BusinessCard()
//                FoldList(messages = MsgData.messages)
                Common(str = "Flow layout") {
                    FlowLayout()
                }
            }
        }
    }
}
/*

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
        BirthCard("Happy birthday zhangSan","liShi", modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.background))
    }
}*/
@Composable
fun Common(str:String, cb:@Composable () -> Unit){
    Column(modifier= Modifier
        .fillMaxWidth()) {
        Text(str)
        Spacer(modifier=Modifier.padding(vertical = 5.dp))
        cb()
    }
}