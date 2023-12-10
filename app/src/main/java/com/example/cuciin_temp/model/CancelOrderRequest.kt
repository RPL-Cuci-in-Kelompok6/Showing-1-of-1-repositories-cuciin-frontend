package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class CancelOrderRequest(
    @SerializedName("id-pesanan")
    val idPesanan: Int
)