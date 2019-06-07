package jp.nephy.gerolt.time

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
     */
    val minute: Int
) {
    companion object
}

fun EorzeaTime.format(): String {
    return "$year/$month/$day ${hour.zeroFill(2)}:${minute.zeroFill(2)}"
}

private fun Int.zeroFill(length: Int): String {
    return String.format("%0${length}d", this)
}

val EorzeaTime.nextWeatherChangeTime: EorzeaTime
    get() {
        return when {
            hour < 8 -> EorzeaTime(year, month, day, 8, 0)
            hour < 16 -> EorzeaTime(year, month, day, 16, 0)
            else -> if (day == 32) {
                if (month == 12) {
                    EorzeaTime(year + 1, 1, 1, 0, 0)
                } else {
                    EorzeaTime(year, month + 1, 1, 0, 0)
                }
            } else {
                EorzeaTime(year, month, day + 1, 0, 0)
            }
        }
    }
