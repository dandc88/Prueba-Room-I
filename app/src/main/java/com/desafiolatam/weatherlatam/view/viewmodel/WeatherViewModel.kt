package com.desafiolatam.weatherlatam.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiolatam.weatherlatam.data.WeatherRepositoryImp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepositoryImp) : ViewModel() {

     private val _cityName = MutableStateFlow("")
     val cityName: StateFlow<String> = _cityName

     suspend fun getWeather() = repository.getAllWeatherData().stateIn(viewModelScope)

     suspend fun getWeatherById(id: Int) = repository.getWeatherById(id).stateIn(viewModelScope)

     fun updateCityName(newCityName: String, id: Int) {
          viewModelScope.launch {
               _cityName.value = newCityName
               repository.updateCityName(newCityName, id)
          }
     }




}

