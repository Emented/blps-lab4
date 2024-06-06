package emented.service

import emented.model.domain.Comment

interface CommentService {
    fun createComment(communityId: Long, userId: Long, textValue: String): Comment?
    fun getCommentById(commentId: Long): Comment?
    fun getCommentByCommunityId(communityId: Long): List<Comment>
    fun updateCommentText(commentId: Long, userId: Long, textValue: String, isModerator: Boolean): Boolean
    fun deleteComment(commentId: Long, userId: Long, isModerator: Boolean): Boolean
}