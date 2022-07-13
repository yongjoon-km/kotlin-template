package com.example.demo.kotest

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class WeatherForcastServiceMockkTest : BehaviorSpec({
    val weatherService = mockk<WeatherService>()
    val weatherForcastService = WeatherForcastService(weatherService)

    given("weatherService returns cloudy") {
        every {weatherService.getCurrentWeather()} returns Weather.CLOUDY
        `when`("weatherForcaseService tries to forcase") {
            val result = weatherForcastService.getForcase()
            then("result is cloudy") {
                result shouldBe Weather.CLOUDY
            }
        }
    }
})