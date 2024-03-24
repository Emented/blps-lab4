package emented.extensions

import emented.model.CommunityInfo
import emented.model.domain.Category
import emented.model.domain.Community

fun CommunityInfo.toModel(userId: Long): Community {
    return Community(
        id = null,
        userId = userId,
        name = this.name,
        address = this.address,
        language = this.language,
        description = this.description,
        isForChildren = this.isForChildren,
        category = Category(null, this.category),
    )
}
