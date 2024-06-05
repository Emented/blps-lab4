/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records


import emented.jooq.main.tables.QrtzFiredTriggers

import org.jooq.Record2
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class QrtzFiredTriggersRecord() : UpdatableRecordImpl<QrtzFiredTriggersRecord>(QrtzFiredTriggers.QRTZ_FIRED_TRIGGERS) {

    open var schedName: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var entryId: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var triggerName: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var triggerGroup: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var instanceName: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var firedTime: Long?
        set(value): Unit = set(5, value)
        get(): Long? = get(5) as Long?

    open var schedTime: Long?
        set(value): Unit = set(6, value)
        get(): Long? = get(6) as Long?

    open var priority: Int?
        set(value): Unit = set(7, value)
        get(): Int? = get(7) as Int?

    open var state: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var jobName: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var jobGroup: String?
        set(value): Unit = set(10, value)
        get(): String? = get(10) as String?

    @Suppress("INAPPLICABLE_JVM_NAME")
    @set:JvmName("setIsNonconcurrent")
    open var isNonconcurrent: Boolean?
        set(value): Unit = set(11, value)
        get(): Boolean? = get(11) as Boolean?

    open var requestsRecovery: Boolean?
        set(value): Unit = set(12, value)
        get(): Boolean? = get(12) as Boolean?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record2<String?, String?> = super.key() as Record2<String?, String?>

    /**
     * Create a detached, initialised QrtzFiredTriggersRecord
     */
    constructor(schedName: String? = null, entryId: String? = null, triggerName: String? = null, triggerGroup: String? = null, instanceName: String? = null, firedTime: Long? = null, schedTime: Long? = null, priority: Int? = null, state: String? = null, jobName: String? = null, jobGroup: String? = null, isNonconcurrent: Boolean? = null, requestsRecovery: Boolean? = null): this() {
        this.schedName = schedName
        this.entryId = entryId
        this.triggerName = triggerName
        this.triggerGroup = triggerGroup
        this.instanceName = instanceName
        this.firedTime = firedTime
        this.schedTime = schedTime
        this.priority = priority
        this.state = state
        this.jobName = jobName
        this.jobGroup = jobGroup
        this.isNonconcurrent = isNonconcurrent
        this.requestsRecovery = requestsRecovery
        resetChangedOnNotNull()
    }
}
