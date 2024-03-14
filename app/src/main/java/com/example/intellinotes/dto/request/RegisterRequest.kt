package com.example.intellinotes.dto.request

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)