package com.desafiolatam.weatherlatam.data

import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import com.desafiolatam.weatherlatam.model.WeatherDto
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {


    suspend fun getAllWeatherData(): Flow<List<WeatherDto>?>
    suspend fun getWeatherById(id: Int): Flow<WeatherDto?>
    suspend fun clearAll()
    suspend fun upsertWeather(weatherEntity: WeatherEntity)
    suspend fun updateCityName(cityName: String, id: Int)

    suspend fun countWeatherEntries(): Int
}