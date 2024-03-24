package emented.model.domain

import emented.model.Language

data class Community(
    val id: Long?,
    val userId: Long?,
    val name: String,
    val address: String,
    val language: Language,
    val description: String,
    val isForChildren: Boolean,
    val category: Category,
)
