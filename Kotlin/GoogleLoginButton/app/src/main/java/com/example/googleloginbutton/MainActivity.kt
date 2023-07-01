package com.example.googleloginbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background

import androidx.compose.foundation.border


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleSignUpButton() {
    var clicked by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Surface(onClick = {clicked = !clicked}, modifier = Modifier.border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(
                        start = 16.dp, end = 16.dp,
                        top = 12.dp, bottom = 12.dp
                    )
                    .animateContentSize(animationSpec = tween(durationMillis = 300, delayMillis = 1))
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    stringResource(id = if (!clicked) R.string.signup else R.string.creating_account),
                    style = MaterialTheme.typography.bodySmall
                )
                if (clicked) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(16.dp),
                        color = MaterialTheme.colorScheme.primary, strokeWidth = 2.dp,
                    )

                }


            }
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