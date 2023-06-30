package com.example.unscramble

import android.os.Bundle
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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
@Composable
fun DialogFunction(title: Int, message: Int, success:Int, exit: Int) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .clip(RoundedCornerShape(8.dp))
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = title),
            style = MaterialTheme.typography.labelLarge,
            color = Color.Gray,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            stringResource(id = message),
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(stringResource(id = success))
        }
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(stringResource(id = exit))
        }
    }
}
//create submit lambda function that takkd input paramefer of string
@Composable
fun SubmitFunctionality() {
    val submit: (input: String, input_word: Int) -> Unit = { s: String, i: Int ->
//        if (s == "game") {
//            // Generate dialog box with title "Correct" and message "You guessed correctly"
//            DialogBox(
//                title = R.string.correct,
//                message = R.string.correct_message,
//                success = R.string.submit,
//                exit = R.string.exit
//            )
//        } else {
//            // Generate dialog box with title "Incorrect" and message "You guessed incorrectly"
//            DialogBox(
//                title = R.string.incorrect,
//                message = R.string.incorrect_message,
//                success = R.string.submit,
//                exit = R.string.exit
//            )
//        }
    }

}

val skip:()->Unit={

}
@Composable
fun Unscramble(modifier: Modifier){
    var input by remember { mutableStateOf("") }
    var word by remember { mutableStateOf("game") }
    Column(modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Text(
                stringResource(id = R.string.app_name), style = MaterialTheme.typography.labelLarge, color = Color.Gray,
            modifier = Modifier, textAlign = TextAlign.Center)


        }
        Spacer(modifier = Modifier.height(10.dp))
        inputCard(word = word)
        Spacer(modifier = Modifier.height(32.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            if(input== word) {

            }

        }) {
            Text(stringResource(id = R.string.submit))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = skip) {
            Text(stringResource(id = R.string.skip))
        }
       


    }
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
fun inputCard(word:String){
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
                    text = word, style = MaterialTheme.typography.displaySmall,
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