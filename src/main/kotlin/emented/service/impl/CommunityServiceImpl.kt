package emented.service.impl

import emented.dao.CategoryDao
import emented.dao.CommunityDao
import emented.exception.InvalidCategoryException
import emented.extensions.toModel
import emented.model.CommunityInfo
import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.Community
import emented.sequrity.bearer.CustomBearerUser
import emented.service.CommunityService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommunityServiceImpl(
    private val communityDao: CommunityDao,
    private val categoryDao: CategoryDao,
) : CommunityService {
    @Transactional(readOnly = true)
    override fun getCommunityById(communityId: Long): Community? {
        return communityDao.getById(communityId)
    }

    @Transactional(readOnly = true)
    override fun getCategories(): List<Category> {
        return categoryDao.getCategories()
    }

    @Transactional
    override fun createCommunity(communityInfo: CommunityInfo): Community? {
        val userId = gerUserId()
        val community = communityInfo.toModel(userId)

        return try {
            communityDao.create(community)
        } catch (e: DataIntegrityViolationException) {
            throw InvalidCategoryException("Category is invalid!")
        }
    }

    @Transactional(readOnly = true)
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

    private fun gerUserId(): Long {
        val principal = SecurityContextHolder.getContext().authentication.principal as CustomBearerUser
        return principal.userId
    }
}
