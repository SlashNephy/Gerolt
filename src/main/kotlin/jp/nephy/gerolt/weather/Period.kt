package jp.nephy.gerolt.weather

import jp.nephy.gerolt.time.EorzeaTime

val EorzeaTime.nextWeatherPeriod: EorzeaTime
    get() {
        return when {
            hour < 8 -> {
                EorzeaTime(year, month, day, 8, 0)
            }
            hour < 16 -> {
                EorzeaTime(year, month, day, 16, 0)
            }
            month == 12 && day == 32 -> {
                EorzeaTime(year + 1, 1, 1, 0, 0)
            }
            day == 32 -> {
                EorzeaTime(year, month + 1, 1, 0, 0)
            }
            else -> {
                EorzeaTime(year, month, day + 1, 0, 0)
            }
        }
    }
