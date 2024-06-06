package emented.delegate.event

import emented.dao.CommunityEventDao
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class CommunityEventDataFetcherSendData(
    private val communityEventDao: CommunityEventDao,
) : JavaDelegate {

    override fun execute(delegateExecution: DelegateExecution) {
        val communityEventsToBeSend = communityEventDao.getNotSent(LIMIT)

        delegateExecution.setVariable("communities_to_be_send", communityEventsToBeSend)
    }

    companion object {
        private const val LIMIT = 100
    }
}