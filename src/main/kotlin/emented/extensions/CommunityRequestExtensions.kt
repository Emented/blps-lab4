package emented.extensions

import emented.model.CommunityInfo
import emented.model.CommunityRequest

fun CommunityRequest.toModel(): CommunityInfo {
    return CommunityInfo(
        name = this.name,
        address = this.address,
        language = this.language.toModel(),
        description = this.description,
        isForChildren = this.isForChildren,
        category = this.category,
    )
}
