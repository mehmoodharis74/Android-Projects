package com.example.composepractice

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class businessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable

fun Card() {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .padding(vertical = 16.dp)
        ) {
            Image(
                painterResource(id = R.drawable.logo),
                "Business card logo image",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 5.dp)
                    .background(Color.Black)
            )
            Text(
                text = "Haris Mehmood",
                fontSize = 36.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = "Android Developer",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3ddc84),
                modifier = Modifier.padding(top = 5.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "Phone",
                modifier = Modifier.size(30.dp).padding(end = 10.dp))
                Text(text = "03165492388", color = Color(0xFF3ddc84))
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "Phone",
                modifier = Modifier.size(30.dp).padding(end = 10.dp))
                Text(text = "03165492388", color = Color(0xFF3ddc84))
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.logo), contentDescription = "Phone",
                modifier = Modifier.size(30.dp).padding(end = 10.dp))
                Text(text = "03165492388", color = Color(0xFF3ddc84))
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposePracticeTheme {
        Card()
    }
}