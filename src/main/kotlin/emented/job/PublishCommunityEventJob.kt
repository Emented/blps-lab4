package emented.job

import emented.dao.CommunityEventDao
import emented.service.CommunityEventService
import org.quartz.DisallowConcurrentExecution
import org.quartz.JobExecutionContext
import org.quartz.PersistJobDataAfterExecution
import org.springframework.scheduling.quartz.QuartzJobBean
import org.springframework.transaction.support.TransactionTemplate

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
class PublishCommunityEventJob(
    private val communityEventDao: CommunityEventDao,
    private val communityEventService: CommunityEventService,
    private val transactionTemplate: TransactionTemplate,
) : QuartzJobBean() {
    override fun executeInternal(context: JobExecutionContext) {
        transactionTemplate.executeWithoutResult {
            val communityEvents = communityEventDao.getNotSentForUpdate(LIMIT)

            communityEvents.forEach {
                communityEventService.publishEvent(it)
            }

            communityEventDao.markAsSent(communityEvents.map { it.id!! }.toSet())
        }
    }

    companion object {
        private const val LIMIT = 100
    }
}