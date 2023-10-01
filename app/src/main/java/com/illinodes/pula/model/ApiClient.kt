package com.illinodes.pula.model

import com.illinodes.pula.helper.GlobalConstants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
object ApiClient {
    val apiService: Api by lazy {
        RetrofitClient.retrofit.create(Api::class.java)
    }
}