/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActHiCaseactinst
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiCaseactinstRecord() : UpdatableRecordImpl<ActHiCaseactinstRecord>(ActHiCaseactinst.ACT_HI_CASEACTINST) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var parentActInstId_: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var caseDefId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var caseInstId_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var caseActId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var taskId_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var callProcInstId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var callCaseInstId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var caseActName_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var caseActType_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var createTime_: LocalDateTime?
        set(value): Unit = set(10, value)
        get(): LocalDateTime? = get(10) as LocalDateTime?

    open var endTime_: LocalDateTime?
        set(value): Unit = set(11, value)
        get(): LocalDateTime? = get(11) as LocalDateTime?

    open var duration_: Long?
        set(value): Unit = set(12, value)
        get(): Long? = get(12) as Long?

    open var state_: Int?
        set(value): Unit = set(13, value)
        get(): Int? = get(13) as Int?

    open var required_: Boolean?
        set(value): Unit = set(14, value)
        get(): Boolean? = get(14) as Boolean?

    open var tenantId_: String?
        set(value): Unit = set(15, value)
        get(): String? = get(15) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActHiCaseactinstRecord
     */
    constructor(
        id_: String? = null,
        parentActInstId_: String? = null,
        caseDefId_: String? = null,
        caseInstId_: String? = null,
        caseActId_: String? = null,
        taskId_: String? = null,
        callProcInstId_: String? = null,
        callCaseInstId_: String? = null,
        caseActName_: String? = null,
        caseActType_: String? = null,
        createTime_: LocalDateTime? = null,
        endTime_: LocalDateTime? = null,
        duration_: Long? = null,
        state_: Int? = null,
        required_: Boolean? = null,
        tenantId_: String? = null
    ) : this() {
        this.id_ = id_
        this.parentActInstId_ = parentActInstId_
        this.caseDefId_ = caseDefId_
        this.caseInstId_ = caseInstId_
        this.caseActId_ = caseActId_
        this.taskId_ = taskId_
        this.callProcInstId_ = callProcInstId_
        this.callCaseInstId_ = callCaseInstId_
        this.caseActName_ = caseActName_
        this.caseActType_ = caseActType_
        this.createTime_ = createTime_
        this.endTime_ = endTime_
        this.duration_ = duration_
        this.state_ = state_
        this.required_ = required_
        this.tenantId_ = tenantId_
        resetChangedOnNotNull()
    }
}
