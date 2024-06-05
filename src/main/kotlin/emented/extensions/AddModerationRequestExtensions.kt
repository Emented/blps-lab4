package emented.extensions

import emented.model.AddModerationRequest
import emented.model.ModerationInfo
import emented.model.domain.ModerationResult
import emented.model.ModerationResult as ApiModerationResult

fun AddModerationRequest.toModel(): ModerationInfo {
    return ModerationInfo(
        moderationResult = this.moderationResult.toModel(),
        moderationMessage = this.moderationMessage
    )
}

fun ApiModerationResult.toModel(): ModerationResult {
    return when (this) {
        ApiModerationResult.pENDING -> ModerationResult.PENDING
        ApiModerationResult.pASSED -> ModerationResult.PASSED
        ApiModerationResult.fAILED -> ModerationResult.FAILED
    }
}