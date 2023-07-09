package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.DetailedScreen
import com.example.navigation.navigation.FinalScreen
import com.example.navigation.navigation.HomeScreen
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navigator = rememberNavController()
    NavHost(navController = navigator, startDestination = HomeScreen.route){
        composable(HomeScreen.route){
            HomeScreen(navigator)
        }
        composable(DetailedScreen.route){
            DetailedScreen(navigator)
        }
        composable(FinalScreen.route){
            FinalScreen(navigator)
        }

    }
}

@Composable
fun HomeScreen(navigator: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "HomeScreen", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigator.navigate(DetailedScreen.route) }) {
            Text(text ="Go to Detail Screen", modifier = Modifier
                .padding(16.dp)
                .wrapContentSize())
        }
    }
}
@Composable
fun DetailedScreen(navigator: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "DetailedScreen", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigator.navigate(FinalScreen.route) }) {
            Text(text ="Move to Third ", modifier = Modifier
                .padding(16.dp)
                .wrapContentSize())
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigator.popBackStack() }) {
            Text(text ="Go Back ", modifier = Modifier
                .padding(16.dp)
                .wrapContentSize())
        }
    }
}
@Composable
fun FinalScreen(navigator: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "DetailedScreen", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigator.popBackStack() }) {
            Text(text ="Move To Second", modifier = Modifier
                .padding(16.dp)
                .wrapContentSize())
        }
    }
}