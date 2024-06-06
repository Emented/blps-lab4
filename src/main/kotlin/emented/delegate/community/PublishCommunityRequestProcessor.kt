package emented.delegate.community

import emented.model.CommunityInfo
import emented.model.Language
import emented.service.CommunityService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class PublishCommunityRequestProcessor(
    private val runtimeService: RuntimeService,
    private val communityService: CommunityService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        var userId = delegateExecution.processEngineServices.identityService.currentAuthentication.userId
        if (userId == "guest") {
            runtimeService.deleteProcessInstance(delegateExecution.processInstanceId, "Guest cannot write reviews!")
            return
        }

        val name = delegateExecution.getVariable("name_creation").toString()
        val address = delegateExecution.getVariable("address_creation").toString()
        val language = Language.valueOf(delegateExecution.getVariable("language_creation").toString())
        val description = delegateExecution.getVariable("description_creation").toString()
        val isForChildren = delegateExecution.getVariable("is_for_children_creation") as Boolean
        val category = delegateExecution.getVariable("category_creation").toString()

        val communityInfo = CommunityInfo(
            name = name,
            address = address,
            language = language,
            description = description,
            isForChildren = isForChildren,
            category = category,
        )

        if (userId == "emented") {
            userId = "0"
        }

        val createdCommunity = communityService.createCommunity(communityInfo, userId.toLong())

        if (createdCommunity == null) {
            delegateExecution.setVariable(
                "textarea_creation_result",
                "Ошибка при создании комьюнити!"
            )
            return
        }

        delegateExecution.setVariable(
            "textarea_creation_result",
            "Комьюнити успешно создано! Его id: ${createdCommunity.id}"
        )
    }
}