package jp.nephy.gerolt.weather

import jp.nephy.gerolt.EorzeaZone
import java.time.Instant
import java.util.*
import kotlin.math.floor

/**
 * Returns weather with Earth Time [instant].
 *
 * @param instant Earth Time.
 */
fun EorzeaZone.weather(instant: Instant): EorzeaWeather {
    val unixTime = instant.epochSecond.toInt()

    val bell = unixTime / 175
    val increment = (bell + 8 - (bell % 8)) % 24
    val totalDays = unixTime / 4200
    val calcBase = totalDays * 0x64 + increment
    val step1 = (calcBase shl 0xB) xor calcBase
    val step2 = (step1 ushr 8) xor step1
    val chance = step2 % 0x64

    return weatherByChance(chance)
}

/**
 * Returns weather with current Eorzea Time.
 */
val EorzeaZone.weather: EorzeaWeather
    get() = weather(Instant.now())

private fun EorzeaZone.weatherByChance(chance: Int): EorzeaWeather {
    return when (this) {
        EorzeaZone.AzysLla -> when {
            chance < 35 -> EorzeaWeather.FairSkies
            chance < 70 -> EorzeaWeather.Clouds
            else -> EorzeaWeather.Thunder
        }
        EorzeaZone.CentralShroud -> when {
            chance < 5 -> EorzeaWeather.Thunder
            chance < 20 -> EorzeaWeather.Rain
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 55 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.CentralThanalan -> when {
            chance < 15 -> EorzeaWeather.DustStorms
            chance < 55 -> EorzeaWeather.ClearSkies
            chance < 75 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.Clouds
            chance < 95 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.CoerthasCentralHighlands,
        EorzeaZone.CoerthasWesternHighlands -> when {
            chance < 20 -> EorzeaWeather.Blizzards
            chance < 60 -> EorzeaWeather.Snow
            chance < 70 -> EorzeaWeather.FairSkies
            chance < 75 -> EorzeaWeather.ClearSkies
            chance < 90 -> EorzeaWeather.Clouds
            else -> EorzeaWeather.Fog
        }
        EorzeaZone.EasternLaNoscea -> when {
            chance < 5 -> EorzeaWeather.Fog
            chance < 50 -> EorzeaWeather.ClearSkies
            chance < 80 -> EorzeaWeather.FairSkies
            chance < 90 -> EorzeaWeather.Clouds
            chance < 95 -> EorzeaWeather.Rain
            else -> EorzeaWeather.Showers
        }
        EorzeaZone.EasternThanalan -> when {
            chance < 40 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 70 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.Fog
            chance < 85 -> EorzeaWeather.Rain
            else -> EorzeaWeather.Showers
        }
        EorzeaZone.EastShroud -> when {
            chance < 5 -> EorzeaWeather.Thunder
            chance < 20 -> EorzeaWeather.Rain
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 55 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.EurekaAnemos -> when {
            chance < 30 -> EorzeaWeather.FairSkies
            chance < 60 -> EorzeaWeather.Gales
            chance < 90 -> EorzeaWeather.Showers
            else -> EorzeaWeather.Snow
        }
        EorzeaZone.EurekaPagos -> when {
            chance < 10 -> EorzeaWeather.FairSkies
            chance < 28 -> EorzeaWeather.Fog
            chance < 46 -> EorzeaWeather.HeatWaves
            chance < 64 -> EorzeaWeather.Snow
            chance < 82 -> EorzeaWeather.Thunder
            else -> EorzeaWeather.Blizzards
        }
        EorzeaZone.Gridania -> when {
            chance < 20 -> EorzeaWeather.Rain
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 55 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.Idyllshire -> when {
            chance < 10 -> EorzeaWeather.Clouds
            chance < 20 -> EorzeaWeather.Fog
            chance < 30 -> EorzeaWeather.Rain
            chance < 40 -> EorzeaWeather.Showers
            chance < 70 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.Ishgard -> when {
            chance < 60 -> EorzeaWeather.Snow
            chance < 70 -> EorzeaWeather.FairSkies
            chance < 75 -> EorzeaWeather.ClearSkies
            chance < 90 -> EorzeaWeather.Clouds
            else -> EorzeaWeather.Fog
        }
        EorzeaZone.Kugane -> when {
            chance < 10 -> EorzeaWeather.Rain
            chance < 20 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.LimsaLominsa -> when {
            chance < 20 -> EorzeaWeather.Clouds
            chance < 50 -> EorzeaWeather.ClearSkies
            chance < 80 -> EorzeaWeather.FairSkies
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.LowerLaNoscea -> when {
            chance < 20 -> EorzeaWeather.Clouds
            chance < 50 -> EorzeaWeather.ClearSkies
            chance < 70 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Wind
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.MiddleLaNoscea -> when {
            chance < 20 -> EorzeaWeather.Clouds
            chance < 50 -> EorzeaWeather.ClearSkies
            chance < 70 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Clouds
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.Mist -> when {
            chance < 20 -> EorzeaWeather.Clouds
            chance < 50 -> EorzeaWeather.ClearSkies
            chance < 70 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.MorDhona -> when {
            chance < 15 -> EorzeaWeather.Clouds
            chance < 30 -> EorzeaWeather.Fog
            chance < 60 -> EorzeaWeather.Gloom
            chance < 75 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.NorthernThanalan -> when {
            chance < 5 -> EorzeaWeather.ClearSkies
            chance < 20 -> EorzeaWeather.FairSkies
            chance < 50 -> EorzeaWeather.Clouds
            else -> EorzeaWeather.Fog
        }
        EorzeaZone.NorthShroud -> when {
            chance < 5 -> EorzeaWeather.Fog
            chance < 10 -> EorzeaWeather.Showers
            chance < 25 -> EorzeaWeather.Rain
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 70 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.OuterLaNoscea -> when {
            chance < 30 -> EorzeaWeather.ClearSkies
            chance < 50 -> EorzeaWeather.FairSkies
            chance < 70 -> EorzeaWeather.Clouds
            chance < 85 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.RhalgrsReach -> when {
            chance < 15 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Clouds
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Thunder
        }
        EorzeaZone.Shirogane -> when {
            chance < 10 -> EorzeaWeather.Rain
            chance < 20 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.SouthernThanalan -> when {
            chance < 20 -> EorzeaWeather.HeatWaves
            chance < 60 -> EorzeaWeather.ClearSkies
            chance < 80 -> EorzeaWeather.FairSkies
            chance < 90 -> EorzeaWeather.Clouds
            else -> EorzeaWeather.Fog
        }
        EorzeaZone.SouthShroud -> when {
            chance < 5 -> EorzeaWeather.Fog
            chance < 10 -> EorzeaWeather.Thunderstorms
            chance < 25 -> EorzeaWeather.Thunder
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 70 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheAzimSteppe -> when {
            chance < 5 -> EorzeaWeather.Gales
            chance < 10 -> EorzeaWeather.Wind
            chance < 17 -> EorzeaWeather.Rain
            chance < 25 -> EorzeaWeather.Fog
            chance < 35 -> EorzeaWeather.Clouds
            chance < 75 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheChurningMists -> when {
            chance < 10 -> EorzeaWeather.Clouds
            chance < 20 -> EorzeaWeather.Gales
            chance < 40 -> EorzeaWeather.UmbralStatic
            chance < 70 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.TheDravanianForelands -> when {
            chance < 10 -> EorzeaWeather.Clouds
            chance < 20 -> EorzeaWeather.Fog
            chance < 30 -> EorzeaWeather.Thunder
            chance < 40 -> EorzeaWeather.DustStorms
            chance < 70 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.TheDravanianHinterlands -> when {
            chance < 10 -> EorzeaWeather.Clouds
            chance < 20 -> EorzeaWeather.Fog
            chance < 30 -> EorzeaWeather.Rain
            chance < 40 -> EorzeaWeather.Showers
            chance < 70 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.TheFringes -> when {
            chance < 15 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Clouds
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Thunder
        }
        EorzeaZone.TheGoblet -> when {
            chance < 40 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.Clouds
            chance < 95 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.TheLavenderBeds -> when {
            chance < 5 -> EorzeaWeather.Clouds
            chance < 20 -> EorzeaWeather.Rain
            chance < 30 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 55 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.ClearSkies
            else -> EorzeaWeather.FairSkies
        }
        EorzeaZone.TheLochs -> when {
            chance < 20 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Clouds
            chance < 90 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Thunderstorms
        }
        EorzeaZone.ThePeaks -> when {
            chance < 10 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 75 -> EorzeaWeather.Clouds
            chance < 85 -> EorzeaWeather.Fog
            chance < 95 -> EorzeaWeather.Wind
            else -> EorzeaWeather.DustStorms
        }
        EorzeaZone.TheRubySea -> when {
            chance < 10 -> EorzeaWeather.Thunder
            chance < 20 -> EorzeaWeather.Wind
            chance < 35 -> EorzeaWeather.Clouds
            chance < 75 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheSeaOfClouds -> when {
            chance < 30 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 70 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.Fog
            chance < 90 -> EorzeaWeather.Wind
            else -> EorzeaWeather.UmbralWind
        }
        EorzeaZone.Uldah -> when {
            chance < 40 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.Clouds
            chance < 95 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.UpperLaNoscea -> when {
            chance < 30 -> EorzeaWeather.ClearSkies
            chance < 50 -> EorzeaWeather.FairSkies
            chance < 70 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.Fog
            chance < 90 -> EorzeaWeather.Thunder
            else -> EorzeaWeather.Thunderstorms
        }
        EorzeaZone.WesternLaNoscea -> when {
            chance < 10 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 80 -> EorzeaWeather.Clouds
            chance < 90 -> EorzeaWeather.Wind
            else -> EorzeaWeather.Gales
        }
        EorzeaZone.WesternThanalan -> when {
            chance < 40 -> EorzeaWeather.ClearSkies
            chance < 60 -> EorzeaWeather.FairSkies
            chance < 85 -> EorzeaWeather.Clouds
            chance < 95 -> EorzeaWeather.Fog
            else -> EorzeaWeather.Rain
        }
        EorzeaZone.Yanxia -> when {
            chance < 5 -> EorzeaWeather.Showers
            chance < 15 -> EorzeaWeather.Rain
            chance < 25 -> EorzeaWeather.Fog
            chance < 40 -> EorzeaWeather.Clouds
            chance < 80 -> EorzeaWeather.FairSkies
            else -> EorzeaWeather.ClearSkies
        }
    }
}
