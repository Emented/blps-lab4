/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActHiActinst
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiActinstRecord() : UpdatableRecordImpl<ActHiActinstRecord>(ActHiActinst.ACT_HI_ACTINST) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var parentActInstId_: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var procDefKey_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var procDefId_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var rootProcInstId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var procInstId_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var executionId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var actId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var taskId_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var callProcInstId_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var callCaseInstId_: String?
        set(value): Unit = set(10, value)
        get(): String? = get(10) as String?

    open var actName_: String?
        set(value): Unit = set(11, value)
        get(): String? = get(11) as String?

    open var actType_: String?
        set(value): Unit = set(12, value)
        get(): String? = get(12) as String?

    open var assignee_: String?
        set(value): Unit = set(13, value)
        get(): String? = get(13) as String?

    open var startTime_: LocalDateTime?
        set(value): Unit = set(14, value)
        get(): LocalDateTime? = get(14) as LocalDateTime?

    open var endTime_: LocalDateTime?
        set(value): Unit = set(15, value)
        get(): LocalDateTime? = get(15) as LocalDateTime?

    open var duration_: Long?
        set(value): Unit = set(16, value)
        get(): Long? = get(16) as Long?

    open var actInstState_: Int?
        set(value): Unit = set(17, value)
        get(): Int? = get(17) as Int?

    open var sequenceCounter_: Long?
        set(value): Unit = set(18, value)
        get(): Long? = get(18) as Long?

    open var tenantId_: String?
        set(value): Unit = set(19, value)
        get(): String? = get(19) as String?

    open var removalTime_: LocalDateTime?
        set(value): Unit = set(20, value)
        get(): LocalDateTime? = get(20) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActHiActinstRecord
     */
    constructor(
        id_: String? = null,
        parentActInstId_: String? = null,
        procDefKey_: String? = null,
        procDefId_: String? = null,
        rootProcInstId_: String? = null,
        procInstId_: String? = null,
        executionId_: String? = null,
        actId_: String? = null,
        taskId_: String? = null,
        callProcInstId_: String? = null,
        callCaseInstId_: String? = null,
        actName_: String? = null,
        actType_: String? = null,
        assignee_: String? = null,
        startTime_: LocalDateTime? = null,
        endTime_: LocalDateTime? = null,
        duration_: Long? = null,
        actInstState_: Int? = null,
        sequenceCounter_: Long? = null,
        tenantId_: String? = null,
        removalTime_: LocalDateTime? = null
    ) : this() {
        this.id_ = id_
        this.parentActInstId_ = parentActInstId_
        this.procDefKey_ = procDefKey_
        this.procDefId_ = procDefId_
        this.rootProcInstId_ = rootProcInstId_
        this.procInstId_ = procInstId_
        this.executionId_ = executionId_
        this.actId_ = actId_
        this.taskId_ = taskId_
        this.callProcInstId_ = callProcInstId_
        this.callCaseInstId_ = callCaseInstId_
        this.actName_ = actName_
        this.actType_ = actType_
        this.assignee_ = assignee_
        this.startTime_ = startTime_
        this.endTime_ = endTime_
        this.duration_ = duration_
        this.actInstState_ = actInstState_
        this.sequenceCounter_ = sequenceCounter_
        this.tenantId_ = tenantId_
        this.removalTime_ = removalTime_
        resetChangedOnNotNull()
    }
}
