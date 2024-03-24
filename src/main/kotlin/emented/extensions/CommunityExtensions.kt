package emented.extensions

import emented.model.CommunityResponse
import emented.model.domain.Community

fun Community.toResponse(): CommunityResponse {
    return CommunityResponse(
        id = this.id!!,
        name = this.name,
        address = this.address,
        language = this.language.toResponse(),
        description = this.description,
        isForChildren = this.isForChildren,
        category = this.category.toResponse(),
    )
}
