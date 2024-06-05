/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables


import emented.jooq.main.Public
import emented.jooq.main.indexes.IDX_QRTZ_T_C
import emented.jooq.main.indexes.IDX_QRTZ_T_G
import emented.jooq.main.indexes.IDX_QRTZ_T_J
import emented.jooq.main.indexes.IDX_QRTZ_T_JG
import emented.jooq.main.indexes.IDX_QRTZ_T_NEXT_FIRE_TIME
import emented.jooq.main.indexes.IDX_QRTZ_T_NFT_MISFIRE
import emented.jooq.main.indexes.IDX_QRTZ_T_NFT_ST
import emented.jooq.main.indexes.IDX_QRTZ_T_NFT_ST_MISFIRE
import emented.jooq.main.indexes.IDX_QRTZ_T_NFT_ST_MISFIRE_GRP
import emented.jooq.main.indexes.IDX_QRTZ_T_N_G_STATE
import emented.jooq.main.indexes.IDX_QRTZ_T_N_STATE
import emented.jooq.main.indexes.IDX_QRTZ_T_STATE
import emented.jooq.main.keys.QRTZ_BLOB_TRIGGERS__QRTZ_BLOB_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY
import emented.jooq.main.keys.QRTZ_CRON_TRIGGERS__QRTZ_CRON_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY
import emented.jooq.main.keys.QRTZ_SIMPLE_TRIGGERS__QRTZ_SIMPLE_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY
import emented.jooq.main.keys.QRTZ_SIMPROP_TRIGGERS__QRTZ_SIMPROP_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROU_FKEY
import emented.jooq.main.keys.QRTZ_TRIGGERS_PKEY
import emented.jooq.main.keys.QRTZ_TRIGGERS__QRTZ_TRIGGERS_SCHED_NAME_JOB_NAME_JOB_GROUP_FKEY
import emented.jooq.main.tables.QrtzBlobTriggers.QrtzBlobTriggersPath
import emented.jooq.main.tables.QrtzCronTriggers.QrtzCronTriggersPath
import emented.jooq.main.tables.QrtzJobDetails.QrtzJobDetailsPath
import emented.jooq.main.tables.QrtzSimpleTriggers.QrtzSimpleTriggersPath
import emented.jooq.main.tables.QrtzSimpropTriggers.QrtzSimpropTriggersPath
import emented.jooq.main.tables.records.QrtzTriggersRecord

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Index
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
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
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class QrtzTriggers(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, QrtzTriggersRecord>?,
    parentPath: InverseForeignKey<out Record, QrtzTriggersRecord>?,
    aliased: Table<QrtzTriggersRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<QrtzTriggersRecord>(
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
         * The reference instance of <code>public.qrtz_triggers</code>
         */
        val QRTZ_TRIGGERS: QrtzTriggers = QrtzTriggers()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<QrtzTriggersRecord> = QrtzTriggersRecord::class.java

    /**
     * The column <code>public.qrtz_triggers.sched_name</code>.
     */
    val SCHED_NAME: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("sched_name"), SQLDataType.VARCHAR(120).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.trigger_name</code>.
     */
    val TRIGGER_NAME: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("trigger_name"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.trigger_group</code>.
     */
    val TRIGGER_GROUP: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("trigger_group"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.job_name</code>.
     */
    val JOB_NAME: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("job_name"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.job_group</code>.
     */
    val JOB_GROUP: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("job_group"), SQLDataType.VARCHAR(200).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.description</code>.
     */
    val DESCRIPTION: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("description"), SQLDataType.VARCHAR(250), this, "")

    /**
     * The column <code>public.qrtz_triggers.next_fire_time</code>.
     */
    val NEXT_FIRE_TIME: TableField<QrtzTriggersRecord, Long?> = createField(DSL.name("next_fire_time"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.qrtz_triggers.prev_fire_time</code>.
     */
    val PREV_FIRE_TIME: TableField<QrtzTriggersRecord, Long?> = createField(DSL.name("prev_fire_time"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.qrtz_triggers.priority</code>.
     */
    val PRIORITY: TableField<QrtzTriggersRecord, Int?> = createField(DSL.name("priority"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.qrtz_triggers.trigger_state</code>.
     */
    val TRIGGER_STATE: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("trigger_state"), SQLDataType.VARCHAR(16).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.trigger_type</code>.
     */
    val TRIGGER_TYPE: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("trigger_type"), SQLDataType.VARCHAR(8).nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.start_time</code>.
     */
    val START_TIME: TableField<QrtzTriggersRecord, Long?> = createField(DSL.name("start_time"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.qrtz_triggers.end_time</code>.
     */
    val END_TIME: TableField<QrtzTriggersRecord, Long?> = createField(DSL.name("end_time"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.qrtz_triggers.calendar_name</code>.
     */
    val CALENDAR_NAME: TableField<QrtzTriggersRecord, String?> = createField(DSL.name("calendar_name"), SQLDataType.VARCHAR(200), this, "")

    /**
     * The column <code>public.qrtz_triggers.misfire_instr</code>.
     */
    val MISFIRE_INSTR: TableField<QrtzTriggersRecord, Short?> = createField(DSL.name("misfire_instr"), SQLDataType.SMALLINT, this, "")

    /**
     * The column <code>public.qrtz_triggers.job_data</code>.
     */
    val JOB_DATA: TableField<QrtzTriggersRecord, ByteArray?> = createField(DSL.name("job_data"), SQLDataType.BLOB, this, "")

    private constructor(alias: Name, aliased: Table<QrtzTriggersRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<QrtzTriggersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<QrtzTriggersRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.qrtz_triggers</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.qrtz_triggers</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.qrtz_triggers</code> table reference
     */
    constructor(): this(DSL.name("qrtz_triggers"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, QrtzTriggersRecord>?, parentPath: InverseForeignKey<out Record, QrtzTriggersRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, QRTZ_TRIGGERS, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class QrtzTriggersPath : QrtzTriggers, Path<QrtzTriggersRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, QrtzTriggersRecord>?, parentPath: InverseForeignKey<out Record, QrtzTriggersRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<QrtzTriggersRecord>): super(alias, aliased)
        override fun `as`(alias: String): QrtzTriggersPath = QrtzTriggersPath(DSL.name(alias), this)
        override fun `as`(alias: Name): QrtzTriggersPath = QrtzTriggersPath(alias, this)
        override fun `as`(alias: Table<*>): QrtzTriggersPath = QrtzTriggersPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(IDX_QRTZ_T_C, IDX_QRTZ_T_G, IDX_QRTZ_T_J, IDX_QRTZ_T_JG, IDX_QRTZ_T_N_G_STATE, IDX_QRTZ_T_N_STATE, IDX_QRTZ_T_NEXT_FIRE_TIME, IDX_QRTZ_T_NFT_MISFIRE, IDX_QRTZ_T_NFT_ST, IDX_QRTZ_T_NFT_ST_MISFIRE, IDX_QRTZ_T_NFT_ST_MISFIRE_GRP, IDX_QRTZ_T_STATE)
    override fun getPrimaryKey(): UniqueKey<QrtzTriggersRecord> = QRTZ_TRIGGERS_PKEY
    override fun getReferences(): List<ForeignKey<QrtzTriggersRecord, *>> = listOf(QRTZ_TRIGGERS__QRTZ_TRIGGERS_SCHED_NAME_JOB_NAME_JOB_GROUP_FKEY)

    private lateinit var _qrtzJobDetails: QrtzJobDetailsPath

    /**
     * Get the implicit join path to the <code>public.qrtz_job_details</code>
     * table.
     */
    fun qrtzJobDetails(): QrtzJobDetailsPath {
        if (!this::_qrtzJobDetails.isInitialized)
            _qrtzJobDetails = QrtzJobDetailsPath(this, QRTZ_TRIGGERS__QRTZ_TRIGGERS_SCHED_NAME_JOB_NAME_JOB_GROUP_FKEY, null)

        return _qrtzJobDetails;
    }

    val qrtzJobDetails: QrtzJobDetailsPath
        get(): QrtzJobDetailsPath = qrtzJobDetails()

    private lateinit var _qrtzBlobTriggers: QrtzBlobTriggersPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.qrtz_blob_triggers</code> table
     */
    fun qrtzBlobTriggers(): QrtzBlobTriggersPath {
        if (!this::_qrtzBlobTriggers.isInitialized)
            _qrtzBlobTriggers = QrtzBlobTriggersPath(this, null, QRTZ_BLOB_TRIGGERS__QRTZ_BLOB_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY.inverseKey)

        return _qrtzBlobTriggers;
    }

    val qrtzBlobTriggers: QrtzBlobTriggersPath
        get(): QrtzBlobTriggersPath = qrtzBlobTriggers()

    private lateinit var _qrtzCronTriggers: QrtzCronTriggersPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.qrtz_cron_triggers</code> table
     */
    fun qrtzCronTriggers(): QrtzCronTriggersPath {
        if (!this::_qrtzCronTriggers.isInitialized)
            _qrtzCronTriggers = QrtzCronTriggersPath(this, null, QRTZ_CRON_TRIGGERS__QRTZ_CRON_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY.inverseKey)

        return _qrtzCronTriggers;
    }

    val qrtzCronTriggers: QrtzCronTriggersPath
        get(): QrtzCronTriggersPath = qrtzCronTriggers()

    private lateinit var _qrtzSimpleTriggers: QrtzSimpleTriggersPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.qrtz_simple_triggers</code> table
     */
    fun qrtzSimpleTriggers(): QrtzSimpleTriggersPath {
        if (!this::_qrtzSimpleTriggers.isInitialized)
            _qrtzSimpleTriggers = QrtzSimpleTriggersPath(this, null, QRTZ_SIMPLE_TRIGGERS__QRTZ_SIMPLE_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROUP_FKEY.inverseKey)

        return _qrtzSimpleTriggers;
    }

    val qrtzSimpleTriggers: QrtzSimpleTriggersPath
        get(): QrtzSimpleTriggersPath = qrtzSimpleTriggers()

    private lateinit var _qrtzSimpropTriggers: QrtzSimpropTriggersPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.qrtz_simprop_triggers</code> table
     */
    fun qrtzSimpropTriggers(): QrtzSimpropTriggersPath {
        if (!this::_qrtzSimpropTriggers.isInitialized)
            _qrtzSimpropTriggers = QrtzSimpropTriggersPath(this, null, QRTZ_SIMPROP_TRIGGERS__QRTZ_SIMPROP_TRIGGERS_SCHED_NAME_TRIGGER_NAME_TRIGGER_GROU_FKEY.inverseKey)

        return _qrtzSimpropTriggers;
    }

    val qrtzSimpropTriggers: QrtzSimpropTriggersPath
        get(): QrtzSimpropTriggersPath = qrtzSimpropTriggers()
    override fun `as`(alias: String): QrtzTriggers = QrtzTriggers(DSL.name(alias), this)
    override fun `as`(alias: Name): QrtzTriggers = QrtzTriggers(alias, this)
    override fun `as`(alias: Table<*>): QrtzTriggers = QrtzTriggers(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): QrtzTriggers = QrtzTriggers(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): QrtzTriggers = QrtzTriggers(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): QrtzTriggers = QrtzTriggers(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): QrtzTriggers = QrtzTriggers(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): QrtzTriggers = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): QrtzTriggers = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): QrtzTriggers = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): QrtzTriggers = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): QrtzTriggers = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): QrtzTriggers = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): QrtzTriggers = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): QrtzTriggers = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): QrtzTriggers = where(DSL.notExists(select))
}
