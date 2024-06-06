/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActHiBatch
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiBatchRecord() : UpdatableRecordImpl<ActHiBatchRecord>(ActHiBatch.ACT_HI_BATCH) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var type_: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var totalJobs_: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    open var jobsPerSeed_: Int?
        set(value): Unit = set(3, value)
        get(): Int? = get(3) as Int?

    open var invocationsPerJob_: Int?
        set(value): Unit = set(4, value)
        get(): Int? = get(4) as Int?

    open var seedJobDefId_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var monitorJobDefId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var batchJobDefId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var tenantId_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var createUserId_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var startTime_: LocalDateTime?
        set(value): Unit = set(10, value)
        get(): LocalDateTime? = get(10) as LocalDateTime?

    open var endTime_: LocalDateTime?
        set(value): Unit = set(11, value)
        get(): LocalDateTime? = get(11) as LocalDateTime?

    open var removalTime_: LocalDateTime?
        set(value): Unit = set(12, value)
        get(): LocalDateTime? = get(12) as LocalDateTime?

    open var execStartTime_: LocalDateTime?
        set(value): Unit = set(13, value)
        get(): LocalDateTime? = get(13) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActHiBatchRecord
     */
    constructor(
        id_: String? = null,
        type_: String? = null,
        totalJobs_: Int? = null,
        jobsPerSeed_: Int? = null,
        invocationsPerJob_: Int? = null,
        seedJobDefId_: String? = null,
        monitorJobDefId_: String? = null,
        batchJobDefId_: String? = null,
        tenantId_: String? = null,
        createUserId_: String? = null,
        startTime_: LocalDateTime? = null,
        endTime_: LocalDateTime? = null,
        removalTime_: LocalDateTime? = null,
        execStartTime_: LocalDateTime? = null
    ) : this() {
        this.id_ = id_
        this.type_ = type_
        this.totalJobs_ = totalJobs_
        this.jobsPerSeed_ = jobsPerSeed_
        this.invocationsPerJob_ = invocationsPerJob_
        this.seedJobDefId_ = seedJobDefId_
        this.monitorJobDefId_ = monitorJobDefId_
        this.batchJobDefId_ = batchJobDefId_
        this.tenantId_ = tenantId_
        this.createUserId_ = createUserId_
        this.startTime_ = startTime_
        this.endTime_ = endTime_
        this.removalTime_ = removalTime_
        this.execStartTime_ = execStartTime_
        resetChangedOnNotNull()
    }
}
