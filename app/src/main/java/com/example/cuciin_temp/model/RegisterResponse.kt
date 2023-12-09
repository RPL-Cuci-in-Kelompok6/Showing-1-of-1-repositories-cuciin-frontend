package com.example.cuciin_temp.model

data class RegisterResponse(
    val duplicate: Boolean,
    val message: String,
    val success: Boolean
)