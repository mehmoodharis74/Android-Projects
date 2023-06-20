package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
            //create variable of tipPercent type double and set to null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TipTimeLayout()
                }
            }
        }
    }
}
@Composable
fun EditNumberField(value:String, onValueChange:(String)->Unit , modifier: Modifier = Modifier.background(Color.Blue)) {

     //= tip.toDouble()
    TextField(
        value = value,
        singleLine=true,
        label = { Text(stringResource(id = R.string.bill_amount))},
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}
private fun tipCalculator(amount:Double, tipPercent:Double = 0.15):String {
    val tip = amount * tipPercent
    return NumberFormat.getCurrencyInstance().format(tip)
}
@Composable
fun TipTimeLayout(modifier: Modifier = Modifier.fillMaxSize()) {
    var amountInput by remember { mutableStateOf("") }
    val tip = tipCalculator(amountInput.toDoubleOrNull()?:0.0)
    Column(
        modifier = modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(amountInput, onValueChange = {amountInput = it}, modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())
        Text(
            text = stringResource(R.string.tip_amount ,tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
        TipTimeLayout()
    }
}