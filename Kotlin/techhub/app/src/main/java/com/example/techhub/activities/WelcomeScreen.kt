package com.example.techhub.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.techhub.R
import com.example.techhub.navigation.LoginScreen
import com.example.techhub.navigation.RegisterScreen
import com.example.techhub.theme.TechhubTheme


@Composable
fun UpperPart(navigator: NavHostController, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),onClick = { navigator.navigate(LoginScreen.route) }) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(id = R.string.skip), modifier = Modifier
                    .wrapContentWidth(), fontSize = 13.sp)

            }
        }

        Text(text = stringResource(id = R.string.welcomedesc), fontSize =15.sp, color = Color(0xFF767676))


    }
}
@Composable
fun MiddlePart(modifier: Modifier){
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.welcome_screen_img), contentDescription = "arrow right",
            Modifier
                .fillMaxWidth()
                .height(380.dp)  )
    }
}

@Composable
fun LowerPart(navigator: NavHostController, modifier: Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
       Button(modifier = Modifier.fillMaxWidth(), onClick = {
              navigator.navigate(RegisterScreen.route)      //navigate to register screen
       }) {
           Text(text = stringResource(id = R.string.signup), fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
       }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {
                navigator.navigate(LoginScreen.route)      //navigate to login screen
        }) {
            Text(text = stringResource(id = R.string.login), fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
        }
    }
}


@Composable
fun MainFunction(navigator:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Top ,horizontalAlignment = Alignment.CenterHorizontally) {
        UpperPart(navigator, modifier = Modifier.fillMaxWidth())
        MiddlePart(modifier = Modifier.fillMaxWidth())
        LowerPart(navigator,modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    TechhubTheme {
        val navigator=NavHostController(LocalContext.current)
       MainFunction(navigator)
    }
}