/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActRuTask
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActRuTaskRecord() : UpdatableRecordImpl<ActRuTaskRecord>(ActRuTask.ACT_RU_TASK) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var executionId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var procInstId_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var procDefId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var caseExecutionId_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var caseInstId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var caseDefId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var name_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var parentTaskId_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var description_: String?
        set(value): Unit = set(10, value)
        get(): String? = get(10) as String?

    open var taskDefKey_: String?
        set(value): Unit = set(11, value)
        get(): String? = get(11) as String?

    open var owner_: String?
        set(value): Unit = set(12, value)
        get(): String? = get(12) as String?

    open var assignee_: String?
        set(value): Unit = set(13, value)
        get(): String? = get(13) as String?

    open var delegation_: String?
        set(value): Unit = set(14, value)
        get(): String? = get(14) as String?

    open var priority_: Int?
        set(value): Unit = set(15, value)
        get(): Int? = get(15) as Int?

    open var createTime_: LocalDateTime?
        set(value): Unit = set(16, value)
        get(): LocalDateTime? = get(16) as LocalDateTime?

    open var lastUpdated_: LocalDateTime?
        set(value): Unit = set(17, value)
        get(): LocalDateTime? = get(17) as LocalDateTime?

    open var dueDate_: LocalDateTime?
        set(value): Unit = set(18, value)
        get(): LocalDateTime? = get(18) as LocalDateTime?

    open var followUpDate_: LocalDateTime?
        set(value): Unit = set(19, value)
        get(): LocalDateTime? = get(19) as LocalDateTime?

    open var suspensionState_: Int?
        set(value): Unit = set(20, value)
        get(): Int? = get(20) as Int?

    open var tenantId_: String?
        set(value): Unit = set(21, value)
        get(): String? = get(21) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActRuTaskRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        executionId_: String? = null,
        procInstId_: String? = null,
        procDefId_: String? = null,
        caseExecutionId_: String? = null,
        caseInstId_: String? = null,
        caseDefId_: String? = null,
        name_: String? = null,
        parentTaskId_: String? = null,
        description_: String? = null,
        taskDefKey_: String? = null,
        owner_: String? = null,
        assignee_: String? = null,
        delegation_: String? = null,
        priority_: Int? = null,
        createTime_: LocalDateTime? = null,
        lastUpdated_: LocalDateTime? = null,
        dueDate_: LocalDateTime? = null,
        followUpDate_: LocalDateTime? = null,
        suspensionState_: Int? = null,
        tenantId_: String? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.executionId_ = executionId_
        this.procInstId_ = procInstId_
        this.procDefId_ = procDefId_
        this.caseExecutionId_ = caseExecutionId_
        this.caseInstId_ = caseInstId_
        this.caseDefId_ = caseDefId_
        this.name_ = name_
        this.parentTaskId_ = parentTaskId_
        this.description_ = description_
        this.taskDefKey_ = taskDefKey_
        this.owner_ = owner_
        this.assignee_ = assignee_
        this.delegation_ = delegation_
        this.priority_ = priority_
        this.createTime_ = createTime_
        this.lastUpdated_ = lastUpdated_
        this.dueDate_ = dueDate_
        this.followUpDate_ = followUpDate_
        this.suspensionState_ = suspensionState_
        this.tenantId_ = tenantId_
        resetChangedOnNotNull()
    }
}