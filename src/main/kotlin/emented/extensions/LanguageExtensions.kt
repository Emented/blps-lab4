package emented.extensions

import emented.model.Language
import emented.model.LanguageDto

fun Language.toResponse(): LanguageDto {
    return when (this) {
        Language.RU -> LanguageDto.rU
        Language.EN -> LanguageDto.eN
        Language.KZ -> LanguageDto.kZ
    }
}
