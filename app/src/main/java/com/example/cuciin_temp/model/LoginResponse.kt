package com.example.cuciin_temp.model

data class LoginResponse(
    val id: Int,
    val message: String,
    val success: Boolean,
    val token: String
)