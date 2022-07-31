package com.geektech.pixabay44.network

import android.telecom.Call
import com.geektech.pixabay44.model.PixabayModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("api/")
    fun getImagesByWorld(@Query( "key")key:String="28283066-0ec69652eb612ae95db3e1a9a",
                         @Query("q")keyWord:String,
                         @Query("page")page:Int,
                         @Query("per_page")per_page:Int=10

    ):retrofit2.Call<PixabayModel>

}