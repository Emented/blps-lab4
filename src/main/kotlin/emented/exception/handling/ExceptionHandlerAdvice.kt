package emented.exception.handling

import emented.exception.InvalidCategoryException
import emented.exception.InvalidRefreshTokenException
import emented.exception.InvalidRoleException
import emented.exception.UserAlreadyExistsException
import emented.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.stream.Collectors

@ControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    private fun handleConstraintViolationException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val bindingResult = e.bindingResult
        val errors = bindingResult.fieldErrors.stream().collect(
            Collectors.toMap(
                { it.field },
                { it.defaultMessage ?: "Validation failed!" },
            ),
        )
        val errorDTO = ErrorResponse(errors.toString())
        return ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    private fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse(e.message ?: "Message not readable")
        return ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [InvalidCategoryException::class])
    private fun handleInvalidCategoryException(e: InvalidCategoryException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse(e.message ?: "Category is invalid")
        return ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [InvalidRoleException::class])
    private fun handleInvalidRoleException(e: InvalidRoleException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse(e.message ?: "Role is invalid")
        return ResponseEntity(errorDTO, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [BadCredentialsException::class])
    private fun handleBadCredentialsException(e: BadCredentialsException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse("Bad credentials!")
        return ResponseEntity(errorDTO, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(value = [UserAlreadyExistsException::class])
    private fun handleUserAlreadyExistsException(e: UserAlreadyExistsException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse("User already exists!")
        return ResponseEntity(errorDTO, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [InvalidRefreshTokenException::class])
    private fun handleInvalidRefreshTokenException(e: InvalidRefreshTokenException): ResponseEntity<ErrorResponse> {
        val errorDTO = ErrorResponse(e.message ?: "Invalid refresh token")
        return ResponseEntity(errorDTO, HttpStatus.FORBIDDEN)
    }
}
