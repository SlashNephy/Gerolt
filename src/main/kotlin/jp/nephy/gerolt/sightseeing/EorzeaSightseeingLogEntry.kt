package jp.nephy.gerolt.sightseeing

import jp.nephy.gerolt.zone.EorzeaZone

interface EorzeaSightseeingLogEntry {
    val number: Int
    val series: Series
    val zone: EorzeaZone
    val emote: Emote

    enum class Series {
        ARealmReborn, HEAVENSWARD, STORMBLOOD
    }

    data class Emote(val command: String, val label: String) {
        companion object {
            val LookOut = Emote("lookout", "見わたす")
            val Pray = Emote("pray", "祈る")
            val Sit = Emote("sit", "座る")
            val Salute = Emote("salute", "敬礼する")
            val Comfort = Emote("comfort", "なぐさめる")
        }
    }
}
