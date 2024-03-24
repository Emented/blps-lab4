package emented.extensions

import emented.model.CategoryResponse
import emented.model.domain.Category

fun Category.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id!!,
        name = this.name,
    )
}
