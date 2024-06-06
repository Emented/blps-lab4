/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActHiDecOut
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiDecOutRecord() : UpdatableRecordImpl<ActHiDecOutRecord>(ActHiDecOut.ACT_HI_DEC_OUT) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var decInstId_: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var clauseId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var clauseName_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var ruleId_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var ruleOrder_: Int?
        set(value): Unit = set(5, value)
        get(): Int? = get(5) as Int?

    open var varName_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var varType_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var bytearrayId_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var double_: Double?
        set(value): Unit = set(9, value)
        get(): Double? = get(9) as Double?

    open var long_: Long?
        set(value): Unit = set(10, value)
        get(): Long? = get(10) as Long?

    open var text_: String?
        set(value): Unit = set(11, value)
        get(): String? = get(11) as String?

    open var text2_: String?
        set(value): Unit = set(12, value)
        get(): String? = get(12) as String?

    open var tenantId_: String?
        set(value): Unit = set(13, value)
        get(): String? = get(13) as String?

    open var createTime_: LocalDateTime?
        set(value): Unit = set(14, value)
        get(): LocalDateTime? = get(14) as LocalDateTime?

    open var rootProcInstId_: String?
        set(value): Unit = set(15, value)
        get(): String? = get(15) as String?

    open var removalTime_: LocalDateTime?
        set(value): Unit = set(16, value)
        get(): LocalDateTime? = get(16) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActHiDecOutRecord
     */
    constructor(
        id_: String? = null,
        decInstId_: String? = null,
        clauseId_: String? = null,
        clauseName_: String? = null,
        ruleId_: String? = null,
        ruleOrder_: Int? = null,
        varName_: String? = null,
        varType_: String? = null,
        bytearrayId_: String? = null,
        double_: Double? = null,
        long_: Long? = null,
        text_: String? = null,
        text2_: String? = null,
        tenantId_: String? = null,
        createTime_: LocalDateTime? = null,
        rootProcInstId_: String? = null,
        removalTime_: LocalDateTime? = null
    ) : this() {
        this.id_ = id_
        this.decInstId_ = decInstId_
        this.clauseId_ = clauseId_
        this.clauseName_ = clauseName_
        this.ruleId_ = ruleId_
        this.ruleOrder_ = ruleOrder_
        this.varName_ = varName_
        this.varType_ = varType_
        this.bytearrayId_ = bytearrayId_
        this.double_ = double_
        this.long_ = long_
        this.text_ = text_
        this.text2_ = text2_
        this.tenantId_ = tenantId_
        this.createTime_ = createTime_
        this.rootProcInstId_ = rootProcInstId_
        this.removalTime_ = removalTime_
        resetChangedOnNotNull()
    }
}