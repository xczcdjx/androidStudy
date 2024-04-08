package com.example.myapp1.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp1.R
@Preview("businessCard")
@Composable
fun BusinessCard(){
    val user=User("fullname","1314","520@qq.com")
    val letter=Letter("fullname","1314")
    val info= mapOf<String,String>("user" to "zhangSan111","age" to "18","phone" to "13141314")
    Column(modifier = Modifier
        .fillMaxSize()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Column(modifier = Modifier
            .padding(5.dp)
            .width(400.dp)
            .height(210.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(painter = painterResource(id = R
                .drawable.img), contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Text(letter.tit, fontSize = 30.sp)
            Text(letter.subTit, fontSize = 18.sp)
        }
        Spacer(Modifier.padding(vertical = 4.dp))
        info.mapValues { (_,v)->
            Row (
                modifier = Modifier
                    .padding(vertical = 5.dp).width(200.dp).height(40.dp),
//                        horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(painter = painterResource(id = R
                    .drawable.mi), contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(Modifier.padding(horizontal = 4.dp))
                Text(v, fontSize = 30.sp)
            }
        }
        LazyColumn {
            info.forEach { (t, u )->
                item {
                    Row (
                        modifier = Modifier
                            .padding(vertical = 5.dp).width(200.dp).height(40.dp),
//                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(painter = painterResource(id = R
                            .drawable.mi), contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(Modifier.padding(horizontal = 4.dp))
                        Text(u, fontSize = 30.sp)
                    }
                }
            }
        }
    }
}
data class Letter(val tit:String,val subTit:String)
data class User(val name:String,val phone:String,val email:String)
