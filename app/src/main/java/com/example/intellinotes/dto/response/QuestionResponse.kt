package com.example.intellinotes.dto.response

data class QuestionResponse (
    val id: Int,
    val text: String,
    val createdAt: String,
    val resolved: Boolean
)