package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceMain()
                }
            }
        }
    }
}
@Composable
fun SimpleButton(text:String, function:()->Unit) {
    Button(onClick = {
        function()
        //your onclick code here
    },
    modifier = Modifier.widthIn(120.dp)) {
        Text(text = text, fontSize = 18.sp, modifier = Modifier.padding(2.dp))
    }
}
@Composable
fun ArtSpaceMain( ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                ) {
        Column(modifier = Modifier
            .background(Color.LightGray).padding(20.dp).shadow(20.dp)
            .weight(5f)
            ){Column{
            Image(painterResource(id = R.drawable.a1), contentDescription = "Image of art space",
                 contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
            )
        }}
        //Name and Description of the art work
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(2f)) {

            Column (verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(20.dp)
                ){
                Text(text = stringResource(id = R.string.artWork), fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
                Text(text = stringResource(id = R.string.desc))
            }
        }

        Column(modifier = Modifier.padding(5.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                SimpleButton(text = stringResource(id = R.string.previous), moveSlide(1) )
                SimpleButton(text = stringResource(id = R.string.next), moveSlide(-1))
            }

        }
    }
}
fun moveSlide(value:Int)={


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceMain()
    }
}