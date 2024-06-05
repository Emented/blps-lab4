/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records


import emented.jooq.main.tables.QrtzCronTriggers

import org.jooq.Record3
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class QrtzCronTriggersRecord() : UpdatableRecordImpl<QrtzCronTriggersRecord>(QrtzCronTriggers.QRTZ_CRON_TRIGGERS) {

    open var schedName: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var triggerName: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var triggerGroup: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var cronExpression: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var timeZoneId: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record3<String?, String?, String?> = super.key() as Record3<String?, String?, String?>

    /**
     * Create a detached, initialised QrtzCronTriggersRecord
     */
    constructor(schedName: String? = null, triggerName: String? = null, triggerGroup: String? = null, cronExpression: String? = null, timeZoneId: String? = null): this() {
        this.schedName = schedName
        this.triggerName = triggerName
        this.triggerGroup = triggerGroup
        this.cronExpression = cronExpression
        this.timeZoneId = timeZoneId
        resetChangedOnNotNull()
    }
}