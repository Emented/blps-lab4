package emented.service.impl

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.impl.IdentityServiceImpl
import org.springframework.stereotype.Service

@Service
class GroupService : JavaDelegate {
    override fun execute(delegateExecution: DelegateExecution) {
        val identityService = delegateExecution.processEngineServices.identityService as IdentityServiceImpl

        if (identityService.createGroupQuery().groupId("guests").count() == 0L) {
            val guestsGroup = identityService.newGroup("guests")
            guestsGroup.name = "Guests"
            guestsGroup.type = "WORKFLOW"
            identityService.saveGroup(guestsGroup)
        }

        if (identityService.createGroupQuery().groupId("authorized").count() == 0L) {
            val authorizedGroup = identityService.newGroup("authorized")
            authorizedGroup.name = "Authorized"
            authorizedGroup.type = "WORKFLOW"
            identityService.saveGroup(authorizedGroup)
        }

        if (identityService.createGroupQuery().groupId("moderators").count() == 0L) {
            val moderatorGroup = identityService.newGroup("moderators")
            moderatorGroup.name = "Moderators"
            moderatorGroup.type = "WORKFLOW"
            identityService.saveGroup(moderatorGroup)
        }

        if (identityService.createUserQuery().userId("guest").count() == 0L) {
            val guest = identityService.newUser("guest")
            guest.firstName = "Guest"
            guest.lastName = "Guest"
            guest.password = "guest"
            guest.email = "guest@camunda.org"
            identityService.saveUser(guest, true)
            identityService.createMembership("guest", "guests")
        }
    }
}

