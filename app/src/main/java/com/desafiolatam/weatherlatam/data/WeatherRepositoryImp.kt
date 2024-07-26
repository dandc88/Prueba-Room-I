package com.desafiolatam.weatherlatam.data

import android.util.Log
import com.desafiolatam.weatherlatam.data.local.WeatherDao
import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import com.desafiolatam.weatherlatam.model.WeatherDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImp(
    private val weatherDao: WeatherDao
) : WeatherRepository {
    override suspend fun getAllWeatherData(): Flow<List<WeatherDto>?> =
        weatherDao.getAllWeatherData().map { entity -> entityListToDtoList(entity) }


    override suspend fun getWeatherById(id: Int): Flow<WeatherDto?> =
        weatherDao.getWeatherById(id).map { entity ->
            entity?.let { entityToDto(it) }
        }


    override suspend fun insertWeather(weatherEntity: WeatherEntity) {
        Log.d("WeatherRepositoryImp", "Inserting weather data: $weatherEntity") // Registro para depuración
        weatherDao.insertWeather(weatherEntity)
    }
    override suspend fun clearAll() = weatherDao.clearAll()

    override suspend fun updateCityName(weatherDto: WeatherDto) =
        weatherDao.updateCityName(weatherDto.toEntity())




}