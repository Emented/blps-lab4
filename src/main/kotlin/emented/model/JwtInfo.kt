package emented.model

data class JwtInfo(
    val userId: Long,
    val accessToken: String,
    val refreshToken: String
)
