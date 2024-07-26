package com.desafiolatam.weatherlatam.data

import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import kotlinx.coroutines.flow.Flow
import com.desafiolatam.weatherlatam.model.WeatherDto

interface WeatherRepository {


    suspend fun getAllWeatherData(): Flow<List<WeatherDto>?>
    suspend fun getWeatherById(id: Int): Flow<WeatherDto?>
    suspend fun insertWeather(weatherEntity: WeatherEntity)
    suspend fun clearAll()
    suspend fun updateCityName(weatherDto: WeatherDto)


}