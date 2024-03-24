package emented.extensions

import emented.model.RegistrationInfo
import emented.model.RegistrationRequest

fun RegistrationRequest.toModel(): RegistrationInfo {
    return RegistrationInfo(
        username = this.username,
        password = this.password,
        email = this.email,
        birthDate = this.birthDate,
        roles = this.roles,
    )
}
