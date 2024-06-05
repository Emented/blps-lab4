package emented.service.impl

import emented.dao.CategoryDao
import emented.dao.CommunityDao
import emented.dao.CommunityEventDao
import emented.exception.InvalidCategoryException
import emented.extensions.toModel
import emented.model.CommunityInfo
import emented.model.Language
import emented.model.ModerationInfo
import emented.model.domain.Category
import emented.model.domain.Community
import emented.model.domain.CommunityEvent
import emented.model.domain.CommunityEventType
import emented.sequrity.bearer.CustomBearerUser
import emented.service.CommunityArchivationService
import emented.service.CommunityService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class CommunityServiceImpl(
    private val communityDao: CommunityDao,
    private val categoryDao: CategoryDao,
    private val communityArchivationService: CommunityArchivationService,
    private val communityEventDao: CommunityEventDao,
    private val transactionTemplate: TransactionTemplate,
) : CommunityService {
    override fun getCommunityById(communityId: Long): Community? {
        return communityDao.getById(communityId)
    }

    override fun getCategories(): List<Category> {
        return categoryDao.getCategories()
    }

    override fun createCommunity(communityInfo: CommunityInfo): Community? {
        val userId = gerUserId()
        val community = communityInfo.toModel(userId)

        val result = transactionTemplate.execute {
            val created = try {
                communityDao.create(community)
            } catch (e: DataIntegrityViolationException) {
                throw InvalidCategoryException("Category is invalid!")
            }

            created?.let {
                communityEventDao.create(it.toCommunityEvent(CommunityEventType.COMMUNITY_CREATED))
            }

            return@execute created
        }

        return result
    }

    override fun searchCommunities(
        name: String?,
        category: String?,
        language: Language?,
        isForChildren: Boolean?,
    ): List<Community> {
        return communityDao.search(
            name = name,
            language = language,
            isForChildren = isForChildren,
            category = category?.let { Category(null, it) },
        )
    }

    override fun blockCommunity(communityId: Long): Boolean {
        return communityDao.block(communityId)
    }

    override fun unarchiveCommunity(communityId: Long): Boolean {
        return try {
            communityArchivationService.unarchive(communityId)
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    override fun addModeration(communityId: Long, moderationInfo: ModerationInfo): Boolean {
        return communityDao.updateModerationInfo(
            communityId,
            moderationInfo.moderationResult,
            moderationInfo.moderationMessage,
        )
    }

    override fun increaseCommunityInterestRate(communityId: Long, rate: Long) {
        communityDao.increaseInterestRate(rate, communityId)
    }

    private fun gerUserId(): Long {
        val principal = SecurityContextHolder.getContext().authentication.principal as CustomBearerUser
        return principal.userId
    }

    private fun Community.toCommunityEvent(eventType: CommunityEventType): CommunityEvent {
        return CommunityEvent(
            id = null,
            communityId = requireNotNull(this.id),
            userId = requireNotNull(this.userId),
            name = this.name,
            address = this.address,
            language = this.language,
            description = this.description,
            isForChildren = this.isForChildren,
            isBlocked = this.isBlocked,
            interestRate = this.interestRate,
            category = this.category,
            eventType = eventType,
            creationTs = null,
        )
    }
}
