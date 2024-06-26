/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActRuTaskMeterLog
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActRuTaskMeterLogRecord() :
    UpdatableRecordImpl<ActRuTaskMeterLogRecord>(ActRuTaskMeterLog.ACT_RU_TASK_METER_LOG) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var assigneeHash_: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var timestamp_: LocalDateTime?
        set(value): Unit = set(2, value)
        get(): LocalDateTime? = get(2) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActRuTaskMeterLogRecord
     */
    constructor(id_: String? = null, assigneeHash_: Long? = null, timestamp_: LocalDateTime? = null) : this() {
        this.id_ = id_
        this.assigneeHash_ = assigneeHash_
        this.timestamp_ = timestamp_
        resetChangedOnNotNull()
    }
}
