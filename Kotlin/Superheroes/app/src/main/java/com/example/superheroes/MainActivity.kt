package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Model
import com.example.superheroes.model.data
import com.example.superheroes.model.data.Heroes
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
                    SuperHero()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHero(){
    Scaffold(topBar = { TopBar() }){it->
        val heroes = Heroes
        LazyColumn(contentPadding = it){
            items(heroes){
                HeroItem(hero = it, modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .fillMaxWidth())
            }
        }
    }
}
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(title = {
        Row {
            Text(text = "SuperHeroes", style = MaterialTheme.typography.displayLarge)
        }
    })

}
@Composable
fun MyFunction(){
    val heroes = Heroes
    LazyColumn{
        items(heroes){
            HeroItem(hero = it, modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth())
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroItem(hero: Model,modifier: Modifier){
    Card(modifier = modifier
        ,elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .height(72.dp)
                    .fillMaxWidth()) {
                HeroDescription(heroName = hero.nameRes, heroDes = hero.descriptionRes , modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(2f))
                HeroIcon(imageId = hero.imageRes)
            }


        
    }
}
@Composable
fun HeroIcon(@DrawableRes imageId:Int){
    Box(modifier = Modifier){
       Image(painter = painterResource(id = imageId), contentDescription = "Image of the superhero",
       modifier = Modifier
           .size(72.dp)
           .clip(RoundedCornerShape(8.dp)), contentScale = ContentScale.Crop)
    }
}
@Composable
fun HeroDescription(@StringRes heroName:Int, @StringRes heroDes:Int ,modifier: Modifier){
    Column(modifier = modifier) {
            Text(stringResource(id = heroName), style = MaterialTheme.typography.displaySmall)
            Text(stringResource(id = heroDes), style = MaterialTheme.typography.bodyLarge )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroesTheme {
        HeroItem(hero = Model(R.string.hero4,R.string.description4,R.drawable.a4)
            , modifier = Modifier
                .clip(RoundedCornerShape(16.dp)))
    }
}