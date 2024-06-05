package emented.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "scheduler")
data class SchedulerProperties(
    val permanentJobsGroupName: String = "PERMANENT",
    val archiveCommunityJobCron: String = "0 */5 * * * ?",
    val publishCommunityEventJobCron: String = "*/5 * * * * ?",
)