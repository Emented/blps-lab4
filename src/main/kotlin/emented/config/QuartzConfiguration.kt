package emented.config

import org.springframework.boot.autoconfigure.quartz.QuartzDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class QuartzConfiguration(private val mainDataSource: DataSource) {
    @Bean
    @QuartzDataSource
    fun quartzDataSource(): DataSource {
        return mainDataSource
    }
}
