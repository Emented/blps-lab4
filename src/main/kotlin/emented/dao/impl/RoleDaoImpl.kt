package emented.dao.impl

import emented.dao.RoleDao
import emented.jooq.main.tables.records.RoleRecord
import emented.jooq.main.tables.references.ROLE
import emented.model.domain.Role
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class RoleDaoImpl(
    private val mainDslContext: DSLContext,
) : RoleDao {
    override fun createRoles(roles: List<Role>) {
        val insertQueries = roles.map {
            mainDslContext.insertInto(ROLE)
                .set(RoleRecord(id = null, name = it.name))
                .onConflictDoNothing()
        }

        mainDslContext.batch(insertQueries).execute()
    }
}