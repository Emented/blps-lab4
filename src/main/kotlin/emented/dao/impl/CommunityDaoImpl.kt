package emented.dao.impl

import emented.dao.CommunityDao
import emented.jooq.tables.references.CATEGORY
import emented.jooq.tables.references.COMMUNITY
import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.Community
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.noCondition
import org.jooq.impl.DSL.select
import org.springframework.stereotype.Repository

@Repository
class CommunityDaoImpl(
    private val dslContext: DSLContext,
) : CommunityDao {

    override fun create(community: Community): Community? {
        return dslContext.insertInto(COMMUNITY)
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
            .set(COMMUNITY.IS_BLOCKED, false)
            .onConflictDoNothing()
            .returning(emptyCommunityFields)
            .fetchOne {
                mapEmptyCommunity(it, community.category)
            }
    }

    override fun getById(communityId: Long): Community? {
        return dslContext.select(communityFields)
            .from(COMMUNITY)
            .join(CATEGORY).on(COMMUNITY.CATEGORY_ID.eq(CATEGORY.ID))
            .where(COMMUNITY.ID.eq(communityId))
            .fetchOne(CommunityDaoImpl::mapCommunity)
    }

    override fun block(communityId: Long): Boolean {
        return dslContext.update(COMMUNITY)
            .set(COMMUNITY.IS_BLOCKED, true)
            .where(COMMUNITY.ID.eq(communityId))
            .execute() > 0
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

        return dslContext.select(communityFields)
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
                category = CategoryDaoImpl.mapCategory(record),
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
                category = category,
            )
        }
    }
}
