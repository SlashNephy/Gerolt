package jp.nephy.gerolt.sightseeing

import jp.nephy.gerolt.weather.EorzeaWeather
import jp.nephy.gerolt.zone.EorzeaZone

private typealias Entry = ARealmRebornSightseeingLogEntry
private typealias Emote = EorzeaSightseeingLogEntry.Emote

data class ARealmRebornSightseeingLogEntry(
    override val number: Int,
    override val zone: EorzeaZone,
    override val emote: Emote,
    val weather: EorzeaWeather,
    val hours: Pair<Int, Int>
): EorzeaSightseeingLogEntry {
    override val series = EorzeaSightseeingLogEntry.Series.ARealmReborn

    companion object {
        val A001 = Entry(1, EorzeaZone.LimsaLominsa, Emote.LookOut, EorzeaWeather.FairSkies, 8 to 12)
        val A002 = Entry(2, EorzeaZone.LimsaLominsa, Emote.LookOut, EorzeaWeather.ClearSkies, 18 to 5)
        val A003 = Entry(3, EorzeaZone.MiddleLaNoscea, Emote.Pray, EorzeaWeather.Rain, 5 to 8)
        val A004 = Entry(4, EorzeaZone.MiddleLaNoscea, Emote.LookOut, EorzeaWeather.FairSkies, 12 to 17)
        val A005 = Entry(5, EorzeaZone.MiddleLaNoscea, Emote.LookOut, EorzeaWeather.Clouds, 8 to 12)
        val A006 = Entry(6, EorzeaZone.LowerLaNoscea, Emote.LookOut, EorzeaWeather.FairSkies, 18 to 5)
        val A007 = Entry(7, EorzeaZone.LowerLaNoscea, Emote.LookOut, EorzeaWeather.Fog, 5 to 8)
        val A008 = Entry(8, EorzeaZone.WesternLaNoscea, Emote.LookOut, EorzeaWeather.FairSkies, 5 to 8)
        val A009 = Entry(9, EorzeaZone.Gridania, Emote.LookOut, EorzeaWeather.Clouds, 12 to 18)
        val A010 = Entry(10, EorzeaZone.Gridania, Emote.LookOut, EorzeaWeather.ClearSkies, 18 to 5)
        val A011 = Entry(11, EorzeaZone.CentralShroud, Emote.Sit, EorzeaWeather.FairSkies, 12 to 17)
        val A012 = Entry(12, EorzeaZone.EastShroud, Emote.Pray, EorzeaWeather.FairSkies, 8 to 12)
        val A013 = Entry(13, EorzeaZone.EastShroud, Emote.LookOut, EorzeaWeather.ClearSkies, 18 to 5)
        val A014 = Entry(14, EorzeaZone.Uldah, Emote.Salute, EorzeaWeather.FairSkies, 5 to 8)
        val A015 = Entry(15, EorzeaZone.Uldah, Emote.LookOut, EorzeaWeather.Clouds, 12 to 17)
        val A016 = Entry(16, EorzeaZone.WesternThanalan, Emote.LookOut, EorzeaWeather.FairSkies, 18 to 5)
        val A017 = Entry(17, EorzeaZone.CentralThanalan, Emote.LookOut, EorzeaWeather.Fog, 8 to 12)
        val A018 = Entry(18, EorzeaZone.EasternThanalan, Emote.Comfort, EorzeaWeather.Rain, 17 to 18)
        val A019 = Entry(19, EorzeaZone.EasternThanalan, Emote.LookOut, EorzeaWeather.Clouds, 8 to 12)
        val A020 = Entry(20, EorzeaZone.EasternThanalan, Emote.Pray, EorzeaWeather.FairSkies, 5 to 8)
    }
}

val ARealmRebornSightseeingLogEntry.Companion.entries: List<ARealmRebornSightseeingLogEntry>
    get() = listOf(
        A001, A002, A003, A004, A005,
        A006, A007, A008, A009, A010,
        A011, A012, A013, A014, A015,
        A016, A017, A018, A019, A020
    )
