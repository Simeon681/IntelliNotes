package com.example.intellinotes.dto.response

data class AuthResponse (
    var id: String,
    var accessToken: String,
    var refreshToken: String,
    val email: String,
    val materials: List<MaterialResponse>
)