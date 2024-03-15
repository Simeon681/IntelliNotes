package com.example.intellinotes.service

import com.example.intellinotes.dto.response.MaterialResponse
import okhttp3.MultipartBody
import retrofit2.Response

interface MaterialService {
    suspend fun getMaterials(): Response<List<MaterialResponse>>
    suspend fun getMaterial(id: String): Response<MaterialResponse>
    suspend fun sendVoice(file: MultipartBody.Part): Response<List<MaterialResponse>>
    suspend fun sendText(file: MultipartBody.Part): Response<List<MaterialResponse>>
}