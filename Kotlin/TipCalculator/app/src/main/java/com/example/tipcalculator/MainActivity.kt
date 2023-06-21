package com.example.tipcalculator

import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat
import kotlin.math.round

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
fun RoundSwitch(roundUp:Boolean, onCheckedChanged:(Boolean)->Unit,
    modifier:Modifier = Modifier){
    Row (modifier = modifier
        .fillMaxWidth()
        .size(50.dp),
        verticalAlignment = Alignment.CenterVertically){
        Text(stringResource(id=R.string.round_up_tip))
        Switch(modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End),
            checked = roundUp, onCheckedChange = onCheckedChanged)

    }
}
@Composable
fun EditNumberField(value:String,label:Int,icon:Int, onValueChange:(String)->Unit , modifier: Modifier = Modifier) {
    TextField(
        value = value,
        singleLine=true,
        leadingIcon = { Icon(painter = painterResource(id = icon), null, modifier = Modifier.size(50.dp)) },
        label = { Text(stringResource(id = label))},
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
        modifier = modifier
    )

}
@VisibleForTesting
internal fun tipCalculator(amount:Double, tipPercent:Double, round:Boolean):String {

    var tip = tipPercent/100 * amount
    if(tip <0)
        tip = 0.00
    if(round)
        tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}
@Composable
fun TipTimeLayout(modifier: Modifier = Modifier.fillMaxSize()) {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var round by remember { mutableStateOf(false) }
    val tipPercent = tipInput.toDoubleOrNull()?:0.0
    val tip = tipCalculator(amountInput.toDoubleOrNull()?:0.0, round = round, tipPercent = tipPercent)

    Column(
        modifier = modifier
            .padding(40.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(value = amountInput,label=R.string.bill_amount, icon = R.drawable.ic_launcher_foreground ,onValueChange = {amountInput = it}, modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())
        EditNumberField(value = tipInput,label=R.string.tip_percent, icon = R.drawable.ic_launcher_foreground, onValueChange = {tipInput = it}, modifier = Modifier
            .padding(bottom = 32.dp)
            .fillMaxWidth())
        RoundSwitch(roundUp = round, onCheckedChanged ={round =it}, modifier = Modifier
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