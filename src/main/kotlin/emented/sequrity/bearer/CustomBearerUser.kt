package emented.sequrity.bearer

data class CustomBearerUser(
    val userId: Long,
    val roles: List<String>,
    val username: String? = null,
)
