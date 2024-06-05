/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables


import emented.jooq.main.Public
import emented.jooq.main.keys.QRTZ_CALENDARS_PKEY
import emented.jooq.main.tables.records.QrtzCalendarsRecord

import kotlin.collections.Collection

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
open class QrtzCalendars(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, QrtzCalendarsRecord>?,
    parentPath: InverseForeignKey<out Record, QrtzCalendarsRecord>?,
    aliased: Table<QrtzCalendarsRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<QrtzCalendarsRecord>(
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
         * The reference instance of <code>public.qrtz_calendars</code>
         */
        val QRTZ_CALENDARS: QrtzCalendars = QrtzCalendars()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<QrtzCalendarsRecord> = QrtzCalendarsRecord::class.java

    /**
     * The column <code>public.qrtz_calendars.sched_name</code>.
     */
    val SCHED_NAME: TableField<QrtzCalendarsRecord, String?> = createField(DSL.name("sched_name"), SQLDataType.VARCHAR(120).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_calendars.calendar_name</code>.
     */
    val CALENDAR_NAME: TableField<QrtzCalendarsRecord, String?> = createField(DSL.name("calendar_name"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_calendars.calendar</code>.
     */
    val CALENDAR: TableField<QrtzCalendarsRecord, ByteArray?> = createField(DSL.name("calendar"), SQLDataType.BLOB.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<QrtzCalendarsRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<QrtzCalendarsRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<QrtzCalendarsRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.qrtz_calendars</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.qrtz_calendars</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.qrtz_calendars</code> table reference
     */
    constructor(): this(DSL.name("qrtz_calendars"), null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<QrtzCalendarsRecord> = QRTZ_CALENDARS_PKEY
    override fun `as`(alias: String): QrtzCalendars = QrtzCalendars(DSL.name(alias), this)
    override fun `as`(alias: Name): QrtzCalendars = QrtzCalendars(alias, this)
    override fun `as`(alias: Table<*>): QrtzCalendars = QrtzCalendars(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): QrtzCalendars = QrtzCalendars(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): QrtzCalendars = QrtzCalendars(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): QrtzCalendars = QrtzCalendars(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): QrtzCalendars = QrtzCalendars(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): QrtzCalendars = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): QrtzCalendars = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): QrtzCalendars = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): QrtzCalendars = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): QrtzCalendars = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): QrtzCalendars = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): QrtzCalendars = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): QrtzCalendars = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): QrtzCalendars = where(DSL.notExists(select))
}
