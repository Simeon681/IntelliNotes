package com.example.intellinotes.service.service_impl

import com.example.intellinotes.SharedPreferencesInstance
import com.example.intellinotes.dto.request.AuthRequest
import com.example.intellinotes.dto.request.RegisterRequest
import com.example.intellinotes.dto.response.AuthResponse
import com.example.intellinotes.repository.AuthRepository
import com.example.intellinotes.service.AuthService
import retrofit2.Response

class AuthServiceImpl(
    private val authRepository: AuthRepository,
    private val sharedPreferences: SharedPreferencesInstance
) : AuthService {
    override suspend fun register(request: RegisterRequest): Response<AuthResponse> {
        val response = authRepository.register(request)
        if (response.isSuccessful) {
            sharedPreferences.saveJwtToken(response.body()!!.accessToken)
        }

        return response
    }

    override suspend fun login(request: AuthRequest): Response<AuthResponse> {
        val response = authRepository.login(request)
        if (response.isSuccessful) {
            sharedPreferences.saveJwtToken(response.body()!!.accessToken)
        }

        return response
    }
}