package emented.extensions

import emented.model.CommunityInfo
import emented.model.CreateCommunityRequest

fun CreateCommunityRequest.toModel(): CommunityInfo {
    return CommunityInfo(
        name = this.name,
        address = this.address,
        language = this.language.toModel(),
        description = this.description,
        isForChildren = this.isForChildren,
        category = this.category,
    )
}
