package com.desafiolatam.weatherlatam.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {

    // Ejemplo
    @Query("DELETE FROM weather")
    suspend fun clearAll()

    // Consulta para obtener todos los datos del clima
    @Query("SELECT * FROM weather")
    fun getAllWeatherData(): Flow<List<WeatherEntity>>

    // Consulta para obtener los datos del clima por ID
    @Query("SELECT * FROM weather WHERE id = :id")
    fun getWeatherById(id: Int): Flow<WeatherEntity?>


    @Upsert
    suspend fun upsertWeather(weather: WeatherEntity)

    @Query("UPDATE weather SET cityName = :cityName WHERE id = :id")
    suspend fun updateCityName(cityName: String, id: Int)

    @Query("SELECT COUNT(*) FROM weather")
    suspend fun countWeatherEntries(): Int


}