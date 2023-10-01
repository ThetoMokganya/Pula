package com.illinodes.pula.model

import com.illinodes.pula.model.DTO.GetCurrentWeather
import com.illinodes.pula.model.DTO.GetWeatherForecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("2.5/weather/")
    fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") apiKey: String): Call<GetCurrentWeather>

    @GET("3.0/onecall?")
    fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") cnt: Int,
        @Query("units") units: String,
        @Query("exclude") exclude: String,
        @Query("appid") apiKey: String
    ): Call<GetWeatherForecast>
}