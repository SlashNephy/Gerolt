import blue.starry.gerolt.sightseeing.ARealmRebornSightseeingLogEntry
import blue.starry.gerolt.sightseeing.entries
import blue.starry.gerolt.time.EorzeaTime
import blue.starry.gerolt.time.now
import blue.starry.gerolt.time.toEarthTime
import blue.starry.gerolt.weather.EorzeaWeather
import blue.starry.gerolt.weather.forecastWeather
import blue.starry.gerolt.weather.nextWeatherPeriod
import blue.starry.gerolt.zone.EorzeaZone
import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    val dateTimeFormat = DateTimeFormatter.ofPattern("MM/dd HH:mm")
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    val timeZone = ZoneId.of("Asia/Tokyo")
    val time = EorzeaTime.now()
    val localTime = LocalDateTime.now()

    println("Current ET = ${dateTimeFormat.format(time)}, LT = ${dateTimeFormat.format(localTime)} (${timeZone.id})")

    ARealmRebornSightseeingLogEntry.entries.map {
        it to it.calculateNextTimeRange(time)
    }.sortedBy {
        it.second.first
    }.forEach {
        val requiredTimeRangeString = "${dateTimeFormat.format(it.second.first)} 〜 ${timeFormat.format(it.second.second)}"

        val duration = Duration.between(Instant.now(), it.second.first.toEarthTime())
        val durationString = buildString {
            val hour = duration.seconds / 3600
            val minutes = duration.seconds % 3600

            val minute = minutes / 60
            val second = minute % 60

            append(String.format("%02d", hour))
            append(':')

            append(String.format("%02d", minute))
            append(':')

            append(String.format("%02d", second))
        }

        println("#${String.format("%03d", it.first.number)}: $requiredTimeRangeString (LT: ${dateTimeFormat.format(it.second.first.toEarthTime().atZone(timeZone))}, $durationString)")
    }
}

fun EorzeaWeather.calculateNextTime(zone: EorzeaZone, start: EorzeaTime = blue.starry.gerolt.time.EorzeaTime.now()): EorzeaTime {
    var time = start.nextWeatherPeriod
    while (true) {
        val weather = time.forecastWeather(zone)
        if (weather == this) {
            return time
        }

        time = time.nextWeatherPeriod
    }
}

fun ARealmRebornSightseeingLogEntry.calculateNextTimeRange(start: EorzeaTime = EorzeaTime.now()): Pair<EorzeaTime, EorzeaTime> {
    val (requiredStartHour, requiredEndHour) = hours
    val requiredHourRange = if (requiredStartHour < requiredEndHour) {
        requiredStartHour until requiredEndHour
    } else {
        (requiredStartHour until 24) + (0 until requiredEndHour)
    }

    var time = weather.calculateNextTime(zone, start)
    while (true) {
        val (hour, nextWeatherPeriodHour) = time.hour to time.nextWeatherPeriod.hour
        val weatherPeriodRange = if (hour < nextWeatherPeriodHour) {
            hour until nextWeatherPeriodHour
        } else {
            (hour until 24) + (0 until nextWeatherPeriodHour)
        }

        val intersect = requiredHourRange.intersect(weatherPeriodRange)
        if (intersect.isNotEmpty()) {
            return time.copy(hour = intersect.first(), minute = 0) to time.copy(hour = intersect.last(), minute = 59)
        }

        time = weather.calculateNextTime(zone, time)
    }
}

fun ARealmRebornSightseeingLogEntry.calculateMatchedTimeRanges(start: EorzeaTime = EorzeaTime.now()): Sequence<Pair<EorzeaTime, EorzeaTime>> {
    return sequence {
        var time = calculateNextTimeRange(start)

        while (true) {
            yield(time)

            time = calculateNextTimeRange(time.second)
        }
    }
}
