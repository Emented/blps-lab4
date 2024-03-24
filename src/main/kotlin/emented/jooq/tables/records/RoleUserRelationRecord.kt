/*
 * This file is generated by jOOQ.
 */
package emented.jooq.tables.records


import emented.jooq.tables.RoleUserRelation

import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class RoleUserRelationRecord() : TableRecordImpl<RoleUserRelationRecord>(RoleUserRelation.ROLE_USER_RELATION) {

    open var userId: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var roleId: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    /**
     * Create a detached, initialised RoleUserRelationRecord
     */
    constructor(userId: Long? = null, roleId: Long? = null): this() {
        this.userId = userId
        this.roleId = roleId
        resetChangedOnNotNull()
    }
}
