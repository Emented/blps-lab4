package emented.service.impl

import emented.dao.CommentDao
import emented.model.domain.Comment
import emented.service.CommentService
import emented.service.CommunityService
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate
import java.time.Clock
import java.time.OffsetDateTime

@Service
class CommentServiceImpl(
    private val commentDao: CommentDao,
    private val communityService: CommunityService,
    private val transactionTemplate: TransactionTemplate,
    private val clock: Clock,
) : CommentService {
    override fun createComment(communityId: Long, userId: Long, textValue: String): Comment? {
        val now = OffsetDateTime.now(clock)
        val comment = Comment(
            id = null,
            communityId = communityId,
            textValue = textValue,
            updatedAt = now,
            createdAt = now,
        )

        return transactionTemplate.execute {
            communityService.increaseCommunityInterestRate(communityId, COMMENT_ADD_INCREMENT_RATE)
            commentDao.create(userId, communityId, comment)
        }
    }

    override fun getCommentById(commentId: Long): Comment? {
        return commentDao.getById(commentId)
    }

    override fun getCommentByCommunityId(communityId: Long): List<Comment> {
        return commentDao.getAllByCommunityId(communityId)
    }

    override fun updateCommentText(
        commentId: Long,
        userId: Long,
        textValue: String,
        isModerator: Boolean
    ): Boolean {
        val hasAccess = isModerator || commentDao.checkUserRelation(commentId, userId)

        if (hasAccess) {
            return commentDao.updateTextValue(commentId, textValue)
        }

        return false
    }

    override fun deleteComment(commentId: Long, userId: Long, isModerator: Boolean): Boolean {
        val hasAccess = isModerator || commentDao.checkUserRelation(commentId, userId)

        if (!hasAccess) {
            return false
        }

        return try {
            transactionTemplate.executeWithoutResult {
                val communityId = commentDao.getById(commentId)?.communityId ?: error("Comment should exist")
                communityService.increaseCommunityInterestRate(communityId, COMMENT_DELETE_INCREMENT_RATE)
                commentDao.delete(commentId)
            }
            true
        } catch (e: IllegalStateException) {
            false
        }
    }

    companion object {
        private const val COMMENT_DELETE_INCREMENT_RATE = 5L
        private const val COMMENT_ADD_INCREMENT_RATE = 10L
    }
}