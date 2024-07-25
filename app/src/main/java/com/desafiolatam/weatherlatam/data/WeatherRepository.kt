package com.desafiolatam.weatherlatam.data

import kotlinx.coroutines.flow.Flow
import com.desafiolatam.weatherlatam.model.WeatherDto

interface WeatherRepository {


    suspend fun getWeatherData(): Flow<List<WeatherDto>?>
    suspend fun getWeatherDataById(id: Int): Flow<WeatherDto?>
    suspend fun insertData(weatherDto: WeatherDto)
    suspend fun clearAll()
    suspend fun saveCityName(weatherDto: WeatherDto)

}