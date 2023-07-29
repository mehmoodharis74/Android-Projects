package com.example.techhub.navigation

interface Screens {
val route: String
}

object WelcomeScreen : Screens {
    override val route="welcome_screen"
}
object LoginScreen : Screens {
    override val route="login_screen"
}
object RegisterScreen : Screens {
    override val route="register_screen"
}