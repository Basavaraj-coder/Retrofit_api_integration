package com.example.myapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getProduct():Call<MyData> //returning an data
}