package jp.nephy.gerolt.weather

import jp.nephy.gerolt.zone.EorzeaZone
import jp.nephy.gerolt.time.EorzeaTime
import jp.nephy.gerolt.time.toEarthTime
import java.time.Instant

fun EorzeaZone.forecastWeather(time: Instant): EorzeaWeather {
    return forecastWeatherByChance(calculateChance(time.epochSecond))
}

fun EorzeaZone.forecastWeather(time: EorzeaTime): EorzeaWeather {
    return forecastWeather(time.toEarthTime())
}

fun EorzeaTime.forecastWeather(zone: EorzeaZone): EorzeaWeather {
    return zone.forecastWeather(this)
}

val EorzeaZone.weather: EorzeaWeather
    get() = forecastWeather(Instant.now())
