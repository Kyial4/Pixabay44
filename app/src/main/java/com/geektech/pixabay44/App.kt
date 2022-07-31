package com.geektech.pixabay44

import android.app.Application
import com.geektech.pixabay44.network.PixabayApi
import com.geektech.pixabay44.network.RetrofitService

class App:Application( ) {

    companion object{
        lateinit var api:PixabayApi
    }


    override fun onCreate() {
        super.onCreate()
        val retrofitService=RetrofitService()
        api=retrofitService.getApi()
    }
}