package emented.dao.impl

import emented.dao.RoleDao
import emented.jooq.tables.records.RoleRecord
import emented.jooq.tables.references.ROLE
import emented.model.domain.Role
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class RoleDaoImpl(
    private val dslContext: DSLContext,
) : RoleDao {
    override fun createRoles(roles: List<Role>) {
        val insertQueries = roles.map {
            dslContext.insertInto(ROLE)
                .set(RoleRecord(id = null, name = it.name))
                .onConflictDoNothing()
        }

        dslContext.batch(insertQueries).execute()
    }
}