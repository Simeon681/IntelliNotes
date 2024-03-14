package com.example.intellinotes.repository

import com.example.intellinotes.dto.request.AuthRequest
import com.example.intellinotes.dto.request.RegisterRequest
import com.example.intellinotes.dto.response.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRepository {
    @POST("/mobile-backend-api/v1/auth/signup")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("/mobile-backend-api/v1/auth/signin")
    suspend fun login(@Body request: AuthRequest): Response<AuthResponse>
}