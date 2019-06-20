package jp.nephy.gerolt.time

import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalField

data class EorzeaTime(
    /**
     * The year in Eorzea Time (x >= 0).
     */
    val year: Int,

    /**
     * The month in Eorzea Time (1 <= x <= 12).
     */
    val month: Int,

    /**
     * The day of month in Eorzea Time (1 <= x <= 32).
     */
    val day: Int,

    /**
     * The hour in Eorzea Time (0 <= x <= 23).
     */
    val hour: Int,

    /**
     * The minute in Eorzea Time (0 <= x <= 59).
     * Default is 0.
     */
    val minute: Int = 0
): TemporalAccessor, Comparable<EorzeaTime> {
    companion object;

    init {
        require(year >= 0)
        require(month in 1..12)
        require(day in 1..32)
        require(hour in 0..23)
        require(minute in 0..59)
    }

    override fun isSupported(field: TemporalField): Boolean {
        return when (field) {
            ChronoField.YEAR, ChronoField.YEAR_OF_ERA,
            ChronoField.MONTH_OF_YEAR,
            ChronoField.DAY_OF_MONTH,
            ChronoField.HOUR_OF_DAY,
            ChronoField.MINUTE_OF_HOUR -> true
            else -> false
        }
    }

    override fun getLong(field: TemporalField): Long {
        return when (field) {
            ChronoField.YEAR, ChronoField.YEAR_OF_ERA -> year
            ChronoField.MONTH_OF_YEAR -> month
            ChronoField.DAY_OF_MONTH -> day
            ChronoField.HOUR_OF_DAY -> hour
            ChronoField.MINUTE_OF_HOUR -> minute
            else -> error("Unsupported field: $field")
        }.toLong()
    }

    override fun compareTo(other: EorzeaTime): Int {
        return toEarthTime().compareTo(other.toEarthTime())
    }
}
