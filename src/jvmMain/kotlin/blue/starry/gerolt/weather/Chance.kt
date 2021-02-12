package blue.starry.gerolt.weather

import blue.starry.gerolt.zone.EorzeaZone

@ExperimentalUnsignedTypes
internal fun calculateChance(epochSecond: Long): Int {
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

internal fun EorzeaZone.forecastWeatherByChance(chance: Int): EorzeaWeather {
    return when (this) {
        EorzeaZone.AzysLla -> when {
            chance < 35 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            else -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
        }
        EorzeaZone.CentralShroud -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 55 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.CentralThanalan -> when {
            chance < 15 -> blue.starry.gerolt.weather.EorzeaWeather.DustStorms
            chance < 55 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.CoerthasCentralHighlands,
        EorzeaZone.CoerthasWesternHighlands -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Blizzards
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.Snow
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            else -> blue.starry.gerolt.weather.EorzeaWeather.Fog
        }
        EorzeaZone.EasternLaNoscea -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            else -> blue.starry.gerolt.weather.EorzeaWeather.Showers
        }
        EorzeaZone.EasternThanalan -> when {
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            else -> blue.starry.gerolt.weather.EorzeaWeather.Showers
        }
        EorzeaZone.EastShroud -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 55 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.EurekaAnemos -> when {
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.Gales
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Showers
            else -> blue.starry.gerolt.weather.EorzeaWeather.Snow
        }
        EorzeaZone.EurekaPagos -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 28 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 46 -> blue.starry.gerolt.weather.EorzeaWeather.HeatWaves
            chance < 64 -> blue.starry.gerolt.weather.EorzeaWeather.Snow
            chance < 82 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            else -> blue.starry.gerolt.weather.EorzeaWeather.Blizzards
        }
        EorzeaZone.Gridania -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 55 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.Idyllshire -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Showers
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.Ishgard -> when {
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.Snow
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            else -> blue.starry.gerolt.weather.EorzeaWeather.Fog
        }
        EorzeaZone.Kugane -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.LimsaLominsa -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.LowerLaNoscea -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.MiddleLaNoscea -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.Mist -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.MorDhona -> when {
            chance < 15 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.Gloom
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.NorthernThanalan -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            else -> blue.starry.gerolt.weather.EorzeaWeather.Fog
        }
        EorzeaZone.NorthShroud -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Showers
            chance < 25 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.OuterLaNoscea -> when {
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.RhalgrsReach -> when {
            chance < 15 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
        }
        EorzeaZone.Shirogane -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.SouthernThanalan -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.HeatWaves
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            else -> blue.starry.gerolt.weather.EorzeaWeather.Fog
        }
        EorzeaZone.SouthShroud -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Thunderstorms
            chance < 25 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheAzimSteppe -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Gales
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            chance < 17 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 25 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 35 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheChurningMists -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Gales
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.UmbralStatic
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.TheDravanianForelands -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.DustStorms
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.TheDravanianHinterlands -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Showers
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.TheFringes -> when {
            chance < 15 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
        }
        EorzeaZone.TheGoblet -> when {
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.TheLavenderBeds -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 55 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
        }
        EorzeaZone.TheLochs -> when {
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Thunderstorms
        }
        EorzeaZone.ThePeaks -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            else -> blue.starry.gerolt.weather.EorzeaWeather.DustStorms
        }
        EorzeaZone.TheRubySea -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            chance < 20 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            chance < 35 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 75 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
        EorzeaZone.TheSeaOfClouds -> when {
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            else -> blue.starry.gerolt.weather.EorzeaWeather.UmbralWind
        }
        EorzeaZone.Uldah -> when {
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.UpperLaNoscea -> when {
            chance < 30 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 50 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 70 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Thunder
            else -> blue.starry.gerolt.weather.EorzeaWeather.Thunderstorms
        }
        EorzeaZone.WesternLaNoscea -> when {
            chance < 10 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 90 -> blue.starry.gerolt.weather.EorzeaWeather.Wind
            else -> blue.starry.gerolt.weather.EorzeaWeather.Gales
        }
        EorzeaZone.WesternThanalan -> when {
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
            chance < 60 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            chance < 85 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 95 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            else -> blue.starry.gerolt.weather.EorzeaWeather.Rain
        }
        EorzeaZone.Yanxia -> when {
            chance < 5 -> blue.starry.gerolt.weather.EorzeaWeather.Showers
            chance < 15 -> blue.starry.gerolt.weather.EorzeaWeather.Rain
            chance < 25 -> blue.starry.gerolt.weather.EorzeaWeather.Fog
            chance < 40 -> blue.starry.gerolt.weather.EorzeaWeather.Clouds
            chance < 80 -> blue.starry.gerolt.weather.EorzeaWeather.FairSkies
            else -> blue.starry.gerolt.weather.EorzeaWeather.ClearSkies
        }
    }
}
