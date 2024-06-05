package com.example.myapp1

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.myapp1.components.Btn
import com.example.myapp1.components.FlowLayout
import com.example.myapp1.initial.CardList
import com.example.myapp1.initial.Conversation
import com.example.myapp1.initial.FoldList
import com.example.myapp1.initial.Message
import com.example.myapp1.initial.MsgData
import com.example.myapp1.practice.BusinessCard
import com.example.myapp1.reactModule.Effect
import com.example.myapp1.reactModule.State
import com.example.myapp1.restart.base.ButtonAd
import com.example.myapp1.restart.base.ImageAd
import com.example.myapp1.restart.base.StateUse
import com.example.myapp1.restart.base.SwitchAd
import com.example.myapp1.restart.base.TextFieldAd
import com.example.myapp1.restart.correspond.MesAd
import com.example.myapp1.restart.layout.BottomScaffoldTest
import com.example.myapp1.restart.layout.LazyColumnAd
import com.example.myapp1.restart.layout.ListItemAd
import com.example.myapp1.restart.layout.ScaffoldAd
import com.example.myapp1.restart.layout.ScaffoldAd2
import com.example.myapp1.restart.layout.ScaffoldAd3
import com.example.myapp1.restart.layout.ScaffoldAd4
import com.example.myapp1.restart.layout.TestAd
import com.example.myapp1.restart.life.LifeAd
import com.example.myapp1.restart.router.NavigateAd
import com.example.myapp1.restart.router.NavigateParamsAd
import com.example.myapp1.restart.views.DropDownMenuAd
import com.example.myapp1.restart.views.SurfaceAd
import com.example.myapp1.restart.views.TabRowAd
import com.example.myapp1.ui.theme.MyApp1Theme
import com.example.myapp1.utils.L
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    private val Tag = "main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp1Theme {
                // 沉浸式导航
                enableEdgeToEdge()
                val systemUiController = rememberSystemUiController()
                val isDark= isSystemInDarkTheme() // 跟随系统主题更改
                SideEffect {
                    // 因为我们目前没有暗色主题的UI，所以都是亮色主题UI，我们默认使用暗色的状态栏ICON
                    // ，防止出现标题栏字体颜色和UI背景融合的情况
                    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !isDark)
//                    window.statusBarColor = Color.Transparent.toArgb()
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .statusBarsPadding()
                    , color = MaterialTheme.colorScheme.background
                ) {
//                    BirthCard(t = "Happy birthday", a = "zhangSan", modifier = Modifier.background(MaterialTheme.colorScheme.background))
//                    Btn()
                }
//                Conversation(messages = MsgData.messages)
//                BusinessCard()
//                FoldList(messages = MsgData.messages)
//                State()
                /* Effect()
                 Common(str = "Flow layout") {
                     FlowLayout()
                 }*/
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                   /* Common(str = "Button") {
                        ButtonAd()
                    }
                    Common(str = "Image") {
                        ImageAd()
                    }
                    Common(str = "State") {
                        StateUse()
                    }
                    Common(str = "State") {
                        SwitchAd()
                    }
                    Common(str = "loginForm") {
                        TextFieldAd()
                    }*/
                   /* Common(str = "listItem") {
                        ListItemAd()
                    }*/
                   /* Common(str = "lazyColumn") {
                        TestAd()
                    }*/
                   /* Common(str = "View") {
                        TabRowAd()
                        DropDownMenuAd()
                        SurfaceAd()
                    }*/
//                    NavigateAd()
//                    NavigateParamsAd()
//                    LifeAd()
//                    MesAd()
//                    ScaffoldAd4()
                    BottomScaffoldTest()
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
fun Common(str: String, cb: @Composable () -> Unit) {
    Column(
        modifier = Modifier
//            .fillMaxWidth()
    ) {
        Text(str)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        cb()
    }
}