package emented.model

import emented.model.domain.ModerationResult

data class ModerationInfo(
    val moderationResult: ModerationResult,
    val moderationMessage: String,
)