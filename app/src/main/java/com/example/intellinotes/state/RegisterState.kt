package com.example.intellinotes.state

sealed class RegisterState {
    object Loading : RegisterState()
    object Success : RegisterState()
    class Error(val message: String) : RegisterState()
    object Empty : RegisterState()
}