package jp.nephy.gerolt.time

import java.time.Instant
import kotlin.math.roundToInt
import kotlin.math.roundToLong

private const val TIME_RATE = 175.0
private const val MINUTES_OF_HOUR = 60
private const val HOURS_OF_DAY = 24
private const val DAYS_OF_MONTH = 32
private const val MONTHS_OF_YEAR = 12

fun EorzeaTime.Companion.from(epochSecond: Long): EorzeaTime {
    val minutes = (epochSecond * MINUTES_OF_HOUR / TIME_RATE).roundToInt()

    val hours = minutes / MINUTES_OF_HOUR
    val minute = minutes % MINUTES_OF_HOUR

    val days = hours / HOURS_OF_DAY
    val hour = hours % HOURS_OF_DAY

    val months = days / DAYS_OF_MONTH
    val day = days % DAYS_OF_MONTH + 1

    val year = months / MONTHS_OF_YEAR + 1
    val month = months % MONTHS_OF_YEAR + 1

    return EorzeaTime(year, month, day, hour, minute)
}

fun EorzeaTime.Companion.from(time: Instant): EorzeaTime {
    return from(time.epochSecond)
}

fun Instant.toEorzeaTime(): EorzeaTime {
    return EorzeaTime.from(this)
}

fun EorzeaTime.Companion.now(): EorzeaTime {
    return from(Instant.now())
}

fun EorzeaTime.toEarthTime(): Instant {
    return EarthTime(year, month, day, hour, minute)
}

@Suppress("FunctionName")
internal fun EarthTime(year: Int, month: Int, day: Int, hour: Int, minute: Int): Instant {
    val months = MONTHS_OF_YEAR * (year - 1) + (month - 1)
    val days = DAYS_OF_MONTH * months + (day - 1)
    val hours = HOURS_OF_DAY * days + hour
    val minutes = MINUTES_OF_HOUR * hours + minute
    val seconds = (minutes * TIME_RATE / MINUTES_OF_HOUR).roundToLong()

    return Instant.ofEpochSecond(seconds)
}
