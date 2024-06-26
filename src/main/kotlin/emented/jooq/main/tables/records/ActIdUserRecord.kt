/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActIdUser
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActIdUserRecord() : UpdatableRecordImpl<ActIdUserRecord>(ActIdUser.ACT_ID_USER) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var first_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var last_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var email_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var pwd_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var salt_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var lockExpTime_: LocalDateTime?
        set(value): Unit = set(7, value)
        get(): LocalDateTime? = get(7) as LocalDateTime?

    open var attempts_: Int?
        set(value): Unit = set(8, value)
        get(): Int? = get(8) as Int?

    open var pictureId_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActIdUserRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        first_: String? = null,
        last_: String? = null,
        email_: String? = null,
        pwd_: String? = null,
        salt_: String? = null,
        lockExpTime_: LocalDateTime? = null,
        attempts_: Int? = null,
        pictureId_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.first_ = first_
        this.last_ = last_
        this.email_ = email_
        this.pwd_ = pwd_
        this.salt_ = salt_
        this.lockExpTime_ = lockExpTime_
        this.attempts_ = attempts_
        this.pictureId_ = pictureId_
        resetChangedOnNotNull()
    }
}
