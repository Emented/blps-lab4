package emented.extensions

import emented.model.CommunityInfo
import emented.model.domain.Category
import emented.model.domain.Community
import emented.model.domain.ModerationResult

fun CommunityInfo.toModel(userId: Long): Community {
    return Community(
        id = null,
        userId = userId,
        name = this.name,
        address = this.address,
        language = this.language,
        description = this.description,
        isForChildren = this.isForChildren,
        isBlocked = false,
        interestRate = 0,
        category = Category(null, this.category),
        moderationResult = ModerationResult.PENDING,
        moderationMessage = null,
        createdTs = null,
        updatedTs = null,
    )
}
