package emented.setup

import emented.dao.RoleDao
import emented.model.domain.Role
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class SetupRoleLoader(
    private val roleDao: RoleDao
) : ApplicationListener<ContextRefreshedEvent> {

    private var alreadySetup: Boolean = false

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        if (alreadySetup) return

        val adminRole = Role(id = null, name = "ROLE_ADMIN")
        val userRole = Role(id = null, name = "ROLE_USER")

        roleDao.createRoles(listOf(adminRole, userRole))

        alreadySetup = true
    }
}