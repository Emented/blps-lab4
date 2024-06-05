package emented.service.impl

import emented.dao.UserDao
import emented.exception.InvalidRefreshTokenException
import emented.exception.UserAlreadyExistsException
import emented.extensions.toDomainModel
import emented.model.JwtInfo
import emented.model.RegistrationInfo
import emented.sequrity.service.JwtTokenUtil
import emented.sequrity.service.UserDetailsImpl
import emented.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userDao: UserDao,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenUtil: JwtTokenUtil,
    private val authenticationManager: AuthenticationManager,
) : UserService {

    @Transactional
    override fun registerUser(registrationInfo: RegistrationInfo) {
        val user = registrationInfo.toDomainModel(passwordEncoder::encode)

        userDao.create(user) ?: throw UserAlreadyExistsException(
            "User already exists!",
        )
    }

    @Transactional
    override fun loginUser(
        username: String,
        password: String,
    ): JwtInfo {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(username, password),
        )

        val userDetails = authentication.principal as UserDetailsImpl
        val userId = userDetails.getUserId()
        val roles = userDetails.authorities.map { it.authority }

        return JwtInfo(
            userId,
            jwtTokenUtil.generateAccessToken(userId, roles),
            jwtTokenUtil.generateRefreshToken(userId, roles),
        )
    }

    @Transactional
    override fun refreshUser(refreshToken: String): JwtInfo {
        if (!jwtTokenUtil.validateRefreshToken(refreshToken)) {
            throw InvalidRefreshTokenException("Invalid refresh token!")
        }

        val (userId, roles) = jwtTokenUtil.getInfoFromRefreshToken(refreshToken)
        val accessToken = jwtTokenUtil.generateAccessToken(userId, roles)

        return JwtInfo(userId, accessToken, refreshToken)
    }

    override fun increaseUserActivity(userId: Long, activity: Long) {
        userDao.increaseActivity(activity, userId)
    }

    override fun isUserAdmin(userId: Long): Boolean {
        return userDao.getById(userId)?.roles?.any { it.name == "ROLE_ADMIN" } ?: error("User not found")
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(UserServiceImpl::class.java)
    }
}
