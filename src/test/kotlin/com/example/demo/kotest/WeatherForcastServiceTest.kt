package com.example.demo.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.mockito.Mockito
import org.mockito.Mockito.mock

class WeatherForcastServiceTest : BehaviorSpec({
    val weatherService = mock(WeatherService::class.java)
    val weatherForcastService = WeatherForcastService(weatherService)

    given("current weather is cloudy from weatherService") {
        Mockito.`when`(weatherService.getCurrentWeather()).thenReturn(Weather.CLOUDY)
        `when`("weather forcast") {
            val result = weatherForcastService.getForcase()
            then("result should be cloudy") {
                result shouldBe Weather.CLOUDY
            }
        }
    }
})
