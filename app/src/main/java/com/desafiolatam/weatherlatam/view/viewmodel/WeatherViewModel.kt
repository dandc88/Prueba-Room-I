package com.desafiolatam.weatherlatam.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiolatam.weatherlatam.data.WeatherRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepositoryImp) : ViewModel() {



     suspend fun getWeather() = repository.getAllWeatherData().stateIn(viewModelScope)

     suspend fun getWeatherById(id: Int) = repository.getWeatherById(id).stateIn(viewModelScope)

     suspend fun saveCityName(cityName: String){
          viewModelScope.launch(Dispatchers.IO){
               //repository.updateCityName(cityName)
          }
     }




}

