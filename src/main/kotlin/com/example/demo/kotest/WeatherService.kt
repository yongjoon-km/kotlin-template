package com.example.demo.kotest

import org.springframework.stereotype.Service

@Service
class WeatherService {

    fun getCurrentWeather(): Weather {
        return Weather.SUNNY
    }
}

enum class Weather {
    RAIN, SUNNY, WINDY, CLOUDY
}
