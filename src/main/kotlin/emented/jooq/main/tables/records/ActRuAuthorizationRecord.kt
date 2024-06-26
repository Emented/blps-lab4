/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActRuAuthorization
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActRuAuthorizationRecord() :
    UpdatableRecordImpl<ActRuAuthorizationRecord>(ActRuAuthorization.ACT_RU_AUTHORIZATION) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var type_: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    open var groupId_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var userId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var resourceType_: Int?
        set(value): Unit = set(5, value)
        get(): Int? = get(5) as Int?

    open var resourceId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var perms_: Int?
        set(value): Unit = set(7, value)
        get(): Int? = get(7) as Int?

    open var removalTime_: LocalDateTime?
        set(value): Unit = set(8, value)
        get(): LocalDateTime? = get(8) as LocalDateTime?

    open var rootProcInstId_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActRuAuthorizationRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        type_: Int? = null,
        groupId_: String? = null,
        userId_: String? = null,
        resourceType_: Int? = null,
        resourceId_: String? = null,
        perms_: Int? = null,
        removalTime_: LocalDateTime? = null,
        rootProcInstId_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.type_ = type_
        this.groupId_ = groupId_
        this.userId_ = userId_
        this.resourceType_ = resourceType_
        this.resourceId_ = resourceId_
        this.perms_ = perms_
        this.removalTime_ = removalTime_
        this.rootProcInstId_ = rootProcInstId_
        resetChangedOnNotNull()
    }
}
