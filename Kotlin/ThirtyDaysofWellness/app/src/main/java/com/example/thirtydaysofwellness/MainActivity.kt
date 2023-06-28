package com.example.thirtydaysofwellness


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofwellness.model.DayModel
import com.example.thirtydaysofwellness.model.data.Days
import com.example.thirtydaysofwellness.ui.theme.ThirtyDaysOfWellnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfWellnessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayItem(day: DayModel, modifier: Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(2.dp), shape = MaterialTheme.shapes.medium){
        Column(modifier = Modifier
            .clickable { expanded = !expanded }
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )){
            DayFirstSection(day = day.day, title = day.title, image = day.imageRes, modifier = Modifier)
            if(expanded){
            DaySecondSection(description = day.description, modifier = Modifier.padding(bottom = 8.dp, top = 16.dp))

        }}
    }
}
@Composable
fun DayFirstSection(day:Int, @StringRes title:Int, @DrawableRes image:Int, modifier: Modifier){
    Column(modifier = modifier){
        Text(text = "Day $day", modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyLarge)
        Text(
            stringResource(id = title), modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.headlineMedium)
        Image(painter = painterResource(id = image), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium), contentScale = ContentScale.Crop)
    }
}
@Composable
fun DaySecondSection(@StringRes description:Int, modifier: Modifier){
     Column(modifier = modifier) {
        Text(stringResource(id = description), style = MaterialTheme.typography.bodyMedium)
     }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(){
    val days = Days
    Scaffold(topBar = {TopBar()}) { it ->
        LazyColumn(contentPadding = it){
            items(days){
                DayItem(day = it, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            }
        }

    }
}



@Composable
fun TopBar(){
    SmallTopAppBar(title = { Text(text = "30 Days of Wellness", style = MaterialTheme.typography.displayMedium,
        modifier = Modifier)}) }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysOfWellnessTheme {
        Main()
    }
}