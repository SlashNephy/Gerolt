package jp.nephy.gerolt.weather

import jp.nephy.gerolt.i18n.Localizable
import jp.nephy.gerolt.i18n.localize
import java.util.*

enum class EorzeaWeather(override val en: String, override val ja: String): Localizable {
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

    companion object;

    override fun toString(): String = localize()
}
