package com.example.lemonade_clickbehaviour_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button

import androidx.compose.runtime.*

import com.example.lemonade_clickbehaviour_practice.ui.theme.LemonadeClickBehaviourPracticeTheme
import kotlin.text.Typography.times

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            setContent {
                LemonadeClickBehaviourPracticeTheme {
                    // A surface container using the 'background' color from the theme
                    Lemonade()
                }
            }


    }
}
@Composable
fun WelcomeScreen(name:String, clickState:()->Unit){
    Column {
        Text(text = "Welcome $name!")
        Button(
            onClick = clickState
        ) {
            Text("Start")
        }
    }
}
@Composable
fun Functionality(){
    var currentStep by remember { mutableStateOf(1) }
    var times by remember { mutableStateOf((2..4).random()) }
    when(currentStep){
        1->{
            Surface(
                modifier = Modifier.fillMaxSize()
            ){
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = R.drawable.lemon_tree, ),
                        contentDescription = "lemon tree",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 2 }
                    )


                    Spacer(modifier = Modifier.size(32.dp))
                    Text(stringResource(id = R.string.select), fontSize = 18.sp)
                }
            }
        }
        2->{

            Surface(
                modifier = Modifier.fillMaxSize()
            ){
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = R.drawable.lemon_squeeze, ),
                        contentDescription = "lemon squeeze",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                times--
                                if(times==0)
                                currentStep = 3 }
                    )

//                    append times to msg
                    val msg: String = stringResource(id = R.string.tap) +" "+ times.toString()

                    Spacer(modifier = Modifier.size(32.dp))
                    Text(msg, fontSize = 18.sp)
                }
            }
        }
        3->{
            Surface(
                modifier = Modifier.fillMaxSize()
            ){
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = R.drawable.lemon_drink, ),
                        contentDescription = "lemon Drink",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 4 }
                    )


                    Spacer(modifier = Modifier.size(32.dp))
                    Text(stringResource(id = R.string.drink), fontSize = 18.sp)
                }
            }
        }
        4->{
            Surface(
                modifier = Modifier.fillMaxSize()
            ){
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(id = R.drawable.lemon_restart, ),
                        contentDescription = "lemon start again",
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { currentStep = 1 }
                    )


                    Spacer(modifier = Modifier.size(32.dp))
                    Text(stringResource(id = R.string.empty), fontSize = 18.sp)
                }
            }
        }
    }
}
@Composable
fun Lemonade() {
Functionality()
//    WelcomeScreen("Haris Mehmood", clickState= { Functionality() })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeClickBehaviourPracticeTheme {
        Lemonade()
    }
}