package emented.dao.impl

import emented.dao.UserDao
import emented.exception.InvalidRoleException
import emented.jooq.tables.records.RoleRecord
import emented.jooq.tables.records.UserRecord
import emented.jooq.tables.references.ROLE
import emented.jooq.tables.references.ROLE_USER_RELATION
import emented.jooq.tables.references.USER
import emented.model.domain.Role
import emented.model.domain.User
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Repository

@Repository
class UserDaoImpl(
    private val dslContext: DSLContext,
) : UserDao {
    override fun create(user: User): User? {
        val persistedUser = dslContext.insertInto(USER)
            .set(USER.USERNAME, user.username)
            .set(USER.PASSWORD, user.password)
            .set(USER.EMAIL, user.email)
            .set(USER.BIRTH_DATE, user.birthDate)
            .onConflictDoNothing()
            .returning(userFields)
            .fetchOne(UserDaoImpl::mapUser) ?: return null

        for (role in user.roles) {
            dslContext.insertInto(
                ROLE_USER_RELATION,
                ROLE_USER_RELATION.ROLE_ID,
                ROLE_USER_RELATION.USER_ID
            )
                .values(
                    dslContext.select(ROLE.ID)
                        .from(ROLE)
                        .where(ROLE.NAME.eq(role.name))
                        .fetchOne()?.get(ROLE.ID) ?: throw InvalidRoleException("Role doesn't exist"),
                    persistedUser.id!!
                )
                .execute()
        }

        return persistedUser.copy(
            roles = user.roles
        )
    }

    override fun getById(userId: Long): User? {
        val mapResult = dslContext.select()
            .from(USER)
            .join(ROLE_USER_RELATION).on(USER.ID.eq(ROLE_USER_RELATION.USER_ID))
            .join(ROLE).on(ROLE_USER_RELATION.ROLE_ID.eq(ROLE.ID))
            .where(USER.ID.eq(userId))
            .fetchGroups(USER, ROLE)

        return mapResult.entries.firstOrNull()?.let { mapEntry(it) }
    }

    override fun getByUsername(username: String): User? {
        val mapResult = dslContext.select()
            .from(USER)
            .join(ROLE_USER_RELATION).on(USER.ID.eq(ROLE_USER_RELATION.USER_ID))
            .join(ROLE).on(ROLE_USER_RELATION.ROLE_ID.eq(ROLE.ID))
            .where(USER.USERNAME.eq(username))
            .fetchGroups(USER, ROLE)

        return mapResult.entries.firstOrNull()?.let { mapEntry(it) }
    }

    override fun deleteById(userId: Long) {
        dslContext.deleteFrom(USER)
            .where(USER.ID.eq(userId))
            .execute()
    }

    companion object {
        val userFields = setOf(
            USER.ID,
            USER.USERNAME,
            USER.PASSWORD,
            USER.EMAIL,
            USER.BIRTH_DATE,
        )

        fun mapUser(record: Record): User {
            return User(
                id = record.get(USER.ID),
                username = record.get(USER.USERNAME)!!,
                password = record.get(USER.PASSWORD)!!,
                email = record.get(USER.EMAIL)!!,
                birthDate = record.get(USER.BIRTH_DATE)!!,
                roles = listOf()
            )
        }

        fun mapEntry(entry: MutableMap.MutableEntry<UserRecord, Result<RoleRecord>>): User {
            return User(
                id = entry.key.id!!,
                username = entry.key.username!!,
                password = entry.key.password!!,
                email = entry.key.email!!,
                birthDate = entry.key.birthDate!!,
                roles = entry.value.map {
                    Role(
                        id = it.id!!,
                        name = it.name!!
                    )
                }
            )
        }
    }
}
