package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class Pesanan(
    val Machine: Int,
    val id: Int,
    val status: String,
    @SerializedName("sudah-bayar")
    val sudahBayar: Boolean,
    @SerializedName("total-harga")
    val totalHarga: Int
)