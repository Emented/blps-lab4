/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActIdTenant

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActIdTenantRecord() : UpdatableRecordImpl<ActIdTenantRecord>(ActIdTenant.ACT_ID_TENANT) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var name_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActIdTenantRecord
     */
    constructor(id_: String? = null, rev_: Int? = null, name_: String? = null) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.name_ = name_
        resetChangedOnNotNull()
    }
}
