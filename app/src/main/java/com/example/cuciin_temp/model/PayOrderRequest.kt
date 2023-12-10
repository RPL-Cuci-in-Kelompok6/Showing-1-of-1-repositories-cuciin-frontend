package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class PayOrderRequest(
    @SerializedName("id-pesanan")
    val idPesanan: Int
)