/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActReCamformdef

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActReCamformdefRecord() : UpdatableRecordImpl<ActReCamformdefRecord>(ActReCamformdef.ACT_RE_CAMFORMDEF) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var key_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var version_: Int?
        set(value): Unit = set(3, value)
        get(): Int? = get(3) as Int?

    open var deploymentId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var resourceName_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var tenantId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActReCamformdefRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        key_: String? = null,
        version_: Int? = null,
        deploymentId_: String? = null,
        resourceName_: String? = null,
        tenantId_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.key_ = key_
        this.version_ = version_
        this.deploymentId_ = deploymentId_
        this.resourceName_ = resourceName_
        this.tenantId_ = tenantId_
        resetChangedOnNotNull()
    }
}
