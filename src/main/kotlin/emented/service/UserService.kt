package emented.service

import emented.model.JwtInfo
import emented.model.RegistrationInfo

interface UserService {
    fun registerUser(registrationInfo: RegistrationInfo)
    fun loginUser(username: String, password: String): JwtInfo
    fun logoutUser()
    fun refreshUser(refreshToken: String): JwtInfo
}
