package emented.api

import emented.extensions.toModel
import emented.extensions.toResponse
import emented.model.IsAdminResponse
import emented.model.JwtInfoResponse
import emented.model.RefreshRequest
import emented.model.RegistrationRequest
import emented.model.UserCredentials
import emented.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserApiService(
    private val userService: UserService,
) : UserApiDelegate {
    override fun loginUser(userCredentials: UserCredentials): ResponseEntity<JwtInfoResponse> {
        return ResponseEntity.ok(
            userService.loginUser(userCredentials.username, userCredentials.password).toResponse(),
        )
    }

    override fun refreshUser(refreshRequest: RefreshRequest): ResponseEntity<JwtInfoResponse> {
        return ResponseEntity.ok(userService.refreshUser(refreshRequest.refreshToken).toResponse())
    }

    override fun registerUser(registrationRequest: RegistrationRequest): ResponseEntity<Unit> {
        userService.registerUser(registrationRequest.toModel())

        return ResponseEntity.ok().build()
    }

    override fun increaseUserActivity(userId: Long, activity: Long): ResponseEntity<Unit> {
        userService.increaseUserActivity(userId, activity)

        return ResponseEntity.ok().build()
    }

    override fun isUserAdmin(userId: Long): ResponseEntity<IsAdminResponse> {
        return ResponseEntity.ok(IsAdminResponse(userService.isUserAdmin(userId)))
    }
}
