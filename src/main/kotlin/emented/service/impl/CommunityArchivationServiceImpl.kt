package emented.service.impl

import emented.dao.CommunityArchiveDao
import emented.dao.CommunityDao
import emented.model.domain.ArchiveCommunity
import emented.model.domain.Category
import emented.model.domain.Community
import emented.service.CommunityArchivationService
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class CommunityArchivationServiceImpl(
    private val communityDao: CommunityDao,
    private val communityArchiveDao: CommunityArchiveDao,
    private val transactionTemplate: TransactionTemplate,
) : CommunityArchivationService {
    override fun archive(communityId: Long) {
        transactionTemplate.executeWithoutResult {
            val community = communityDao.getById(communityId) ?: error("Community not found")
            communityArchiveDao.createWithId(community.toArchiveCommunity()) ?: error("Archive persist failed")
            communityDao.deleteById(communityId)
        }
    }

    override fun unarchive(communityId: Long) {
        transactionTemplate.executeWithoutResult {
            val archiveCommunity = communityArchiveDao.getById(communityId) ?: error("Archive community not found")
            communityDao.createWithId(archiveCommunity.toCommunity()) ?: error("Persist failed")
            communityArchiveDao.deleteById(communityId)
        }
    }

    private fun Community.toArchiveCommunity(): ArchiveCommunity {
        return ArchiveCommunity(
            id = this.id,
            userId = this.userId!!,
            name = this.name,
            address = this.address,
            language = this.language,
            description = this.description,
            isForChildren = this.isForChildren,
            isBlocked = this.isBlocked,
            interestRate = this.interestRate,
            categoryName = this.category.name,
            moderationResult = this.moderationResult,
            moderationMessage = this.moderationMessage,
            createdTs = this.createdTs,
            updatedTs = this.updatedTs,
            archivationTs = null,
        )
    }

    private fun ArchiveCommunity.toCommunity(): Community {
        return Community(
            id = this.id,
            userId = this.userId,
            name = this.name,
            address = this.address,
            language = this.language,
            description = this.description,
            isForChildren = this.isForChildren,
            isBlocked = this.isBlocked,
            interestRate = this.interestRate,
            category = Category(id = null, name = this.categoryName),
            moderationResult = this.moderationResult,
            moderationMessage = this.moderationMessage,
            createdTs = null,
            updatedTs = null,
        )
    }
}