package emented.model.domain

import emented.model.Language
import java.time.OffsetDateTime

data class Community(
    val id: Long?,
    val userId: Long?,
    val name: String,
    val address: String,
    val language: Language,
    val description: String,
    val isForChildren: Boolean,
    val isBlocked: Boolean,
    val interestRate: Long,
    val category: Category,
    val moderationResult: ModerationResult,
    val moderationMessage: String?,
    val createdTs: OffsetDateTime?,
    val updatedTs: OffsetDateTime?,
)
