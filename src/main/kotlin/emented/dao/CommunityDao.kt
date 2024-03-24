package emented.dao

import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.Community

interface CommunityDao {
    fun create(community: Community): Community?
    fun getById(communityId: Long): Community?
    fun search(
        name: String?,
        language: Language?,
        isForChildren: Boolean?,
        category: Category?,
    ): List<Community>
    fun block(communityId: Long): Boolean
}
