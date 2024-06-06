/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_ENTITY_TYPE
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_OP_TYPE
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_PROCDEF
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_PROCINST
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_ROOT_PI
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_TASK
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_TIMESTAMP
import emented.jooq.main.indexes.ACT_IDX_HI_OP_LOG_USER_ID
import emented.jooq.main.keys.ACT_HI_OP_LOG_PKEY
import emented.jooq.main.tables.records.ActHiOpLogRecord
import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Index
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
import java.time.LocalDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiOpLog(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiOpLogRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiOpLogRecord>?,
    aliased: Table<ActHiOpLogRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiOpLogRecord>(
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
         * The reference instance of <code>public.act_hi_op_log</code>
         */
        val ACT_HI_OP_LOG: ActHiOpLog = ActHiOpLog()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiOpLogRecord> = ActHiOpLogRecord::class.java

    /**
     * The column <code>public.act_hi_op_log.id_</code>.
     */
    val ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_op_log.deployment_id_</code>.
     */
    val DEPLOYMENT_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("deployment_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.proc_def_id_</code>.
     */
    val PROC_DEF_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("proc_def_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.proc_def_key_</code>.
     */
    val PROC_DEF_KEY_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("proc_def_key_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_op_log.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.proc_inst_id_</code>.
     */
    val PROC_INST_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.execution_id_</code>.
     */
    val EXECUTION_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("execution_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.case_def_id_</code>.
     */
    val CASE_DEF_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("case_def_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.case_inst_id_</code>.
     */
    val CASE_INST_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("case_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.case_execution_id_</code>.
     */
    val CASE_EXECUTION_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("case_execution_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.task_id_</code>.
     */
    val TASK_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("task_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.job_id_</code>.
     */
    val JOB_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("job_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.job_def_id_</code>.
     */
    val JOB_DEF_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("job_def_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.batch_id_</code>.
     */
    val BATCH_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("batch_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.user_id_</code>.
     */
    val USER_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("user_id_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_op_log.timestamp_</code>.
     */
    val TIMESTAMP_: TableField<ActHiOpLogRecord, LocalDateTime?> =
        createField(DSL.name("timestamp_"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_op_log.operation_type_</code>.
     */
    val OPERATION_TYPE_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("operation_type_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.operation_id_</code>.
     */
    val OPERATION_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("operation_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.entity_type_</code>.
     */
    val ENTITY_TYPE_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("entity_type_"), SQLDataType.VARCHAR(30), this, "")

    /**
     * The column <code>public.act_hi_op_log.property_</code>.
     */
    val PROPERTY_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("property_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.org_value_</code>.
     */
    val ORG_VALUE_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("org_value_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_op_log.new_value_</code>.
     */
    val NEW_VALUE_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("new_value_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_op_log.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiOpLogRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_op_log.category_</code>.
     */
    val CATEGORY_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("category_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.external_task_id_</code>.
     */
    val EXTERNAL_TASK_ID_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("external_task_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_op_log.annotation_</code>.
     */
    val ANNOTATION_: TableField<ActHiOpLogRecord, String?> =
        createField(DSL.name("annotation_"), SQLDataType.VARCHAR(4000), this, "")

    private constructor(alias: Name, aliased: Table<ActHiOpLogRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiOpLogRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiOpLogRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_op_log</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_op_log</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_op_log</code> table reference
     */
    constructor() : this(DSL.name("act_hi_op_log"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(
        ACT_IDX_HI_OP_LOG_ENTITY_TYPE,
        ACT_IDX_HI_OP_LOG_OP_TYPE,
        ACT_IDX_HI_OP_LOG_PROCDEF,
        ACT_IDX_HI_OP_LOG_PROCINST,
        ACT_IDX_HI_OP_LOG_RM_TIME,
        ACT_IDX_HI_OP_LOG_ROOT_PI,
        ACT_IDX_HI_OP_LOG_TASK,
        ACT_IDX_HI_OP_LOG_TIMESTAMP,
        ACT_IDX_HI_OP_LOG_USER_ID
    )

    override fun getPrimaryKey(): UniqueKey<ActHiOpLogRecord> = ACT_HI_OP_LOG_PKEY
    override fun `as`(alias: String): ActHiOpLog = ActHiOpLog(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiOpLog = ActHiOpLog(alias, this)
    override fun `as`(alias: Table<*>): ActHiOpLog = ActHiOpLog(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiOpLog = ActHiOpLog(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiOpLog = ActHiOpLog(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiOpLog = ActHiOpLog(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiOpLog =
        ActHiOpLog(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiOpLog = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiOpLog = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiOpLog = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiOpLog = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiOpLog = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiOpLog =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiOpLog =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiOpLog = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiOpLog = where(DSL.notExists(select))
}