/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.ActHiAttachment
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiAttachmentRecord() : UpdatableRecordImpl<ActHiAttachmentRecord>(ActHiAttachment.ACT_HI_ATTACHMENT) {

    open var id_: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var rev_: Int?
        set(value): Unit = set(1, value)
        get(): Int? = get(1) as Int?

    open var userId_: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var name_: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    open var description_: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var type_: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    open var taskId_: String?
        set(value): Unit = set(6, value)
        get(): String? = get(6) as String?

    open var rootProcInstId_: String?
        set(value): Unit = set(7, value)
        get(): String? = get(7) as String?

    open var procInstId_: String?
        set(value): Unit = set(8, value)
        get(): String? = get(8) as String?

    open var url_: String?
        set(value): Unit = set(9, value)
        get(): String? = get(9) as String?

    open var contentId_: String?
        set(value): Unit = set(10, value)
        get(): String? = get(10) as String?

    open var tenantId_: String?
        set(value): Unit = set(11, value)
        get(): String? = get(11) as String?

    open var createTime_: LocalDateTime?
        set(value): Unit = set(12, value)
        get(): LocalDateTime? = get(12) as LocalDateTime?

    open var removalTime_: LocalDateTime?
        set(value): Unit = set(13, value)
        get(): LocalDateTime? = get(13) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<String?> = super.key() as Record1<String?>

    /**
     * Create a detached, initialised ActHiAttachmentRecord
     */
    constructor(
        id_: String? = null,
        rev_: Int? = null,
        userId_: String? = null,
        name_: String? = null,
        description_: String? = null,
        type_: String? = null,
        taskId_: String? = null,
        rootProcInstId_: String? = null,
        procInstId_: String? = null,
        url_: String? = null,
        contentId_: String? = null,
        tenantId_: String? = null,
        createTime_: LocalDateTime? = null,
        removalTime_: LocalDateTime? = null
    ) : this() {
        this.id_ = id_
        this.rev_ = rev_
        this.userId_ = userId_
        this.name_ = name_
        this.description_ = description_
        this.type_ = type_
        this.taskId_ = taskId_
        this.rootProcInstId_ = rootProcInstId_
        this.procInstId_ = procInstId_
        this.url_ = url_
        this.contentId_ = contentId_
        this.tenantId_ = tenantId_
        this.createTime_ = createTime_
        this.removalTime_ = removalTime_
        resetChangedOnNotNull()
    }
}