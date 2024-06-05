package emented.extensions

import emented.sequrity.bearer.CustomBearerUser

fun CustomBearerUser.isAdmin(): Boolean {
    return this.roles.contains("ROLE_ADMIN")
}