package com.example.intellinotes.state

sealed class MainState {
    object Loading : MainState()
    object Success : MainState()
    class Error(val message: String) : MainState()
    object Empty : MainState()
}