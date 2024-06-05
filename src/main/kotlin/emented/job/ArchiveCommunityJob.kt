package emented.job

import emented.dao.CommunityDao
import emented.service.CommunityArchivationService
import org.quartz.DisallowConcurrentExecution
import org.quartz.JobExecutionContext
import org.quartz.PersistJobDataAfterExecution
import org.slf4j.LoggerFactory
import org.springframework.scheduling.quartz.QuartzJobBean
import java.time.Clock
import java.time.OffsetDateTime

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
class ArchiveCommunityJob(
    private val communityArchivationService: CommunityArchivationService,
    private val communityDao: CommunityDao,
    private val clock: Clock,
) : QuartzJobBean() {
    override fun executeInternal(context: JobExecutionContext) {
        val communityIds = communityDao.getOldUpdatedCommunities(OffsetDateTime.now(clock).minusDays(1), LIMIT)
        log.info("Archiving ${communityIds.size} communities")

        communityIds.forEach {
            communityArchivationService.archive(it)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(ArchiveCommunityJob::class.java)
        private const val LIMIT = 100
    }
}