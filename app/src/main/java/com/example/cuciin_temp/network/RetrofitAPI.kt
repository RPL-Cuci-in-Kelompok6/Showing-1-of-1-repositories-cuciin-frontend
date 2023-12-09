package com.example.cuciin_temp.network

import com.example.cuciin_temp.model.DataModel
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.model.RegisterResponse
import com.example.cuciin_temp.model.Services
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("customer/register")
    fun postData(@Body dataModel: DataModel?): Call<RegisterResponse?>?

    @POST("customer/mitra/services")
    @FormUrlEncoded
    fun getServices(
        @Field("id-mitra")
        idMitra: Int
    ): Call<Services>

    @POST("customer/login")
    fun loginCustomer(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?
}