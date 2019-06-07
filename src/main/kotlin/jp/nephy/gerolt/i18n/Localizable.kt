package jp.nephy.gerolt.i18n

import java.util.*

interface Localizable {
    val en: String

    val ja: String
}

fun Localizable.localize(locale: Locale = Locale.getDefault()): String {
    return when (locale) {
        Locale.JAPAN, Locale.JAPANESE -> ja
        else -> en
    }
}
