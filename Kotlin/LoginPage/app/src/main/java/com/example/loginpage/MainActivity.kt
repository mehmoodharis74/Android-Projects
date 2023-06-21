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
import androidx.compose.ui.res.stringResource
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
    Card(shape = RoundedCornerShape(10.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ), modifier = Modifier.size(80.dp))
    {
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(10.dp)){
            Icon(Icons.Filled.Send, contentDescription = "Google", modifier = Modifier.fillMaxSize())

    }}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPage(modifier: Modifier){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberPass by remember { mutableStateOf(false) }
    Column(modifier = modifier,
    verticalArrangement = Arrangement.Center) {
        Column {
            Text(stringResource(id = R.string.login), fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(36.dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            EditNumberField(
                value = email, label = R.string.email, onValueChange = { email = it }, modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(), KeyboardType.Email
            )
            EditNumberField(
                value = password, label = R.string.password, onValueChange = { password = it }, modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth(), KeyboardType.Password
            )
        }
        Column{
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(stringResource(id = R.string.remember))
                Switch(checked = rememberPass, onCheckedChange = {rememberPass=it}
                    , modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End) )

            }
            Spacer(modifier = Modifier.size(20.dp))
        }
        //Icons for Google login
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround)  {
            CardFunction()
            CardFunction()
            CardFunction()

        }
        //Login Button

        Column {
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                Text(stringResource(id = R.string.login), fontSize = 20.sp)
            }
        }
    }
}
@Composable
fun LoginPage() {
mainPage(modifier = Modifier
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