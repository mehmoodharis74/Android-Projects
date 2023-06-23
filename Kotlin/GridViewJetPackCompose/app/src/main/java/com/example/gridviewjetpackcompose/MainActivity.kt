package com.example.gridviewjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gridviewjetpackcompose.ui.theme.GridViewJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridViewJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   mainFunction()
                }
            }
        }
    }
}
@Composable
fun CardLayout(modifier: Modifier=Modifier){

}
@Composable
fun mainFunction() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridViewJetPackComposeTheme {
        CardLayout()
    }
}