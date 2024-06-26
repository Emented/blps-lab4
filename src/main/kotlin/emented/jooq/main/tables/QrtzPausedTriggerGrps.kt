/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.keys.QRTZ_PAUSED_TRIGGER_GRPS_PKEY
import emented.jooq.main.tables.records.QrtzPausedTriggerGrpsRecord
import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class QrtzPausedTriggerGrps(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, QrtzPausedTriggerGrpsRecord>?,
    parentPath: InverseForeignKey<out Record, QrtzPausedTriggerGrpsRecord>?,
    aliased: Table<QrtzPausedTriggerGrpsRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<QrtzPausedTriggerGrpsRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of
         * <code>public.qrtz_paused_trigger_grps</code>
         */
        val QRTZ_PAUSED_TRIGGER_GRPS: QrtzPausedTriggerGrps = QrtzPausedTriggerGrps()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<QrtzPausedTriggerGrpsRecord> = QrtzPausedTriggerGrpsRecord::class.java

    /**
     * The column <code>public.qrtz_paused_trigger_grps.sched_name</code>.
     */
    val SCHED_NAME: TableField<QrtzPausedTriggerGrpsRecord, String?> =
        createField(DSL.name("sched_name"), SQLDataType.VARCHAR(120).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_paused_trigger_grps.trigger_group</code>.
     */
    val TRIGGER_GROUP: TableField<QrtzPausedTriggerGrpsRecord, String?> =
        createField(DSL.name("trigger_group"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<QrtzPausedTriggerGrpsRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(
        alias: Name,
        aliased: Table<QrtzPausedTriggerGrpsRecord>?,
        parameters: Array<Field<*>?>?
    ) : this(alias, null, null, null, aliased, parameters, null)

    private constructor(alias: Name, aliased: Table<QrtzPausedTriggerGrpsRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.qrtz_paused_trigger_grps</code> table
     * reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.qrtz_paused_trigger_grps</code> table
     * reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.qrtz_paused_trigger_grps</code> table reference
     */
    constructor() : this(DSL.name("qrtz_paused_trigger_grps"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<QrtzPausedTriggerGrpsRecord> = QRTZ_PAUSED_TRIGGER_GRPS_PKEY
    override fun `as`(alias: String): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(DSL.name(alias), this)
    override fun `as`(alias: Name): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(alias, this)
    override fun `as`(alias: Table<*>): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): QrtzPausedTriggerGrps = QrtzPausedTriggerGrps(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): QrtzPausedTriggerGrps =
        QrtzPausedTriggerGrps(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): QrtzPausedTriggerGrps = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): QrtzPausedTriggerGrps = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): QrtzPausedTriggerGrps = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): QrtzPausedTriggerGrps = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): QrtzPausedTriggerGrps = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): QrtzPausedTriggerGrps =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): QrtzPausedTriggerGrps =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): QrtzPausedTriggerGrps = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): QrtzPausedTriggerGrps = where(DSL.notExists(select))
}
