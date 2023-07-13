package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigator = rememberNavController()
                    NavHost(navController = navigator, startDestination = Home.route ){
                        composable(Home.route){ HomeScreen(navigator)}
                        composable(Settings.route){ SettingScreen(navigator)}
                    }
                    //create bottom bar using scafold




                }
            }
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
fun SettingScreen(navigator: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Text(text = "SettingScreen", style = MaterialTheme.typography.headlineLarge)

    }
}