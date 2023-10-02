package com.illinodes.pula.service

import android.util.Log
import com.illinodes.pula.model.ApiClient
import com.illinodes.pula.model.DTO.GetCurrentWeather
import com.illinodes.pula.model.DTO.GetWeatherForecast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherService(){
    companion object {
        fun getCurrentWeather(
            lon: Double,
            lat: Double,
            units: String,
            apiKey: String,
            onGetCurrentWeather: OnGetCurrentWeather) {
            ApiClient
                .apiService
                .getCurrentWeather(lon = lon, lat = lat, units = units,apiKey = apiKey)
                .enqueue(object : Callback<GetCurrentWeather> {
                    override fun onResponse(
                        call: Call<GetCurrentWeather>,
                        response: Response<GetCurrentWeather>
                    ) {
                        var body = response.body()
                        onGetCurrentWeather.onSuccess(body!!)
                    }

                    override fun onFailure(call: Call<GetCurrentWeather>, t: Throwable) {
                        onGetCurrentWeather.onFailure(t!!)
                    }

                })
        }

        fun getWeatherForecast(
            lon: Double,
            lat: Double,
            forecastDays: Int,
            units: String,
            exclude: String,
            apiKey: String,
            onGetForecastWeather: OnGetForecastWeather
        ) {
            Log.d("[FORECAST]", "$lon, $lat, $forecastDays, $exclude, $apiKey")
            ApiClient
                .apiService
                .getWeatherForecast(
                    lon = lon,
                    lat = lat,
                    cnt = forecastDays,
                    units = units,
                    exclude = exclude,
                    apiKey =  apiKey)
                .enqueue(object : Callback<GetWeatherForecast> {
                    override fun onResponse(
                        call: Call<GetWeatherForecast>,
                        response: Response<GetWeatherForecast>
                    ) {
                        var body = response.body()!!
                        Log.d("[FORECAST]", "$body")

                        onGetForecastWeather.onSuccess(body!!)
                    }

                    override fun onFailure(call: Call<GetWeatherForecast>, t: Throwable) {
                        Log.e("[FORECAST]", "$t")
                        onGetForecastWeather.onFailure(t!!)
                    }

                })
        }
    }

    interface OnGetCurrentWeather{
        fun onSuccess(response: GetCurrentWeather)
        fun onFailure(t: Throwable)
    }

    interface OnGetForecastWeather{
        fun onSuccess(response: GetWeatherForecast)
        fun onFailure(t: Throwable)
    }
}