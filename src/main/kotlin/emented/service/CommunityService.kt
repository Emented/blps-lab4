package emented.service

import emented.model.CommunityInfo
import emented.model.Language
import emented.model.ModerationInfo
import emented.model.domain.Category
import emented.model.domain.Community

interface CommunityService {
    fun getCommunityById(communityId: Long): Community?
    fun getCategories(): List<Category>
    fun createCommunity(communityInfo: CommunityInfo, userId: Long): Community?
    fun searchCommunities(
        name: String?,
        category: String?,
        language: Language?,
        isForChildren: Boolean?,
    ): List<Community>

    fun blockCommunity(communityId: Long): Boolean
    fun addModeration(communityId: Long, toModel: ModerationInfo): Boolean
    fun increaseCommunityInterestRate(communityId: Long, rate: Long)
}
