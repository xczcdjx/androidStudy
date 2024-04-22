package com.example.myapp1.reactModule

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import xyz.junerver.compose.hooks.useEffect
import xyz.junerver.compose.hooks.useState
private fun mToast(context: Context,str:String){
    Toast.makeText(context, "str: $str", Toast.LENGTH_LONG).show()
}
@Composable
fun Effect(){
    val (count,setCount)=useState(0)
    val ctx= LocalContext.current
    useEffect(count) {
        mToast(ctx,count.toString())
    }
    Button(onClick = { setCount(count+1)}) {
        Text(text = count.toString())
    }
}