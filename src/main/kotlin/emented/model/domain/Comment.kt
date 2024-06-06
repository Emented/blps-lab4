package emented.model.domain

import java.time.OffsetDateTime

data class Comment(
    val id: Long?,
    val communityId: Long?,
    val textValue: String,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
)
