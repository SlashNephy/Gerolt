package jp.nephy.gerolt.weather

import jp.nephy.gerolt.EorzeaZone
import jp.nephy.gerolt.time.EorzeaTime
import jp.nephy.gerolt.time.earth
import java.time.Instant
import java.util.*
import kotlin.math.floor

/**
 * Returns weather with Earth Time [instant].
 *
 * @param instant Earth Time.
 */
fun EorzeaZone.weather(instant: Instant): EorzeaWeather {
    return weatherByChance(calculateChance(instant.epochSecond))
}

@ExperimentalUnsignedTypes
private fun calculateChance(epochSecond: Long): Int {
    val unixTime = epochSecond.toUInt()

    val bell = unixTime / 175U
    val increment = (bell + 8U - (bell % 8U)) % 24U
    val totalDays = unixTime / 4200U
    val calcBase = totalDays * 0x64U + increment
    val step1 = (calcBase shl 0xB) xor calcBase
    val step2 = (step1.toInt() ushr 8).toUInt() xor step1
    val chance = step2 % 0x64U

    return chance.toInt()
}

fun EorzeaZone.weather(et: EorzeaTime): EorzeaWeather {
    return weather(et.earth)
}

fun EorzeaTime.weather(at: EorzeaZone): EorzeaWeather {
    return at.weather(this)
}

/**
 * Returns weather with current Eorzea Time.
 */
val EorzeaZone.weather: EorzeaWeather
    get() = weather(Instant.now())
