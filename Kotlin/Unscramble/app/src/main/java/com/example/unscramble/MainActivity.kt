package com.example.unscramble

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.K
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unscramble.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}
//create lambda function to call in submit button

val submit:()->Unit={

}
val skip:()->Unit={

}
@Composable
fun Unscramble(modifier: Modifier){
    var input by remember { mutableStateOf("") }
    Column(modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Text(
                stringResource(id = R.string.app_name), style = MaterialTheme.typography.labelLarge, color = Color.Gray,
            modifier = Modifier, textAlign = TextAlign.Center)


        }
        Spacer(modifier = Modifier.height(10.dp))
        inputCard()
        Spacer(modifier = Modifier.height(32.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick =  submit) {
            Text(stringResource(id = R.string.submit))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = skip) {
            Text(stringResource(id = R.string.skip))
        }
       


    }
}

@Composable
fun submitButton(text:Int , onClick:()->Unit, modifier: Modifier){

}
@Composable
fun inputFunction(
    value: String,
    label: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    type: KeyboardType
) {
    OutlinedTextField(
        value = value, onValueChange = onValueChange, singleLine = true,
        label = { Text(stringResource(id = label)) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = type,
            imeAction = ImeAction.Next, autoCorrect = true,
        ),
        visualTransformation = if (type == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier, shape = RoundedCornerShape(12.dp)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputCard(){
    var input by remember { mutableStateOf("") }
    Card(modifier = Modifier
        , elevation = CardDefaults.cardElevation(2.dp), shape = MaterialTheme.shapes.small) {
        Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)) {

            Column(
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center, modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Blue)
                ) {
                    Text(
                        text = "0/10",
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        color = Color.White
                    )

                }
            }
            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Word", style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Definition is the some of lock of the app.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))

                inputFunction(
                    value = input,
                    label = R.string.label_for_input,
                    onValueChange = { input = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    type = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(12.dp))


            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnscrambleTheme {
        Unscramble(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))

    }
}