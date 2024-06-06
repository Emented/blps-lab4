/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActIdTenantMember

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActIdTenantMemberRecord() :
    UpdatableRecordImpl<ActIdTenantMemberRecord>(ActIdTenantMember.ACT_ID_TENANT_MEMBER) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var tenantId_: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var userId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var groupId_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActIdTenantMemberRecord
     */
    constructor(
        id_: String? = null,
        tenantId_: String? = null,
        userId_: String? = null,
        groupId_: String? = null
    ) : this() {
        this.id_ = id_
        this.tenantId_ = tenantId_
        this.userId_ = userId_
        this.groupId_ = groupId_
        resetChangedOnNotNull()
    }
}
