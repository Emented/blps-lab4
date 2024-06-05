package emented.service.impl

import emented.model.domain.CommunityEvent
import emented.service.CommunityEventService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CommunityEventServiceImpl(
    @Qualifier("communityKafkaTemplate")
    private val communityKafkaTemplate: KafkaTemplate<String, CommunityEvent>,
) : CommunityEventService {
    override fun publishEvent(
        communityEvent: CommunityEvent,
    ): CompletableFuture<SendResult<String, CommunityEvent>> {
        log.info("Sending event: {}", communityEvent)

        return communityKafkaTemplate.sendDefault(communityEvent)
    }

    companion object {
        private val log = LoggerFactory.getLogger(CommunityEventServiceImpl::class.java)
    }
}