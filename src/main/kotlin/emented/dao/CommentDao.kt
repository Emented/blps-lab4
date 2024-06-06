package emented.dao

import emented.model.domain.Comment

interface CommentDao {

    fun create(userId: Long, communityId: Long, comment: Comment): Comment?
    fun getById(commentId: Long): Comment?
    fun getAllByCommunityId(communityId: Long): List<Comment>
    fun updateTextValue(commentId: Long, textValue: String): Boolean
    fun delete(commentId: Long)
    fun checkUserRelation(commentId: Long, userId: Long): Boolean
}