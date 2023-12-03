package com.example.cuciin_temp.network

import com.example.cuciin_temp.model.DataModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("/customer/register")
    fun  // on below line we are creating a method to post our data.
            postData(@Body dataModel: DataModel?): Call<DataModel?>?
}