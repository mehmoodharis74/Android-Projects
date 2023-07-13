package com.example.bottomnavigation.NavGraph

interface Screens {

    val route:String

}
object Home:Screens{
    override val route: String = "home"
}
object Settings:Screens{
    override val route: String = "settings"
}