package com.desafiolatam.weatherlatam.data

import com.desafiolatam.weatherlatam.data.local.WeatherDao
import com.desafiolatam.weatherlatam.model.WeatherDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImp(
    private val weatherDao: WeatherDao
) : WeatherRepository {
    override suspend fun getWeatherData(): Flow<List<WeatherDto>?> {
        TODO("Not yet implemented")
    }

    override suspend fun getWeatherDataById(id: Int): Flow<WeatherDto?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertData(weatherDto: WeatherDto) {
        TODO("Not yet implemented")
    }


    override suspend fun clearAll() = weatherDao.clearAll()
    override suspend fun saveCityName(weatherDto: WeatherDto) {
        TODO("Not yet implemented")
    }

}