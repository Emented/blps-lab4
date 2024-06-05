package emented.dao

import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.Community
import emented.model.domain.ModerationResult
import java.time.OffsetDateTime

interface CommunityDao {
    fun create(community: Community): Community?
    fun createWithId(community: Community): Community?
    fun deleteById(communityId: Long): Boolean
    fun getById(communityId: Long): Community?
    fun search(
        name: String?,
        language: Language?,
        isForChildren: Boolean?,
        category: Category?,
    ): List<Community>

    fun block(communityId: Long): Boolean
    fun increaseInterestRate(incrementValue: Long, communityId: Long)

    fun getOldUpdatedCommunities(timeTill: OffsetDateTime, limit: Int): List<Long>
    fun updateModerationInfo(communityId: Long, moderationResult: ModerationResult, moderationMessage: String): Boolean
}
