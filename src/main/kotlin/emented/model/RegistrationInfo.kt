package emented.model

import java.time.LocalDate

data class RegistrationInfo(
    val username: String,
    val password: String,
    val email: String,
    val birthDate: LocalDate,
    val roles: List<String>,
)
