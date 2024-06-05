package emented.dao.impl

import emented.dao.CommunityDao
import emented.jooq.main.tables.references.CATEGORY
import emented.jooq.main.tables.references.COMMUNITY
import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.Community
import emented.model.domain.ModerationResult
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.noCondition
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.OffsetDateTime

@Repository
class CommunityDaoImpl(
    private val mainDslContext: DSLContext,
    private val clock: Clock,
) : CommunityDao {

    override fun create(community: Community): Community? {
        val now = OffsetDateTime.now(clock)
        return mainDslContext.insertInto(COMMUNITY)
            .set(COMMUNITY.USER_ID, community.userId)
            .set(COMMUNITY.NAME, community.name)
            .set(COMMUNITY.ADDRESS, community.address)
            .set(COMMUNITY.LANGUAGE, community.language.name)
            .set(COMMUNITY.DESCRIPTION, community.description)
            .set(COMMUNITY.IS_FOR_CHILDREN, community.isForChildren)
            .set(
                COMMUNITY.CATEGORY_ID,
                select(CATEGORY.ID).from(CATEGORY).where(CATEGORY.NAME.eq(community.category.name)),
            )
            .set(COMMUNITY.IS_BLOCKED, community.isBlocked)
            .set(COMMUNITY.INTEREST_RATE, community.interestRate)
            .set(COMMUNITY.MODERATION_RESULT, community.moderationResult.name)
            .set(COMMUNITY.MODERATION_MESSAGE, community.moderationMessage)
            .set(COMMUNITY.CREATION_TS, now)
            .set(COMMUNITY.UPDATE_TS, now)
            .onConflictDoNothing()
            .returning(emptyCommunityFields)
            .fetchOne {
                mapEmptyCommunity(it, community.category)
            }
    }

    override fun createWithId(community: Community): Community? {
        val now = OffsetDateTime.now(clock)
        return mainDslContext.insertInto(COMMUNITY)
            .set(COMMUNITY.ID, community.id!!)
            .set(COMMUNITY.USER_ID, community.userId)
            .set(COMMUNITY.NAME, community.name)
            .set(COMMUNITY.ADDRESS, community.address)
            .set(COMMUNITY.LANGUAGE, community.language.name)
            .set(COMMUNITY.DESCRIPTION, community.description)
            .set(COMMUNITY.IS_FOR_CHILDREN, community.isForChildren)
            .set(
                COMMUNITY.CATEGORY_ID,
                select(CATEGORY.ID).from(CATEGORY).where(CATEGORY.NAME.eq(community.category.name)),
            )
            .set(COMMUNITY.IS_BLOCKED, community.isBlocked)
            .set(COMMUNITY.INTEREST_RATE, community.interestRate)
            .set(COMMUNITY.MODERATION_RESULT, community.moderationResult.name)
            .set(COMMUNITY.MODERATION_MESSAGE, community.moderationMessage)
            .set(COMMUNITY.CREATION_TS, now)
            .set(COMMUNITY.UPDATE_TS, now)
            .onConflictDoNothing()
            .returning(emptyCommunityFields)
            .fetchOne {
                mapEmptyCommunity(it, community.category)
            }
    }

    override fun deleteById(communityId: Long): Boolean {
        return mainDslContext.deleteFrom(COMMUNITY)
            .where(COMMUNITY.ID.eq(communityId))
            .execute() > 0
    }

    override fun getById(communityId: Long): Community? {
        return mainDslContext.select(communityFields)
            .from(COMMUNITY)
            .join(CATEGORY).on(COMMUNITY.CATEGORY_ID.eq(CATEGORY.ID))
            .where(COMMUNITY.ID.eq(communityId))
            .fetchOne(CommunityDaoImpl::mapCommunity)
    }

    override fun block(communityId: Long): Boolean {
        return mainDslContext.update(COMMUNITY)
            .set(COMMUNITY.IS_BLOCKED, true)
            .set(COMMUNITY.UPDATE_TS, OffsetDateTime.now(clock))
            .where(COMMUNITY.ID.eq(communityId))
            .execute() > 0
    }

    override fun updateModerationInfo(
        communityId: Long,
        moderationResult: ModerationResult,
        moderationMessage: String
    ): Boolean {
        return mainDslContext.update(COMMUNITY)
            .set(COMMUNITY.MODERATION_RESULT, moderationResult.name)
            .set(COMMUNITY.MODERATION_MESSAGE, moderationMessage)
            .set(COMMUNITY.UPDATE_TS, OffsetDateTime.now(clock))
            .where(COMMUNITY.ID.eq(communityId))
            .execute() > 0
    }

    override fun increaseInterestRate(incrementValue: Long, communityId: Long) {
        val isUpdated = mainDslContext.update(COMMUNITY)
            .set(COMMUNITY.INTEREST_RATE, COMMUNITY.INTEREST_RATE.plus(incrementValue))
            .set(COMMUNITY.UPDATE_TS, OffsetDateTime.now(clock))
            .where(COMMUNITY.ID.eq(communityId))
            .execute() > 0

        if (!isUpdated) {
            error("Failed to increase interest rate for community with id: $communityId")
        }
    }

    override fun getOldUpdatedCommunities(timeTill: OffsetDateTime, limit: Int): List<Long> {
        return mainDslContext.select(COMMUNITY.ID)
            .from(COMMUNITY)
            .where(COMMUNITY.UPDATE_TS.le(timeTill))
            .limit(100)
            .fetch {
                it.value1()
            }
    }

    override fun search(
        name: String?,
        language: Language?,
        isForChildren: Boolean?,
        category: Category?,
    ): List<Community> {
        val nameCondition = name?.let { COMMUNITY.NAME.like("%$it%") }
        val languageCondition = language?.let { COMMUNITY.LANGUAGE.eq(it.name) }
        val isForChildrenCondition = isForChildren?.let { COMMUNITY.IS_FOR_CHILDREN.eq(it) }
        val categoryCondition = category?.let { CATEGORY.NAME.eq(it.name) }

        val resultCondition = sequenceOf(
            noCondition(),
            nameCondition,
            languageCondition,
            isForChildrenCondition,
            categoryCondition,
        ).reduce { acc, condition -> acc?.and(condition) }

        return mainDslContext.select(communityFields)
            .from(COMMUNITY)
            .join(CATEGORY).on(COMMUNITY.CATEGORY_ID.eq(CATEGORY.ID))
            .where(COMMUNITY.IS_BLOCKED.isFalse.and(resultCondition))
            .fetch(CommunityDaoImpl::mapCommunity)
    }

    companion object {
        val communityFields = setOf(
            COMMUNITY.ID,
            COMMUNITY.USER_ID,
            COMMUNITY.NAME,
            COMMUNITY.ADDRESS,
            COMMUNITY.LANGUAGE,
            COMMUNITY.DESCRIPTION,
            COMMUNITY.IS_FOR_CHILDREN,
            COMMUNITY.IS_BLOCKED,
            COMMUNITY.INTEREST_RATE,
            COMMUNITY.MODERATION_RESULT,
            COMMUNITY.MODERATION_MESSAGE,
            COMMUNITY.CREATION_TS,
            COMMUNITY.UPDATE_TS,
            CATEGORY.ID,
            CATEGORY.NAME,
        )

        val emptyCommunityFields = setOf(
            COMMUNITY.ID,
            COMMUNITY.USER_ID,
            COMMUNITY.NAME,
            COMMUNITY.ADDRESS,
            COMMUNITY.LANGUAGE,
            COMMUNITY.DESCRIPTION,
            COMMUNITY.IS_FOR_CHILDREN,
            COMMUNITY.IS_BLOCKED,
            COMMUNITY.INTEREST_RATE,
            COMMUNITY.MODERATION_RESULT,
            COMMUNITY.MODERATION_MESSAGE,
            COMMUNITY.CREATION_TS,
            COMMUNITY.UPDATE_TS,
        )

        fun mapCommunity(record: Record): Community {
            return Community(
                id = record.get(COMMUNITY.ID),
                userId = record.get(COMMUNITY.USER_ID)!!,
                name = record.get(COMMUNITY.NAME)!!,
                address = record.get(COMMUNITY.ADDRESS)!!,
                language = Language.valueOf(record.get(COMMUNITY.LANGUAGE)!!),
                description = record.get(COMMUNITY.DESCRIPTION)!!,
                isForChildren = record.get(COMMUNITY.IS_FOR_CHILDREN)!!,
                isBlocked = record.get(COMMUNITY.IS_BLOCKED)!!,
                interestRate = record.get(COMMUNITY.INTEREST_RATE)!!,
                moderationResult = ModerationResult.valueOf(record.get(COMMUNITY.MODERATION_RESULT)!!),
                moderationMessage = record.get(COMMUNITY.MODERATION_MESSAGE),
                category = CategoryDaoImpl.mapCategory(record),
                createdTs = record.get(COMMUNITY.CREATION_TS),
                updatedTs = record.get(COMMUNITY.UPDATE_TS),
            )
        }

        fun mapEmptyCommunity(record: Record, category: Category): Community {
            return Community(
                id = record.get(COMMUNITY.ID),
                userId = record.get(COMMUNITY.USER_ID)!!,
                name = record.get(COMMUNITY.NAME)!!,
                address = record.get(COMMUNITY.ADDRESS)!!,
                language = Language.valueOf(record.get(COMMUNITY.LANGUAGE)!!),
                description = record.get(COMMUNITY.DESCRIPTION)!!,
                isForChildren = record.get(COMMUNITY.IS_FOR_CHILDREN)!!,
                isBlocked = record.get(COMMUNITY.IS_BLOCKED)!!,
                interestRate = record.get(COMMUNITY.INTEREST_RATE)!!,
                moderationResult = ModerationResult.valueOf(record.get(COMMUNITY.MODERATION_RESULT)!!),
                moderationMessage = record.get(COMMUNITY.MODERATION_MESSAGE),
                category = category,
                createdTs = record.get(COMMUNITY.CREATION_TS),
                updatedTs = record.get(COMMUNITY.UPDATE_TS),
            )
        }
    }
}
