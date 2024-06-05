package emented.model.domain

import emented.model.Language
import java.time.OffsetDateTime

data class CommunityEvent(
    val id: Long?,
    val communityId: Long,
    val userId: Long,
    val name: String,
    val address: String,
    val language: Language,
    val description: String,
    val isForChildren: Boolean,
    val isBlocked: Boolean,
    val interestRate: Long,
    val category: Category,
    val creationTs: OffsetDateTime?,
    val eventType: CommunityEventType,
)