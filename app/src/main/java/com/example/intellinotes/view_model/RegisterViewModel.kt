package com.example.intellinotes.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intellinotes.dto.request.RegisterRequest
import com.example.intellinotes.service.AuthService
import com.example.intellinotes.state.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authService: AuthService
) : ViewModel() {
    private val _registerState = MutableStateFlow<RegisterState>(RegisterState.Empty)
    val registerState: StateFlow<RegisterState> = _registerState

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun register(
        username: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _registerState.value = RegisterState.Loading
            val response = authService.register(
                RegisterRequest(
                    username,
                    email,
                    password

                )
            )
            if (response.isSuccessful) {
                _registerState.value = RegisterState.Success
            } else {
                _registerState.value = RegisterState.Error(response.message())
            }
        }
    }

    fun setUsername(username: String) {
        _username.value = username
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }
}