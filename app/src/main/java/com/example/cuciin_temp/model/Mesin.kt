package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class Mesin(
    val id: Int,
    val merk: String,
    @SerializedName("waktu-tersedia")
    val waktuTersedia: String
)