/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables.records

import emented.jooq.main.tables.Films
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FilmsRecord() : UpdatableRecordImpl<FilmsRecord>(Films.FILMS) {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var averageScore: Double?
        set(value): Unit = set(1, value)
        get(): Double? = get(1) as Double?

    open var description: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    open var lastViewedTime: LocalDateTime?
        set(value): Unit = set(3, value)
        get(): LocalDateTime? = get(3) as LocalDateTime?

    open var name: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    open var updateTime: LocalDateTime?
        set(value): Unit = set(5, value)
        get(): LocalDateTime? = get(5) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised FilmsRecord
     */
    constructor(
        id: Int? = null,
        averageScore: Double? = null,
        description: String? = null,
        lastViewedTime: LocalDateTime? = null,
        name: String? = null,
        updateTime: LocalDateTime? = null
    ) : this() {
        this.id = id
        this.averageScore = averageScore
        this.description = description
        this.lastViewedTime = lastViewedTime
        this.name = name
        this.updateTime = updateTime
        resetChangedOnNotNull()
    }
}
