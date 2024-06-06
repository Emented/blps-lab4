package emented.delegate.common

import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.impl.IdentityServiceImpl
import org.springframework.stereotype.Component

@Component
class RegistrationRequestProcessor(
    private val runtimeService: RuntimeService
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        val userId = delegateExecution.getVariable("user_id_register") as Long
        val userName = delegateExecution.getVariable("fist_name_register").toString()
        val userSurname = delegateExecution.getVariable("last_name_register").toString()
        val userPassword = delegateExecution.getVariable("password_register").toString()

        val identityService = delegateExecution.processEngineServices.identityService as IdentityServiceImpl
        if (identityService.createUserQuery().userId(userId.toString()).count() != 0L) {
            runtimeService.deleteProcessInstance(
                delegateExecution.processInstanceId,
                "User id=$userId already exists!"
            )
            return
        }

        val newUser = identityService.newUser(userId.toString())
        newUser.firstName = userName
        newUser.lastName = userSurname
        newUser.password = userPassword
        newUser.email = "$userId@yandex.ru"
        identityService.saveUser(newUser, true)
        identityService.createMembership(userId.toString(), "authorized")
        delegateExecution.setVariable("textarea_register_result", "Вы успешно зарегистрированы!")
    }
}