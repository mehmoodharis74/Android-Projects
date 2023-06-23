package com.example.gridviewjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridviewjetpackcompose.model.Topic
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLayout(topic:Topic, modifier: Modifier=Modifier){
    Card(modifier = modifier) {
        Row(modifier = Modifier
            .height(68.dp)
            .fillMaxWidth()) {
            Image(painter = painterResource(id = topic.imageId)
                , contentDescription = stringResource(id = topic.text), modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp))
        }
    }

}
@Composable
fun mainFunction() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridViewJetPackComposeTheme {
        //CardLayout()
    }
}