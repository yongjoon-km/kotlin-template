package com.example.demo.kotest

import org.springframework.stereotype.Service

@Service
class WeatherForcastService(
    private val weatherService: WeatherService
) {

    fun getForcase(): Weather {
        return weatherService.getCurrentWeather()
    }
}
