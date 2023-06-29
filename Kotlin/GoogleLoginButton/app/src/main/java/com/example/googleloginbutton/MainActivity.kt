package com.example.googleloginbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googleloginbutton.ui.theme.GoogleLoginButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleLoginButtonTheme {
                // A surface container using the 'background' color from the theme
                    GoogleSignUpButton()

            }
        }
    }
}
@Composable
fun GoogleSignUpButton() {
    Surface(modifier = Modifier
        .border(1.dp, Color.Gray)
        .width(200.dp)
        .height(36.dp),
        shape = MaterialTheme.shapes.medium) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(painter = painterResource(id = R.drawable.google)
                , contentDescription ="Google Icon", tint = Color.Unspecified ,
            modifier = Modifier
                .padding(start = 12.dp)
                .size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Sign Up with Google", modifier = Modifier.padding(end = 16.dp),
                style = MaterialTheme.typography.bodySmall)
        }


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleLoginButtonTheme {
        GoogleSignUpButton()
    }
}