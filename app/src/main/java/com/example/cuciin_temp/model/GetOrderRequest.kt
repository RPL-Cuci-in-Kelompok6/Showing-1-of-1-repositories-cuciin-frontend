package com.example.cuciin_temp.model

import com.google.gson.annotations.SerializedName

data class GetOrderRequest(
    @SerializedName("id-customer")
    val idCustomer: Int
)