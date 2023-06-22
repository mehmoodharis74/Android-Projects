package com.example.loginpage

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage()
                }
            }
        }
    }
}


@Composable
fun EditNumberField(value:String, label:Int, onValueChange:(String)->Unit,modifier:Modifier=Modifier
                    ,type: KeyboardType){
    TextField(value = value, onValueChange = onValueChange, singleLine = true,
        label = { Text(stringResource(id = label))},
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = type, imeAction = ImeAction.Next),
    modifier = modifier)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardFunction(){
    Card(shape = RoundedCornerShape(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp))
    {
        Box(modifier = Modifier
            .padding(start = 5.dp, top = 16.dp, bottom = 16.dp, end = 5.dp)){
            Row {
                Icon(Icons.Filled.Send, contentDescription = "Google",
                modifier = Modifier
                    .padding(start = 10.dp, end = 20.dp)
                    .size(24.dp))
                Text(stringResource(id = R.string.loginGoogle))
            }

    }}
}


@Composable
fun MainPage(modifier: Modifier){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberPass by remember { mutableStateOf(false) }
    Column(modifier = modifier,
    verticalArrangement = Arrangement.Bottom) {
        Column(modifier=Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center)  {
            Text(text = "Sign Up", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(18.dp))
            CardFunction()
            CardFunction()
            CardFunction()
            Spacer(modifier = Modifier.height(30.dp))
        }
        Column {
            Text(stringResource(id = R.string.login), fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.size(10.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            EditNumberField(
                value = email, label = R.string.email, onValueChange = { email = it }, modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth(), KeyboardType.Email
            )
            EditNumberField(
                value = password, label = R.string.password, onValueChange = { password = it }, modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(), KeyboardType.Password
            )
        }
        Column(modifier = Modifier.padding(5.dp)){
            Row(verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp)) {
                Text(stringResource(id = R.string.remember), fontSize = 14.sp)
                Switch(checked = rememberPass, onCheckedChange = {rememberPass=it}
                    , modifier = Modifier
                        .size(10.dp)
                        .padding(end = 5.dp))

            }
            Text(stringResource(id = R.string.forgotPassword)
                , fontSize = 14.sp, color = Color.Red
                , modifier = Modifier.padding(top = 5.dp))

        }
        //Icons for Google login

        //Login Button

        Column {
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                Text(stringResource(id = R.string.login))
            }
        }
    }
}
@Composable
fun LoginPage() {
MainPage(modifier = Modifier
    .fillMaxSize()
    .padding(30.dp))

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginPageTheme {
        LoginPage()
    }
}