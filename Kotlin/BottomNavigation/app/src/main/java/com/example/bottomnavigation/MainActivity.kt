package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.NavGraph.Home
import com.example.bottomnavigation.NavGraph.Screens
import com.example.bottomnavigation.NavGraph.Settings
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = {}){
                    val bottomList = listOf(Home,Settings)

                    var selectedIndex = rememberSaveable{ mutableStateOf(-1) }


                    Box(modifier = Modifier.padding(it)){
                        val navigator = rememberNavController()

                    }
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