package com.geektech.pixabay44.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    //https://pixabay.com/api/?key={ KEY }&q=yellow+flowers&image_type=photo

    val retrofit=Retrofit.Builder().baseUrl("https://pixabay.com").
    addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi():PixabayApi=retrofit.create(PixabayApi::class.java)
}