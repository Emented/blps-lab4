package emented.dao

import emented.model.domain.Role

interface RoleDao {
    fun createRoles(roles: List<Role>)
}
