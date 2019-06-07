package jp.nephy.gerolt.utils

import jp.nephy.gerolt.EorzeaZone
import jp.nephy.gerolt.weather.EorzeaWeather

fun EorzeaZone.Companion.findByName(name: String): EorzeaZone? {
    return EorzeaZone.values().find { name in it.en || name in it.ja }
}

fun EorzeaWeather.Companion.findByName(name: String): EorzeaWeather? {
    return EorzeaWeather.values().find { name in it.en || name in it.ja }
}
