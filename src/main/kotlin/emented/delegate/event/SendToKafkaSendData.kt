package emented.delegate.event

import emented.dao.CommunityEventDao
import emented.model.domain.CommunityEvent
import emented.service.CommunityEventService
import org.camunda.bpm.engine.RuntimeService
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class SendToKafkaSendData(
    private val runtimeService: RuntimeService,
    private val communityEventDao: CommunityEventDao,
    private val communityEventService: CommunityEventService,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        val communityEvents = delegateExecution.getVariable("communities_to_be_send") as List<CommunityEvent>
        if (communityEvents.isEmpty()) {
            runtimeService.deleteProcessInstance(
                delegateExecution.processInstanceId,
                "There is no changed communities..."
            )
            return
        }

        communityEvents.forEach {
            communityEventService.publishEvent(it)
        }

        communityEventDao.markAsSent(communityEvents.map { it.id!! }.toSet())
    }
}