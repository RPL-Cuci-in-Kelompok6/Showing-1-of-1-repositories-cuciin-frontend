package com.example.cuciin_temp.network

import com.example.cuciin_temp.model.CreateOrderRequest
import com.example.cuciin_temp.model.CreateOrderResponse
import com.example.cuciin_temp.model.DataModel
import com.example.cuciin_temp.model.GetOrderRequest
import com.example.cuciin_temp.model.GetOrderResponse
import com.example.cuciin_temp.model.LoginRequest
import com.example.cuciin_temp.model.LoginResponse
import com.example.cuciin_temp.model.PayOrderRequest
import com.example.cuciin_temp.model.PayOrderResponse
import com.example.cuciin_temp.model.RegisterResponse
import com.example.cuciin_temp.model.ServicesRequest
import com.example.cuciin_temp.model.ServicesResponses
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("customer/register")
    fun postData(@Body dataModel: DataModel?): Call<RegisterResponse?>?

    @POST("customer/mitra/services")
    fun getServices(@Body servicesRequest: ServicesRequest?): Call<ServicesResponses?>?

    @POST("customer/login")
    fun loginCustomer(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?

    @POST("customer/order/create")
    fun createOrder(@Body createOrderRequest: CreateOrderRequest?): Call<CreateOrderResponse?>?

    @POST("customer/order")
    fun getOrder(@Body getOrderRequest: GetOrderRequest?): Call<GetOrderResponse?>?

    @POST("customer/order/pay")
    fun payOrder(@Body payOrderRequest: PayOrderRequest?): Call<PayOrderResponse?>?
}