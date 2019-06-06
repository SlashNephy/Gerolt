package jp.nephy.gerolt.time

import jp.nephy.gerolt.EorzeaZone
import jp.nephy.gerolt.weather.weather
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalField

class EorzeaTime(private val real: Instant) {
    companion object {
        private const val TIME_RATE = 175.0
        private const val MINUTES_OF_HOUR = 60
        private const val HOURS_OF_DAY = 24
        private const val DAYS_OF_MONTH = 32
        private const val MONTHS_OF_YEAR = 12

        fun now(): EorzeaTime {
            return EorzeaTime(Instant.now())
        }
    }

    private val seconds: Int
        get() = (real.epochSecond * MINUTES_OF_HOUR / TIME_RATE).toInt()

    /**
     * The year in Eorzea Time (x >= 0).
     */
    val year: Int
        get() = months / MONTHS_OF_YEAR + 1

    /**
     * The month in Eorzea Time (1 <= x <= 12).
     */
    val month: Int
        get() = months % MONTHS_OF_YEAR + 1

    private val months: Int
        get() = days / DAYS_OF_MONTH

    /**
     * The date in Eorzea Time (1 <= x <= 32).
     */
    val date: Int
        get() = days % DAYS_OF_MONTH + 1

    private val days: Int
        get() = hours / HOURS_OF_DAY

    /**
     * The hour in Eorzea Time (0 <= x <= 23).
     */
    val hour: Int
        get() = hours % HOURS_OF_DAY

    private val hours: Int
        get() = seconds / MINUTES_OF_HOUR

    /**
     * The minute in Eorzea Time (0 <= x <= 59).
     */
    val minute: Int
        get() = seconds % MINUTES_OF_HOUR

    override fun toString(): String {
        return "$year/$month/$date ${hour.zfill(2)}:${minute.zfill(2)}"
    }

    private fun Int.zfill(length: Int): String {
        return String.format("%0${length}d", this)
    }
}

fun main() {
    val et = EorzeaTime.now()
    println(et)

    println(EorzeaZone.AzysLla.weather)
}
