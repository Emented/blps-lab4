package emented.dao.impl

import emented.dao.CommunityArchiveDao
import emented.jooq.archive.tables.references.COMMUNITY_ARCHIVE
import emented.model.Language
import emented.model.domain.ArchiveCommunity
import emented.model.domain.ModerationResult
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.OffsetDateTime

@Repository
class CommunityArchiveDaoImpl(
    @Qualifier("archiveDslContext")
    private val archiveDSLContext: DSLContext,
    private val clock: Clock,
) : CommunityArchiveDao {
    override fun createWithId(archiveCommunity: ArchiveCommunity): ArchiveCommunity? {
        val now = OffsetDateTime.now(clock)
        return archiveDSLContext.insertInto(COMMUNITY_ARCHIVE)
            .set(COMMUNITY_ARCHIVE.ID, archiveCommunity.id)
            .set(COMMUNITY_ARCHIVE.USER_ID, archiveCommunity.userId)
            .set(COMMUNITY_ARCHIVE.NAME, archiveCommunity.name)
            .set(COMMUNITY_ARCHIVE.ADDRESS, archiveCommunity.address)
            .set(COMMUNITY_ARCHIVE.LANGUAGE, archiveCommunity.language.name)
            .set(COMMUNITY_ARCHIVE.DESCRIPTION, archiveCommunity.description)
            .set(COMMUNITY_ARCHIVE.IS_FOR_CHILDREN, archiveCommunity.isForChildren)
            .set(COMMUNITY_ARCHIVE.CATEGORY_NAME, archiveCommunity.categoryName)
            .set(COMMUNITY_ARCHIVE.IS_BLOCKED, archiveCommunity.isBlocked)
            .set(COMMUNITY_ARCHIVE.INTEREST_RATE, archiveCommunity.interestRate)
            .set(COMMUNITY_ARCHIVE.MODERATION_RESULT, archiveCommunity.moderationResult.name)
            .set(COMMUNITY_ARCHIVE.MODERATION_MESSAGE, archiveCommunity.moderationMessage)
            .set(COMMUNITY_ARCHIVE.CREATION_TS, archiveCommunity.createdTs)
            .set(COMMUNITY_ARCHIVE.UPDATE_TS, archiveCommunity.updatedTs)
            .set(COMMUNITY_ARCHIVE.ARCHIVATION_TS, now)
            .onConflictDoNothing()
            .returning(communityFields)
            .fetchOne(CommunityArchiveDaoImpl::mapArchiveCommunity)
    }

    override fun deleteById(communityId: Long): Boolean {
        return archiveDSLContext.deleteFrom(COMMUNITY_ARCHIVE)
            .where(COMMUNITY_ARCHIVE.ID.eq(communityId))
            .execute() > 0
    }

    override fun getById(communityId: Long): ArchiveCommunity? {
        return archiveDSLContext.select(communityFields)
            .from(COMMUNITY_ARCHIVE)
            .where(COMMUNITY_ARCHIVE.ID.eq(communityId))
            .fetchOne(CommunityArchiveDaoImpl::mapArchiveCommunity)
    }

    companion object {
        val communityFields = setOf(
            COMMUNITY_ARCHIVE.ID,
            COMMUNITY_ARCHIVE.USER_ID,
            COMMUNITY_ARCHIVE.NAME,
            COMMUNITY_ARCHIVE.ADDRESS,
            COMMUNITY_ARCHIVE.LANGUAGE,
            COMMUNITY_ARCHIVE.DESCRIPTION,
            COMMUNITY_ARCHIVE.IS_FOR_CHILDREN,
            COMMUNITY_ARCHIVE.IS_BLOCKED,
            COMMUNITY_ARCHIVE.INTEREST_RATE,
            COMMUNITY_ARCHIVE.MODERATION_RESULT,
            COMMUNITY_ARCHIVE.MODERATION_MESSAGE,
            COMMUNITY_ARCHIVE.CATEGORY_NAME,
            COMMUNITY_ARCHIVE.CREATION_TS,
            COMMUNITY_ARCHIVE.UPDATE_TS,
            COMMUNITY_ARCHIVE.ARCHIVATION_TS,
        )

        fun mapArchiveCommunity(record: Record): ArchiveCommunity {
            return ArchiveCommunity(
                id = record.get(COMMUNITY_ARCHIVE.ID),
                userId = record.get(COMMUNITY_ARCHIVE.USER_ID)!!,
                name = record.get(COMMUNITY_ARCHIVE.NAME)!!,
                address = record.get(COMMUNITY_ARCHIVE.ADDRESS)!!,
                language = Language.valueOf(record.get(COMMUNITY_ARCHIVE.LANGUAGE)!!),
                description = record.get(COMMUNITY_ARCHIVE.DESCRIPTION)!!,
                isForChildren = record.get(COMMUNITY_ARCHIVE.IS_FOR_CHILDREN)!!,
                isBlocked = record.get(COMMUNITY_ARCHIVE.IS_BLOCKED)!!,
                interestRate = record.get(COMMUNITY_ARCHIVE.INTEREST_RATE)!!,
                moderationResult = ModerationResult.valueOf(record.get(COMMUNITY_ARCHIVE.MODERATION_RESULT)!!),
                moderationMessage = record.get(COMMUNITY_ARCHIVE.MODERATION_MESSAGE),
                categoryName = record.get(COMMUNITY_ARCHIVE.CATEGORY_NAME)!!,
                createdTs = record.get(COMMUNITY_ARCHIVE.CREATION_TS),
                updatedTs = record.get(COMMUNITY_ARCHIVE.UPDATE_TS),
                archivationTs = record.get(COMMUNITY_ARCHIVE.ARCHIVATION_TS)
            )
        }
    }
}