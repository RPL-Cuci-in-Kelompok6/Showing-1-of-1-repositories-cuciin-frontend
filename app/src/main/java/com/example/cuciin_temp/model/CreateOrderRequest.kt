package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class CreateOrderRequest(
    val email: String,
    val harga: Int,
    @SerializedName("id-customer")
    val idCustomer: Int,
    @SerializedName("id-mesin")
    val idMesin: Int
)