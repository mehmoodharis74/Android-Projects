package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.OptIn
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.Dog
import com.example.woof.data.dogs
import com.example.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofApp()
                }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of dogs.
 */
@kotlin.OptIn(ExperimentalMaterial3Api::class)

@Composable
fun WoofApp() {
    Scaffold (
        topBar = { TopBar() }
            ){ it ->
        LazyColumn(contentPadding = it) {
        items(dogs) {
            DogItem(dog = it, modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) }
        }
    }


}


/**
 * Composable that displays a list item containing a dog icon and their information.
 *
 * @param dog contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(targetValue = if (expanded) MaterialTheme.colorScheme.primaryContainer else
        MaterialTheme.colorScheme.tertiaryContainer)
    Card(modifier = modifier ) {
        Column(modifier = Modifier

        ){
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))

        ) {
            DogIcon(dog.imageResourceId)
            DogInformation(dog.name, dog.age)
            Spacer(modifier = Modifier.weight(1f))
            DogIconButton(expanded = expanded, onClick = { expanded = !expanded })
        }
            if (expanded){
                DogHobby(
                    hobby = dog.hobbies,
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_medium)
                    )
                )
            }}}

}

/**
 * Composable that displays a photo of a dog.
 *
 * @param dogIcon is the resource ID for the image of the dog
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(dogIcon),
        contentScale = ContentScale.Crop,


        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

/**
 * Composable that displays a dog's name and age.
 *
 * @param dogName is the resource ID for the string of the dog's name
 * @param dogAge is the Int that represents the dog's age
 * @param modifier modifiers to set to this composable
 */
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style=MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Composable
fun TopBar(modifier: Modifier =Modifier){
    CenterAlignedTopAppBar(modifier = modifier, title = {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_woof_logo)
                , contentDescription = "Logo of the app",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .padding(dimensionResource(id = R.dimen.padding_small)))
            Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge)
        }
    })


}
@Composable
fun DogIconButton(expanded:Boolean, onClick:()->Unit,   modifier: Modifier=Modifier){
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
    }
}

@Composable
fun DogHobby(@StringRes hobby:Int, modifier: Modifier= Modifier){
    Column(modifier = modifier) {
        Text(stringResource(id = R.string.about), style = MaterialTheme.typography.labelSmall)
        Text(stringResource(id = hobby), style = MaterialTheme.typography.bodyLarge)
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WoofTheme(darkTheme = false) {
        WoofApp()
    }
}