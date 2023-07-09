package com.example.navigation.navigation

interface Destinations {
    val route:String
}
object HomeScreen: Destinations {
    override val route: String = "home"
}
object DetailedScreen: Destinations {
    override val route: String = "detail"
}
object FinalScreen: Destinations {
    override val route: String = "final"
}