package emented.delegate.community

import emented.service.CommunityService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class BlockCommunityRequestProcessor(
    private val communityService: CommunityService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        val groups = delegateExecution.processEngineServices.identityService.currentAuthentication.groupIds
        if (!groups.contains("moderators") && !groups.contains("camunda-admin")) {
            delegateExecution.setVariable(
                "block_result",
                "Вам отказано в доступе, вы не админ и не модератор! Не тратьте ресурсы сервера пожалуйста!"
            )
            return
        }

        val communityId = delegateExecution.getVariable("community_id_block") as Long

        val result = communityService.blockCommunity(communityId)

        delegateExecution.setVariable(
            "block_result",
            if (result) "Комьюнити заблокировано" else "Не удалось заблокировать комьюнити с id: $communityId"
        )
    }
}