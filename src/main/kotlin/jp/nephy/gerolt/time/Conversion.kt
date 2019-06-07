package jp.nephy.gerolt.time

import java.time.Instant
import kotlin.math.roundToLong

private const val TIME_RATE = 175.0
private const val MINUTES_OF_HOUR = 60
private const val HOURS_OF_DAY = 24
private const val DAYS_OF_MONTH = 32
private const val MONTHS_OF_YEAR = 12

fun EorzeaTime.Companion.from(time: Instant): EorzeaTime {
    val minutes = (time.epochSecond * MINUTES_OF_HOUR / TIME_RATE).toInt()

    val (hours, minute) = minutes.divMod(MINUTES_OF_HOUR)
    val (days, hour) = hours.divMod(HOURS_OF_DAY)
    val (months, day) = days.divMod(DAYS_OF_MONTH)
    val (year, month) = months.divMod(MONTHS_OF_YEAR)

    return EorzeaTime(year + 1, month + 1, day + 1, hour, minute)
}

val EorzeaTime.earth: Instant
    get() {
        val months = MONTHS_OF_YEAR * (year - 1) + (month - 1)
        val days = DAYS_OF_MONTH * months + (day - 1)
        val hours = HOURS_OF_DAY * days + hour
        val minutes = MINUTES_OF_HOUR * hours + minute
        val seconds = (minutes * TIME_RATE / MINUTES_OF_HOUR).roundToLong()

        return Instant.ofEpochSecond(seconds)
    }

private fun Int.divMod(other: Int): Pair<Int, Int> {
    return div(other) to rem(other)
}

fun EorzeaTime.Companion.now(): EorzeaTime {
    return from(Instant.now())
}
