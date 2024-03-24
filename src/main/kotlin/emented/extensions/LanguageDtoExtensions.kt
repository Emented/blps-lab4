package emented.extensions

import emented.model.Language
import emented.model.LanguageDto

fun LanguageDto.toModel(): Language {
    return when (this) {
        LanguageDto.eN -> Language.EN
        LanguageDto.rU -> Language.RU
        LanguageDto.kZ -> Language.KZ
    }
}
