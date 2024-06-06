package emented.dao.impl

import emented.dao.CommunityEventDao
import emented.jooq.main.tables.references.CATEGORY
import emented.jooq.main.tables.references.COMMUNITY_EVENT
import emented.model.Language
import emented.model.domain.Category
import emented.model.domain.CommunityEvent
import emented.model.domain.CommunityEventType
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.OffsetDateTime

@Service
class CommunityEventDaoImpl(
    private val mainDslContext: DSLContext,
    private val clock: Clock,
) : CommunityEventDao {
    override fun create(communityEvent: CommunityEvent): CommunityEvent? {
        val now = OffsetDateTime.now(clock)
        return mainDslContext.insertInto(COMMUNITY_EVENT)
            .set(COMMUNITY_EVENT.COMMUNITY_ID, communityEvent.communityId)
            .set(COMMUNITY_EVENT.USER_ID, communityEvent.userId)
            .set(COMMUNITY_EVENT.NAME, communityEvent.name)
            .set(COMMUNITY_EVENT.ADDRESS, communityEvent.address)
            .set(COMMUNITY_EVENT.LANGUAGE, communityEvent.language.name)
            .set(COMMUNITY_EVENT.DESCRIPTION, communityEvent.description)
            .set(COMMUNITY_EVENT.IS_FOR_CHILDREN, communityEvent.isForChildren)
            .set(
                COMMUNITY_EVENT.CATEGORY_ID,
                DSL.select(CATEGORY.ID).from(CATEGORY).where(CATEGORY.NAME.eq(communityEvent.category.name)),
            )
            .set(COMMUNITY_EVENT.IS_BLOCKED, communityEvent.isBlocked)
            .set(COMMUNITY_EVENT.INTEREST_RATE, communityEvent.interestRate)
            .set(COMMUNITY_EVENT.EVENT_TYPE, communityEvent.eventType.name)
            .set(COMMUNITY_EVENT.IS_SENT, false)
            .set(COMMUNITY_EVENT.CREATION_TS, now)
            .onConflictDoNothing()
            .returning(emptyCommunityEventFields)
            .fetchOne {
                mapEmptyCommunityEvent(it, communityEvent.category)
            }
    }

    override fun markAsSent(ids: Set<Long>) {
        mainDslContext.update(COMMUNITY_EVENT)
            .set(COMMUNITY_EVENT.IS_SENT, true)
            .where(COMMUNITY_EVENT.ID.`in`(ids))
            .execute()
    }

    override fun getNotSent(limit: Int): List<CommunityEvent> {
        return mainDslContext.select(communityEventFields)
            .from(COMMUNITY_EVENT)
            .join(CATEGORY).on(COMMUNITY_EVENT.CATEGORY_ID.eq(CATEGORY.ID))
            .where(COMMUNITY_EVENT.IS_SENT.isFalse)
            .limit(limit)
            .fetch(CommunityEventDaoImpl::mapCommunityEvent)
    }

    companion object {
        val communityEventFields = setOf(
            COMMUNITY_EVENT.ID,
            COMMUNITY_EVENT.COMMUNITY_ID,
            COMMUNITY_EVENT.USER_ID,
            COMMUNITY_EVENT.NAME,
            COMMUNITY_EVENT.ADDRESS,
            COMMUNITY_EVENT.LANGUAGE,
            COMMUNITY_EVENT.DESCRIPTION,
            COMMUNITY_EVENT.IS_FOR_CHILDREN,
            COMMUNITY_EVENT.IS_BLOCKED,
            COMMUNITY_EVENT.INTEREST_RATE,
            COMMUNITY_EVENT.CREATION_TS,
            COMMUNITY_EVENT.EVENT_TYPE,
            CATEGORY.ID,
            CATEGORY.NAME,
        )

        val emptyCommunityEventFields = setOf(
            COMMUNITY_EVENT.ID,
            COMMUNITY_EVENT.COMMUNITY_ID,
            COMMUNITY_EVENT.USER_ID,
            COMMUNITY_EVENT.NAME,
            COMMUNITY_EVENT.ADDRESS,
            COMMUNITY_EVENT.LANGUAGE,
            COMMUNITY_EVENT.DESCRIPTION,
            COMMUNITY_EVENT.IS_FOR_CHILDREN,
            COMMUNITY_EVENT.IS_BLOCKED,
            COMMUNITY_EVENT.INTEREST_RATE,
            COMMUNITY_EVENT.CREATION_TS,
            COMMUNITY_EVENT.EVENT_TYPE,
        )

        fun mapCommunityEvent(record: Record): CommunityEvent {
            return CommunityEvent(
                id = record.get(COMMUNITY_EVENT.ID),
                communityId = record.get(COMMUNITY_EVENT.COMMUNITY_ID)!!,
                userId = record.get(COMMUNITY_EVENT.USER_ID)!!,
                name = record.get(COMMUNITY_EVENT.NAME)!!,
                address = record.get(COMMUNITY_EVENT.ADDRESS)!!,
                language = Language.valueOf(record.get(COMMUNITY_EVENT.LANGUAGE)!!),
                description = record.get(COMMUNITY_EVENT.DESCRIPTION)!!,
                isForChildren = record.get(COMMUNITY_EVENT.IS_FOR_CHILDREN)!!,
                isBlocked = record.get(COMMUNITY_EVENT.IS_BLOCKED)!!,
                interestRate = record.get(COMMUNITY_EVENT.INTEREST_RATE)!!,
                category = CategoryDaoImpl.mapCategory(record),
                creationTs = record.get(COMMUNITY_EVENT.CREATION_TS),
                eventType = CommunityEventType.valueOf(record.get(COMMUNITY_EVENT.EVENT_TYPE)!!)
            )
        }

        fun mapEmptyCommunityEvent(record: Record, category: Category): CommunityEvent {
            return CommunityEvent(
                id = record.get(COMMUNITY_EVENT.ID),
                communityId = record.get(COMMUNITY_EVENT.COMMUNITY_ID)!!,
                userId = record.get(COMMUNITY_EVENT.USER_ID)!!,
                name = record.get(COMMUNITY_EVENT.NAME)!!,
                address = record.get(COMMUNITY_EVENT.ADDRESS)!!,
                language = Language.valueOf(record.get(COMMUNITY_EVENT.LANGUAGE)!!),
                description = record.get(COMMUNITY_EVENT.DESCRIPTION)!!,
                isForChildren = record.get(COMMUNITY_EVENT.IS_FOR_CHILDREN)!!,
                isBlocked = record.get(COMMUNITY_EVENT.IS_BLOCKED)!!,
                interestRate = record.get(COMMUNITY_EVENT.INTEREST_RATE)!!,
                category = category,
                creationTs = record.get(COMMUNITY_EVENT.CREATION_TS),
                eventType = CommunityEventType.valueOf(record.get(COMMUNITY_EVENT.EVENT_TYPE)!!)
            )
        }
    }
}