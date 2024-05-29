package com.example.myapp1.reactModule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import xyz.junerver.compose.hooks.useLatestRef
import xyz.junerver.compose.hooks.useRef
import xyz.junerver.compose.hooks.useState
import kotlin.time.Duration.Companion.seconds

@Preview(showBackground = true)
@Composable
fun State() {
    val (name, setName) = useState("111")
    Column {
        Text(text = "input：$name")
        OutlinedTextField(value = name, onValueChange = setName,
            label = { Text(text = name) }
        )
        Spacer(modifier = Modifier.height(20.dp))
        UseStateQ()
        Spacer(modifier = Modifier.height(20.dp))
        UseStateQ2()
    }
}
@Composable
private fun UseStateQ(){
    val (n,setN)= remember { mutableStateOf(123) }
    val n2= remember { mutableStateOf(123) }
    var value by remember { mutableStateOf(123) }
    val (s,set)= useState("state")
    val (s2,set2)= useState("state")
    val state2Ref= useLatestRef(s2)
    var byState by useState("by delegate")
    LaunchedEffect(key1 = Unit) {
        repeat(10){
            delay(1.seconds)
            set("8989")
            byState+="."
            set2(state2Ref.current)
            value+=9
            n2.value=77777
            setN(n+1)
        }
    }
    Column {
        Text(text = "Question1. Closure problems")
        Text(text = s)
        Button(onClick = {
            set2(s2+"1")
        }) {
            Text(text = "按钮", fontSize = 10.sp)
        }
        Text(text = s2)
        Text(text = byState)
        Text(text = n.toString())
        Text(text = n2.value.toString())
        Text(text = value.toString())
        Text(text = byState)
    }
}
@Composable
private fun UseStateQ2() {
    val (s, set) = useState("state")
    val stateRef= useLatestRef(s)
    var byState by useState("99999")
    LaunchedEffect(key1 = Unit) {
        repeat(20){
            set("hello world")
            byState+="."
        }
    }
    Column {
        Text(text = "Question2. modify state very quickly")
        Text(text = s)
        Text(text = byState)
    }
}