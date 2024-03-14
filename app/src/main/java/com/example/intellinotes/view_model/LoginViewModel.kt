package com.example.intellinotes.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intellinotes.dto.request.AuthRequest
import com.example.intellinotes.service.AuthService
import com.example.intellinotes.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authService: AuthService
) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Empty)
    val loginState: StateFlow<LoginState> = _loginState

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            val response = authService.login(
                AuthRequest(
                    email,
                    password

                )
            )
            if (response.isSuccessful) {
                _loginState.value = LoginState.Success
            } else {
                _loginState.value = LoginState.Error(response.message())
            }
        }
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }
}