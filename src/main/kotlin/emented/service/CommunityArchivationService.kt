package emented.service

interface CommunityArchivationService {
    fun archive(communityId: Long)
    fun unarchive(communityId: Long)
}