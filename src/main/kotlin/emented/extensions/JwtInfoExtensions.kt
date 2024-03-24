package emented.extensions

import emented.model.JwtInfo
import emented.model.JwtInfoResponse

fun JwtInfo.toResponse(): JwtInfoResponse {
    return JwtInfoResponse(
        userId = this.userId,
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
    )
}
