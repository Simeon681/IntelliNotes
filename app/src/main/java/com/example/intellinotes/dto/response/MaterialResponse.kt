package com.example.intellinotes.dto.response

data class MaterialResponse(
    val id: Int,
    val title: String,
    val description: String,
    val link: String,
    val type: String,
    val createdAt: String,
    val updatedAt: String
)
