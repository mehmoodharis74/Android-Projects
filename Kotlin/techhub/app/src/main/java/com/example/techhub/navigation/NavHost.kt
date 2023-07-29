package com.example.techhub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techhub.activities.MainFunction
import com.example.techhub.activities.MainLoginFunction
import com.example.techhub.activities.MainSignUpFunction

@Composable
fun NavigationFunction() {
    val navigator = rememberNavController()

    NavHost(navController = navigator, startDestination = WelcomeScreen.route) {
        composable(WelcomeScreen.route) { MainFunction(navigator) }
        composable(LoginScreen.route) { MainLoginFunction(navigator) }
        composable(RegisterScreen.route) { MainSignUpFunction(navigator) }
    }
}