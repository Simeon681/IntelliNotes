package com.example.intellinotes.service

import com.example.intellinotes.dto.request.AuthRequest
import com.example.intellinotes.dto.request.RegisterRequest
import com.example.intellinotes.dto.response.AuthResponse
import retrofit2.Response

interface AuthService {
    suspend fun register(request: RegisterRequest): Response<AuthResponse>
    suspend fun login(request: AuthRequest): Response<AuthResponse>
}