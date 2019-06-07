package jp.nephy.gerolt

import jp.nephy.gerolt.i18n.Localizable
import jp.nephy.gerolt.i18n.localize
import java.util.*

enum class EorzeaZone(override val en: String, override val ja: String): Localizable {
    AzysLla("Azys Lla", "アジス・ラー"),
    CentralShroud("Central Shroud", "黒衣森：中央森林"),
    CentralThanalan("Central Thanalan", "中央ザナラーン"),
    CoerthasCentralHighlands("Coerthas Central Highlands", "クルザス中央高地"),
    CoerthasWesternHighlands("Coerthas Western Highlands", "クルザス西部高地"),
    EasternLaNoscea("Eastern La Noscea", "東ラノシア"),
    EasternThanalan("Eastern Thanalan", "東ザナラーン"),
    EastShroud("East Shroud", "黒衣森：東部森林"),
    EurekaAnemos("Eureka Anemos", "エウレカ：アネモス帯"),
    EurekaPagos("Eureka Pagos", "エウレカ：パゴス帯"),
    Gridania("Gridania", "グリダニア"),
    Idyllshire("Idyllshire", "イデルシャイア"),
    Ishgard("Ishgard", "イシュガルド"),
    Kugane("Kugane", "クガネ"),
    LimsaLominsa("Limsa Lominsa", "リムサ・ロミンサ"),
    LowerLaNoscea("Lower La Noscea", "低地ラノシア"),
    MiddleLaNoscea("Middle La Noscea", "中央ラノシア"),
    Mist("Mist", "ミスト・ヴィレッジ"),
    MorDhona("Mor Dhona", "モードゥナ"),
    NorthernThanalan("Northern Thanalan", "北ザナラーン"),
    NorthShroud("North Shroud", "黒衣森：北部森林"),
    OuterLaNoscea("Outer La Noscea", "外地ラノシア"),
    RhalgrsReach("Rhalgr's Reach", "ラールガーズリーチ"),
    Shirogane("Shirogane", "シロガネ"),
    SouthernThanalan("Southern Thanalan", "南ザナラーン"),
    SouthShroud("South Shroud", "黒衣森：南部森林"),
    TheAzimSteppe("The Azim Steppe", "アジムステップ"),
    TheChurningMists("The Churning Mists", "ドラヴァニア雲海"),
    TheDravanianForelands("The Dravanian Forelands", "高地ドラヴァニア"),
    TheDravanianHinterlands("The Dravanian Hinterlands", "低地ドラヴァニア"),
    TheFringes("The Fringes", "ギラバニア辺境地帯"),
    TheGoblet("The Goblet", "ゴブレットビュート"),
    TheLavenderBeds("The Lavender Beds", "ラベンダーベッド"),
    TheLochs("The Lochs", "ギラバニア湖畔地帯"),
    ThePeaks("The Peaks", "ギラバニア山岳地帯"),
    TheRubySea("The Ruby Sea", "紅玉海"),
    TheSeaOfClouds("The Sea of Clouds", "アバラシア雲海"),
    Uldah("Ul'dah", "ウルダハ"),
    UpperLaNoscea("Upper La Noscea", "高地ラノシア"),
    WesternLaNoscea("Western La Noscea", "西ラノシア"),
    WesternThanalan("Western Thanalan", "西ザナラーン"),
    Yanxia("Yanxia", "ヤンサ");

    companion object;

    override fun toString(): String = localize()
}
