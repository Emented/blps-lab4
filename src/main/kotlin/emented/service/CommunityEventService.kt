package emented.service

import emented.model.domain.CommunityEvent
import org.springframework.kafka.support.SendResult
import java.util.concurrent.CompletableFuture

interface CommunityEventService {
    fun publishEvent(
        communityEvent: CommunityEvent,
    ): CompletableFuture<SendResult<String, CommunityEvent>>
}