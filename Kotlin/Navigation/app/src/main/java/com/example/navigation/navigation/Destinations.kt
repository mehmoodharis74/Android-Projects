package com.example.navigation.navigation

interface Destinations {
    val route:String
}
object HomeScreen: Destinations {
    override val route: String = "home"
}
object DetailedScreen: Destinations {
    const val incoming="screenNo"
    const val message ="incomingMessage"
    override val route: String = "detail"
}
object FinalScreen: Destinations {
    override val route: String = "final"
}