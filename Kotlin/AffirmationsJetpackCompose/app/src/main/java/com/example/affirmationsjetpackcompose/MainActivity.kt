package com.example.affirmationsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmationsjetpackcompose.data.AffirmationData
import com.example.affirmationsjetpackcompose.model.AffirmationModel
import com.example.affirmationsjetpackcompose.ui.theme.AffirmationsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsJetpackComposeTheme {
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
fun CardFunction(affirmation:AffirmationModel,modifier: Modifier= Modifier){
    Card(modifier = modifier) {
        Column() {
            Image(painter = painterResource(id = affirmation.imageId)
                , contentDescription = affirmation.textId,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp), contentScale = ContentScale.Crop

            )
            Text(text = affirmation.textId,modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}
@Composable
fun Affirmation(affirmationList: List<AffirmationModel>,modifier: Modifier){
LazyColumn(modifier = modifier){
    items(affirmationList) {affirmationList ->
        CardFunction(affirmation = affirmationList
        ,modifier = Modifier.padding(8.dp))  }
}
}
@Composable
fun mainFunction(){
    Affirmation(
        affirmationList = AffirmationData().loadData(),
        modifier = Modifier
            .fillMaxSize()
            )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AffirmationsJetpackComposeTheme {
        mainFunction()
    }
}