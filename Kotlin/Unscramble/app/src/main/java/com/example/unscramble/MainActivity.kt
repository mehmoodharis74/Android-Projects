package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun Unscramble(modifier: Modifier){
    Column(modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            Text(text = "interesting", style = MaterialTheme.typography.displayMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnscrambleTheme {
        Unscramble(modifier = Modifier.fillMaxSize().padding(16.dp))
    }
}