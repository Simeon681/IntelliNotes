package com.example.intellinotes.navigation

enum class Screen {
    MAIN,
    LOGIN,
    REGISTER,
    MATERIAL,
    PLAN,
    SUMMARY,
    QUESTIONS
}

sealed class NavigationItem(val route: String) {
    object Main : NavigationItem(Screen.MAIN.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Register : NavigationItem(Screen.REGISTER.name)
    object Material : NavigationItem(Screen.MATERIAL.name)
    object Plan : NavigationItem(Screen.PLAN.name)
    object Summary : NavigationItem(Screen.SUMMARY.name)
    object Questions : NavigationItem(Screen.QUESTIONS.name)
}