package com.desafiolatam.weatherlatam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    // Inserta un nuevo registro de clima
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)


    // Actualiza el nombre de la ciudad
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateCityName(weatherEntity: WeatherEntity)


}