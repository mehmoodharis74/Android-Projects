package com.example.artspaceapp

import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

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

}
@Composable
fun ArtSpaceMain( ) {

var images = arrayListOf<Int>(R.drawable.a1,R.drawable.a2,R.drawable.a3)
    var index by remember { mutableStateOf(0) }
    if(index<0){
        index*=-1
        index--}
    if(index>2)
        index=0

    Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                ) {
        Column(modifier = Modifier
            .padding(20.dp)
            .weight(5f)
            .shadow(20.dp)
            ){Column{
            Image(painterResource(id =images[index]), contentDescription = "Image of art space",
                 contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
            )
        }}
        //Name and Description of the art work
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(2f)) {

            Column (verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = "#dcdedc".color)
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
                Button(onClick = {
                    //your onclick code here
                    index--
                },
                    modifier = Modifier.widthIn(120.dp)) {
                    Text(text = stringResource(id = R.string.previous), fontSize = 18.sp)
                }
                Button(onClick = {
                    //your onclick code here
                    index++
                },
                    modifier = Modifier.widthIn(120.dp)) {
                    Text(text = stringResource(id = R.string.next), fontSize = 18.sp)
                }
            }

        }
    }
}
val String.color
get() = Color(parseColor(this))

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceMain()
    }
}