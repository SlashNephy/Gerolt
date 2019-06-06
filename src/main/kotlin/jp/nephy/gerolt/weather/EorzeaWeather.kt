package jp.nephy.gerolt.weather

import java.util.*

enum class EorzeaWeather(private val en: String, private val ja: String) {
    Blizzards("Blizzards", "吹雪"),
    ClearSkies("Clear Skies", "快晴"),
    Clouds("Clouds", "曇り"),
    DustStorms("Dust Storms", "砂塵"),
    FairSkies("Fair Skies", "晴れ"),
    Fog("Fog", "霧"),
    Gales("Gales", "暴風"),
    Gloom("Gloom", "妖霧"),
    HeatWaves("Heat Waves", "灼熱波"),
    Rain("Rain", "雨"),
    Showers("Showers", "暴雨"),
    Snow("Snow", "雪"),
    Thunder("Thunder", "雷"),
    Thunderstorms("Thunderstorms", "雷雨"),
    UmbralStatic("Umbral Static", "放電"),
    UmbralWind("Umbral Wind", "霊風"),
    Wind("Wind", "風");

    fun toString(locale: Locale): String {
        return when (locale) {
            Locale.JAPAN, Locale.JAPANESE -> ja
            else -> en
        }
    }

    override fun toString(): String {
        return toString(Locale.getDefault())
    }
}
