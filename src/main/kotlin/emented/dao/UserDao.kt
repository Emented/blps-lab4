package emented.dao

import emented.model.domain.User

interface UserDao {
    fun create(user: User): User?
    fun getById(userId: Long): User?
    fun getByUsername(username: String): User?
    fun deleteById(userId: Long)
    fun increaseActivity(incrementValue: Long, userId: Long)
}
