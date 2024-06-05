package emented.model.domain

import java.time.LocalDate

data class User(
    val id: Long?,
    val username: String,
    val password: String,
    val email: String,
    val birthDate: LocalDate,
    val activity: Long,
    val roles: List<Role>,
)
