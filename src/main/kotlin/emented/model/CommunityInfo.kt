package emented.model

data class CommunityInfo(
    val name: String,
    val address: String,
    val language: Language,
    val description: String,
    val isForChildren: Boolean,
    val category: String
)
