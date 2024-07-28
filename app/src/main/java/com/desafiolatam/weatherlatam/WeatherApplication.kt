package com.desafiolatam.weatherlatam

import android.app.Application
import android.util.Log
import com.desafiolatam.weatherlatam.data.JsonUtils
import com.desafiolatam.weatherlatam.data.WeatherRepositoryImp
import com.desafiolatam.weatherlatam.data.local.WeatherDatabase
import com.desafiolatam.weatherlatam.data.toEntity
import com.desafiolatam.weatherlatam.data.toWeatherDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

import kotlinx.coroutines.launch


class WeatherApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { WeatherDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WeatherRepositoryImp(database.weatherDao()) }

    override fun onCreate() {
        super.onCreate()
        // Poblar la base de datos al iniciar la aplicación
        applicationScope.launch {
            Log.d("WeatherApp", "Se llama a populateDatabase()")
            populateDatabase()
        }
    }

    private suspend fun populateDatabase() {
        val weatherWrapper = JsonUtils.readWeatherWrapperFromAssets(this)
        weatherWrapper?.let {
            val weatherDto = it.toWeatherDto()  // Convertir a WeatherDto
            Log.d("populateDatabase", "Converted to WeatherDto: $weatherDto")

            val weatherEntities = listOf(weatherDto).map { dto -> dto.toEntity() }
            Log.d("populateDatabase", "Converted to WeatherEntities: $weatherEntities")

            weatherEntities.forEach { entity ->
                Log.d("populateDatabase", "Inserting WeatherEntity: $entity")
                repository.upsertWeather(entity)
            }
        } ?: Log.e("populateDatabase", "WeatherWrapper is null")
    }
}