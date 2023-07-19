package com.example.bottomnavigation

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.NavGraph.Home
import com.example.bottomnavigation.NavGraph.Settings
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                val navigator = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = { MyBottomNavigation(navigator = navigator)}){



                    Box(modifier = Modifier.padding(it)){

                        NavHost(navController = navigator, startDestination = Home.route ){
                            composable(Home.route){ HomeScreen(navigator)}
                            composable(Settings.route){ SettingScreen()}
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun MyBottomNavigation(navigator: NavHostController){
    val destinationList = listOf(Home,Settings)
    val selectedIndex = rememberSaveable{ mutableStateOf(0) }

    BottomNavigation(modifier = Modifier.background(MaterialTheme.colorScheme.onSecondaryContainer)) {destinationList.forEachIndexed { index, screens ->
        BottomNavigationItem(
            label = { Text(text = screens.title,
                modifier = Modifier.padding(bottom = 4.dp), color = androidx.compose.ui.graphics.Color.White) },
            icon = { Icon( screens.icon, contentDescription = "icon", modifier = Modifier.padding(bottom = 4.dp)) },
            selected = index==selectedIndex.value , onClick = {
                selectedIndex.value = index
                navigator.navigate(destinationList[index].route){
                    popUpTo(Home.route){saveState = true}
                    launchSingleTop = true
                    restoreState = true
                }
            })
    }
        
    }
}

@Composable
fun HomeScreen(navigator: NavHostController){
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Text(text = "HomeScreen", style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable { navigator.navigate(Settings.route) })

    }
}
@Composable
fun SettingScreen() {
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomPreview() {
    BottomNavigationTheme {
        val navigator = rememberNavController()
        // A surface container using the 'background' color from the theme
        Scaffold(bottomBar = { MyBottomNavigation(navigator = navigator)}){



            Box(modifier = Modifier.padding(it)){

                NavHost(navController = navigator, startDestination = Home.route ){
                    composable(Home.route){ HomeScreen(navigator)}
                    composable(Settings.route){ SettingScreen()}
                }
            }
        }
    }
}