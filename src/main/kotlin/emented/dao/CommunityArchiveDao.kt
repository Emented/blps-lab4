package emented.dao

import emented.model.domain.ArchiveCommunity

interface CommunityArchiveDao {
    fun createWithId(archiveCommunity: ArchiveCommunity): ArchiveCommunity?
    fun deleteById(communityId: Long): Boolean
    fun getById(communityId: Long): ArchiveCommunity?
}