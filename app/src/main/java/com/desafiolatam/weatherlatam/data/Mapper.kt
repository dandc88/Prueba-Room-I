package com.desafiolatam.weatherlatam.data

import android.util.Log
import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import com.desafiolatam.weatherlatam.data.local.WeatherWrapper
import com.desafiolatam.weatherlatam.model.WeatherDto

// Ejemplo: esta función es una extensión de la clase Weather to, es capaz de tomar una clase DTO y transformarla en Entity
fun WeatherWrapper.toWeatherDto(): WeatherDto {
    val weatherDto = WeatherDto(
        id = 0,
        currentTemp = main.temp,
        maxTemp = main.temp_max,
        minTemp = main.temp_min,
        pressure = main.pressure.toDouble(),
        humidity = main.humidity.toDouble(),
        windSpeed = wind.speed,
        sunrise = sys.sunrise,
        sunset = sys.sunset,
        cityName = "${name}, ${sys.country}"
    )
    Log.d("Mapper", "Converted WeatherWrapper to WeatherDto: $weatherDto")
    return weatherDto
}

fun WeatherDto.toEntity(): WeatherEntity {
    val weatherEntity = WeatherEntity(
        id = id,
        currentTemp = currentTemp,
        maxTemp = maxTemp,
        minTemp = minTemp,
        pressure = pressure,
        humidity = humidity,
        windSpeed = windSpeed,
        sunrise = sunrise,
        sunset = sunset,
        cityName = cityName,
    )
    Log.d("Mapper", "Converted WeatherDto to WeatherEntity: $weatherEntity")
    return weatherEntity
}

fun entityToDto(entity: WeatherEntity): WeatherDto {
    val weatherDto = WeatherDto(
        id = entity.id,
        currentTemp = entity.currentTemp,
        maxTemp = entity.maxTemp,
        minTemp = entity.minTemp,
        pressure = entity.pressure,
        humidity = entity.humidity,
        windSpeed = entity.windSpeed,
        sunrise = entity.sunrise,
        sunset = entity.sunset,
        cityName = entity.cityName
    )
    Log.d("Mapper", "Converted WeatherEntity to WeatherDto: $weatherDto")
    return weatherDto
}

fun entityListToDtoList(list: List<WeatherEntity>): List<WeatherDto> {
    val dtoList = list.map(::entityToDto)
    Log.d("Mapper", "Converted entity list to DTO list: $dtoList")
    return dtoList
}