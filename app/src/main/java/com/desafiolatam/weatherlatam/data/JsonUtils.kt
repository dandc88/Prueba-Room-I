package com.desafiolatam.weatherlatam.data

import android.content.Context
import android.util.Log
import com.desafiolatam.weatherlatam.data.local.WeatherWrapper
import com.google.gson.Gson
import java.io.InputStreamReader

object JsonUtils {
    fun readWeatherWrapperFromAssets(context: Context): WeatherWrapper? {
        return try {
            val inputStream = context.assets.open("data.json")
            val reader = InputStreamReader(inputStream)
            val weatherWrapper = Gson().fromJson(reader, WeatherWrapper::class.java)
            Log.d("JsonUtils", "Read WeatherWrapper from assets: $weatherWrapper")
            weatherWrapper
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("JsonUtils", "Error reading WeatherWrapper from assets", e)
            null
        }
    }
}