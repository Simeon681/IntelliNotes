package com.example.intellinotes.dto.response

data class MaterialResponse(
    val id: String,
    val title: String,
    val description: String,
    val createdAt: String,
    val audioUrl: String?,
    val text: String,
    val summary: String,
    val plan: String,
    val tags: List<String>,
    val questions: List<QuestionResponse>
)
