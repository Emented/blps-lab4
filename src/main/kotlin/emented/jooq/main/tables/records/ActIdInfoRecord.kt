/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActIdInfo

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActIdInfoRecord() : UpdatableRecordImpl<ActIdInfoRecord>(ActIdInfo.ACT_ID_INFO) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var userId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var type_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var key_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var value_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var password_: ByteArray?
        set(value): Unit = set(6, value)
        get(): ByteArray? = get(6) as ByteArray?

    open var parentId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActIdInfoRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        userId_: String? = null,
        type_: String? = null,
        key_: String? = null,
        value_: String? = null,
        password_: ByteArray? = null,
        parentId_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.userId_ = userId_
        this.type_ = type_
        this.key_ = key_
        this.value_ = value_
        this.password_ = password_
        this.parentId_ = parentId_
        resetChangedOnNotNull()
    }
}
