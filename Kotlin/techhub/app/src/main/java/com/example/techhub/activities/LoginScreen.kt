package com.example.techhub.activities


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.techhub.R
import com.example.techhub.ui.theme.TechhubTheme
import com.example.techhub.utils.TextInputField


@Composable
fun BackgroundPart(modifier: Modifier){

    Column(modifier = modifier) {
        Column(modifier = Modifier.padding(start = 16.dp, top= 32.dp)) {
            Text(text = stringResource(id = R.string.login), fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp, color = Color.White)
            Text(text = stringResource(id = R.string.logindesc),
                fontSize = 13.sp,color = Color.White)

        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Text(text = stringResource(id = R.string.tagline), fontSize = 28.sp,
            modifier = Modifier
                .offset(8.dp)
                .weight(1f), color = Color.White)
            Image(painter = painterResource(id = R.drawable.login_watch),
                contentDescription = "watch", modifier = Modifier
                    .size(200.dp)
                    .offset(y = 10.dp), contentScale = ContentScale.Crop)
        }


    }

}


@Composable
fun BottomSheetPart(navigator: NavHostController, modifier: Modifier){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var checked by rememberSaveable { mutableStateOf(false)}
    Box(modifier = modifier
        .background(
            color = Color.White,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        )
        .padding(16.dp)) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            TextInputField(value = email, label = R.string.email,
                onValueChange = {email=it}, type =KeyboardType.Email, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.size(8.dp))
            TextInputField(value = password, label = R.string.password,
                onValueChange = {password=it}, type =KeyboardType.Password , modifier = Modifier.fillMaxWidth())
            Text(text = stringResource(id = R.string.forgotpassword), fontSize = 13.sp, color = Color(0xFF767676), textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
            //Login Button
            Button(modifier = Modifier.fillMaxWidth(), onClick = {

            }) {
                Text(text = stringResource(id = R.string.login), fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            }
            //Remember Me Section
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = stringResource(id = R.string.rememberme), fontSize = 13.sp, color = Color(0xFF767676), textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentWidth())
                Switch(checked = checked, onCheckedChange ={checked=it}, modifier = Modifier)
            }
            //Other Login Options Section
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Divider(modifier = Modifier.weight(1f))
                Text(text = stringResource(id = R.string.orcontinuewith), fontSize = 13.sp, color = Color(0xFF767676), textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 4.dp))
                Divider(modifier = Modifier.weight(1f))
            }
            //Social Media Login Options
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement=Arrangement.SpaceAround){
                Box(modifier = Modifier.border(BorderStroke(1.dp,  color = Color(0xFF767676)), shape = RoundedCornerShape(100.dp))) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.facebook_logo), contentDescription = "google",
                            modifier = Modifier.size(25.dp))
                    }
                }
                Box(modifier = Modifier.border(BorderStroke(1.dp,  color = Color(0xFF767676)), shape = RoundedCornerShape(100.dp))) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.google_logo), contentDescription = "google",
                            modifier = Modifier.size(50.dp))
                    }
                }
                Box(modifier = Modifier.border(BorderStroke(1.dp,  color = Color(0xFF767676)), shape = RoundedCornerShape(100.dp))) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(painter = painterResource(id = R.drawable.twitter_logo), contentDescription = "google",
                            modifier = Modifier.size(25.dp))
                    }
                }

            }

        }
    }
}

@Composable
fun MainLoginFunction(navigator:NavHostController){
    Column(modifier = Modifier.background(Color.Black).verticalScroll(rememberScrollState())) {
        BackgroundPart(modifier = Modifier)
        BottomSheetPart(navigator, modifier = Modifier.fillMaxSize())
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navigator=NavHostController(LocalContext.current)
    TechhubTheme() {
        MainLoginFunction(navigator)
    }

}