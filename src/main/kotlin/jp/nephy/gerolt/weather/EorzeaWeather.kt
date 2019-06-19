package jp.nephy.gerolt.weather

enum class EorzeaWeather(val label: String) {
    Blizzards("吹雪"),
    ClearSkies("快晴"),
    Clouds("曇り"),
    DustStorms( "砂塵"),
    FairSkies("晴れ"),
    Fog("霧"),
    Gales("暴風"),
    Gloom("妖霧"),
    HeatWaves("灼熱波"),
    Rain("雨"),
    Showers("暴雨"),
    Snow("雪"),
    Thunder("雷"),
    Thunderstorms("雷雨"),
    UmbralStatic("放電"),
    UmbralWind("霊風"),
    Wind("風");

    companion object;

    override fun toString(): String = label
}
