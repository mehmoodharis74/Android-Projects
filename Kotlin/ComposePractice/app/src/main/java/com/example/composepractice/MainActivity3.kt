package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ComposePracticeTheme


import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*



import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ThirdTask()
                }
            }
        }
    }
}
@Composable
fun Card(head:String, content:String, colour:String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color(colour.toInt()))
            .padding(16.dp)
    ) {
        Text(text = head, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = content)
    }


}
@Composable
fun ThirdTask() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f,true)) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp)
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Text(text = "Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "Displays text and follows the recommended Material Design guidelines.")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .padding(16.dp)
                    .weight(1f).fillMaxSize()
            ) {
                Text(text = "Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "Displays text and follows the recommended Material Design guidelines.")
            }
        }
        Row(modifier = Modifier.weight(1f)) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFFB69DF8))
                    .padding(16.dp)
                    .weight(1f).fillMaxSize()
            ) {
                Text(text = "Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "Displays text and follows the recommended Material Design guidelines.")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color(0xFFF6EDFF))
                    .padding(16.dp)
                    .weight(1f).fillMaxSize()
            ) {
                Text(text = "Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "Displays text and follows the recommended Material Design guidelines.")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposePracticeTheme {

        ThirdTask()
    }
}