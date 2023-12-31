package com.example.googleloginbutton

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import kotlinx.coroutines.delay


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

        Surface(modifier = Modifier.clickable { clicked = !clicked }, border = BorderStroke(if(isSystemInDarkTheme())1.dp else 0.dp , color = Color.Gray) ,   shape = MaterialTheme.shapes.small) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(
                        start = 16.dp, end = 16.dp,
                        top = 12.dp, bottom = 12.dp
                    )
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            delayMillis = 1
                        )
                    )
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
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DarkPreview() {
    GoogleLoginButtonTheme {
        GoogleSignUpButton()
    }
}