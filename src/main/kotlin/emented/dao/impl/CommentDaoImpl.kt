package emented.dao.impl

import emented.dao.CommentDao
import emented.jooq.main.tables.references.COMMENT
import emented.model.domain.Comment
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL.selectOne
import org.springframework.stereotype.Repository
import java.time.Clock
import java.time.OffsetDateTime

@Repository
class CommentDaoImpl(
    private val mainDslContext: DSLContext,
    private val clock: Clock,
) : CommentDao {
    override fun create(userId: Long, communityId: Long, comment: Comment): Comment? {
        return mainDslContext.insertInto(COMMENT)
            .set(COMMENT.TEXT_VALUE, comment.textValue)
            .set(COMMENT.UPDATED_AT, comment.updatedAt)
            .set(COMMENT.CREATED_AT, comment.createdAt)
            .set(COMMENT.COMMUNITY_ID, communityId)
            .set(COMMENT.USER_ID, userId)
            .returning(commentFields)
            .fetchOne(CommentDaoImpl::mapComment)
    }

    override fun checkUserRelation(commentId: Long, userId: Long): Boolean {
        return mainDslContext.fetchExists(
            selectOne()
                .from(COMMENT)
                .where(COMMENT.ID.eq(commentId).and(COMMENT.USER_ID.eq(userId)))
        )
    }

    override fun getById(commentId: Long): Comment? {
        return mainDslContext.select(commentFields)
            .from(COMMENT)
            .where(COMMENT.ID.eq(commentId))
            .fetchOne(CommentDaoImpl::mapComment)
    }

    override fun getAllByCommunityId(communityId: Long): List<Comment> {
        return mainDslContext.select(commentFields)
            .from(COMMENT)
            .where(COMMENT.COMMUNITY_ID.eq(communityId))
            .fetch(CommentDaoImpl::mapComment)
    }

    override fun updateTextValue(commentId: Long, textValue: String): Boolean {
        return mainDslContext.update(COMMENT)
            .set(COMMENT.TEXT_VALUE, textValue)
            .set(COMMENT.UPDATED_AT, OffsetDateTime.now(clock))
            .where(COMMENT.ID.eq(commentId))
            .execute() > 0
    }

    override fun delete(commentId: Long) {
        val isDeleted = mainDslContext.deleteFrom(COMMENT)
            .where(COMMENT.ID.eq(commentId))
            .execute() > 0

        if (!isDeleted) {
            error("Failed to delete comment with id: $commentId")
        }
    }

    companion object {
        val commentFields = setOf(
            COMMENT.ID,
            COMMENT.TEXT_VALUE,
            COMMENT.UPDATED_AT,
            COMMENT.CREATED_AT,
            COMMENT.COMMUNITY_ID
        )

        fun mapComment(record: Record): Comment {
            return Comment(
                id = record.get(COMMENT.ID),
                communityId = record.get(COMMENT.COMMUNITY_ID),
                textValue = record.get(COMMENT.TEXT_VALUE)!!,
                updatedAt = record.get(COMMENT.UPDATED_AT)!!,
                createdAt = record.get(COMMENT.CREATED_AT)!!,
            )
        }
    }
}