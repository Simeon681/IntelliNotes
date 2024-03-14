package com.example.intellinotes.navigation

enum class Screen {
    MAIN,
    LOGIN,
    REGISTER
}

sealed class NavigationItem(val route: String) {
    object Main : NavigationItem(Screen.MAIN.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Register : NavigationItem(Screen.REGISTER.name)
}