/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActRuFilter

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActRuFilterRecord() : UpdatableRecordImpl<ActRuFilterRecord>(ActRuFilter.ACT_RU_FILTER) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var resourceType_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var name_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var owner_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var query_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var properties_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActRuFilterRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        resourceType_: String? = null,
        name_: String? = null,
        owner_: String? = null,
        query_: String? = null,
        properties_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.resourceType_ = resourceType_
        this.name_ = name_
        this.owner_ = owner_
        this.query_ = query_
        this.properties_ = properties_
        resetChangedOnNotNull()
    }
}
