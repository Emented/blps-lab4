package emented.extensions

import emented.model.RegistrationInfo
import emented.model.domain.Role
import emented.model.domain.User

fun RegistrationInfo.toDomainModel(encodingFunction: (CharSequence) -> String): User {
    return User(
        id = null,
        username = this.username,
        password = encodingFunction.invoke(this.password),
        email = this.email,
        birthDate = this.birthDate,
        activity = 0,
        roles = this.roles.map { Role(id = null, name = it) },
    )
}
