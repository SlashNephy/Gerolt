package jp.nephy.gerolt.weather

fun EorzeaWeather.Companion.find(name: String): EorzeaWeather? {
    return EorzeaWeather.values().find { name in it.label }
}
