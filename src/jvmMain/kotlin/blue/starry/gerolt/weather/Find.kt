package blue.starry.gerolt.weather

fun EorzeaWeather.Companion.find(name: String): EorzeaWeather? {
    return EorzeaWeather.values().find { name in it.label }
}
