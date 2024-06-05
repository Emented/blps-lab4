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
class PublishCommunityEventJobConfig(
    val schedulerProperties: SchedulerProperties,
) {

    @Bean
    fun publishCommunityEventJobDetail(): JobDetail = JobBuilder
        .newJob(PublishCommunityEventJob::class.java)
        .withIdentity("publishCommunityEventJob", schedulerProperties.permanentJobsGroupName)
        .storeDurably()
        .requestRecovery(true)
        .build()

    @Bean
    fun publishCommunityEventTrigger(): Trigger = TriggerBuilder.newTrigger()
        .forJob(publishCommunityEventJobDetail())
        .withIdentity("publishCommunityEventJobTrigger", schedulerProperties.permanentJobsGroupName)
        .withSchedule(CronScheduleBuilder.cronSchedule(schedulerProperties.publishCommunityEventJobCron))
        .build()
}