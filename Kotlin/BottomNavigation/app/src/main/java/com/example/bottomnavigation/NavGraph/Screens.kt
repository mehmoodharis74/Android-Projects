package com.example.bottomnavigation.NavGraph


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Screens {
    val route:String
    val title:String
    val icon: ImageVector

}
object Home:Screens{
    override val route: String = "home"
    override val icon: ImageVector = Icons.Filled.Home
    override val title: String = "Home"
}
object Settings:Screens{
    override val route: String = "settings"
    override val icon: ImageVector = Icons.Filled.Settings
    override val title: String = "Settings"
}