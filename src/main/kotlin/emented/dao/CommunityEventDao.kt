package emented.dao

import emented.model.domain.CommunityEvent

interface CommunityEventDao {
    fun create(communityEvent: CommunityEvent): CommunityEvent?
    fun markAsSent(ids: Set<Long>)
    fun getNotSent(limit: Int): List<CommunityEvent>
}