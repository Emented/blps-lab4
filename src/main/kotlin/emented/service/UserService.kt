package emented.service

import emented.model.JwtInfo
import emented.model.RegistrationInfo

interface UserService {
    fun registerUser(registrationInfo: RegistrationInfo)
    fun loginUser(username: String, password: String): JwtInfo
    fun refreshUser(refreshToken: String): JwtInfo
    fun increaseUserActivity(userId: Long, activity: Long)
    fun isUserAdmin(userId: Long): Boolean
}
