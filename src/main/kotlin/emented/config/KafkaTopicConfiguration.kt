package emented.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfiguration {

    @Value(value = "\${spring.kafka.bootstrap-servers}")
    private lateinit var bootstrapAddress: String

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configProps: MutableMap<String, Any> = HashMap()
        configProps[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configProps)
    }

    @Bean
    fun communityEventTopic(): NewTopic {
        return NewTopic(COMMUNITY_TOPIC_NAME, 1, 1)
    }

    companion object {
        const val COMMUNITY_TOPIC_NAME = "community-event-topic"
    }
}