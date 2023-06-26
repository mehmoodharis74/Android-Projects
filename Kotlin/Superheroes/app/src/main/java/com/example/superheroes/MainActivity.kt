package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.data
import com.example.superheroes.model.model
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroItem(hero:data){
    Card(modifier = Modifier
        .height(72.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp))
        ,elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            HeroDescription(heroName = He, heroDes = , modifier = )

        }
        
    }
}
@Composable
fun HeroIcon(@DrawableRes imageId:Int){
    Box {
       Image(painter = painterResource(id = imageId), contentDescription = "Image of the superhero",
       modifier = Modifier
           .size(72.dp)
           .clip(RoundedCornerShape(8.dp)))
    }
}
@Composable
fun HeroDescription(@StringRes heroName:Int, @StringRes heroDes:Int ,modifier: Modifier){
    Column(modifier = modifier) {
        Row {
           Text(stringResource(id = heroName), style = MaterialTheme.typography.displaySmall)
            Text(stringResource(id = heroDes), style = MaterialTheme.typography.bodyLarge )
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroesTheme {
        Greeting("Android")
    }
}