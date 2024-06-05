package emented.job

import emented.properties.SchedulerProperties
import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.Trigger
import org.quartz.TriggerBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ArchiveCommunityJobConfig(
    val schedulerProperties: SchedulerProperties,
) {

    @Bean
    fun showTimeJobDetail(): JobDetail = JobBuilder
        .newJob(ArchiveCommunityJob::class.java)
        .withIdentity("archiveCommunityJob", schedulerProperties.permanentJobsGroupName)
        .storeDurably()
        .requestRecovery(true)
        .build()

    @Bean
    fun showTimeTrigger(): Trigger = TriggerBuilder.newTrigger()
        .forJob(showTimeJobDetail())
        .withIdentity("archiveCommunityJobTrigger", schedulerProperties.permanentJobsGroupName)
        .withSchedule(CronScheduleBuilder.cronSchedule(schedulerProperties.archiveCommunityJobCron))
        .build()
}