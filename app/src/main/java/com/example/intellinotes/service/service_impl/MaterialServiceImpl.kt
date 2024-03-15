package com.example.intellinotes.service.service_impl

import com.example.intellinotes.dto.response.MaterialResponse
import com.example.intellinotes.repository.MaterialRepository
import com.example.intellinotes.service.MaterialService
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File

class MaterialServiceImpl(
    private val materialRepository: MaterialRepository
) : MaterialService {
    override suspend fun getMaterials(): Response<List<MaterialResponse>> {
        return materialRepository.getMaterials()
    }

    override suspend fun getMaterial(id: String): Response<MaterialResponse> {
        return materialRepository.getMaterial(id)
    }

    override suspend fun sendVoice(file: MultipartBody.Part): Response<List<MaterialResponse>> {
        return materialRepository.sendVoice(file)
    }

    override suspend fun sendText(file: MultipartBody.Part): Response<List<MaterialResponse>> {
        return materialRepository.sendText(file)
    }
}