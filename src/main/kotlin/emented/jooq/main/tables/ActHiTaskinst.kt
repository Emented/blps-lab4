/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_TASKINSTID_PROCINST
import emented.jooq.main.indexes.ACT_IDX_HI_TASKINST_PROCINST
import emented.jooq.main.indexes.ACT_IDX_HI_TASKINST_ROOT_PI
import emented.jooq.main.indexes.ACT_IDX_HI_TASK_INST_END
import emented.jooq.main.indexes.ACT_IDX_HI_TASK_INST_PROC_DEF_KEY
import emented.jooq.main.indexes.ACT_IDX_HI_TASK_INST_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_TASK_INST_START
import emented.jooq.main.indexes.ACT_IDX_HI_TASK_INST_TENANT_ID
import emented.jooq.main.keys.ACT_HI_TASKINST_PKEY
import emented.jooq.main.tables.records.ActHiTaskinstRecord

import java.time.LocalDateTime

import kotlin.collections.Collection
import kotlin.collections.List

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

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class ActHiTaskinst(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiTaskinstRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiTaskinstRecord>?,
    aliased: Table<ActHiTaskinstRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiTaskinstRecord>(
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
         * The reference instance of <code>public.act_hi_taskinst</code>
         */
        val ACT_HI_TASKINST: ActHiTaskinst = ActHiTaskinst()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiTaskinstRecord> = ActHiTaskinstRecord::class.java

    /**
     * The column <code>public.act_hi_taskinst.id_</code>.
     */
    val ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_taskinst.task_def_key_</code>.
     */
    val TASK_DEF_KEY_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("task_def_key_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.proc_def_key_</code>.
     */
    val PROC_DEF_KEY_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("proc_def_key_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.proc_def_id_</code>.
     */
    val PROC_DEF_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("proc_def_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.proc_inst_id_</code>.
     */
    val PROC_INST_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.execution_id_</code>.
     */
    val EXECUTION_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("execution_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.case_def_key_</code>.
     */
    val CASE_DEF_KEY_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("case_def_key_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.case_def_id_</code>.
     */
    val CASE_DEF_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("case_def_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.case_inst_id_</code>.
     */
    val CASE_INST_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("case_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.case_execution_id_</code>.
     */
    val CASE_EXECUTION_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("case_execution_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.act_inst_id_</code>.
     */
    val ACT_INST_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("act_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.name_</code>.
     */
    val NAME_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.parent_task_id_</code>.
     */
    val PARENT_TASK_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("parent_task_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.description_</code>.
     */
    val DESCRIPTION_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("description_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_taskinst.owner_</code>.
     */
    val OWNER_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("owner_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.assignee_</code>.
     */
    val ASSIGNEE_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("assignee_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_taskinst.start_time_</code>.
     */
    val START_TIME_: TableField<ActHiTaskinstRecord, LocalDateTime?> =
        createField(DSL.name("start_time_"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_taskinst.end_time_</code>.
     */
    val END_TIME_: TableField<ActHiTaskinstRecord, LocalDateTime?> =
        createField(DSL.name("end_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_taskinst.duration_</code>.
     */
    val DURATION_: TableField<ActHiTaskinstRecord, Long?> =
        createField(DSL.name("duration_"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.act_hi_taskinst.delete_reason_</code>.
     */
    val DELETE_REASON_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("delete_reason_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_taskinst.priority_</code>.
     */
    val PRIORITY_: TableField<ActHiTaskinstRecord, Int?> =
        createField(DSL.name("priority_"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.act_hi_taskinst.due_date_</code>.
     */
    val DUE_DATE_: TableField<ActHiTaskinstRecord, LocalDateTime?> =
        createField(DSL.name("due_date_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_taskinst.follow_up_date_</code>.
     */
    val FOLLOW_UP_DATE_: TableField<ActHiTaskinstRecord, LocalDateTime?> =
        createField(DSL.name("follow_up_date_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_taskinst.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiTaskinstRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_taskinst.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiTaskinstRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<ActHiTaskinstRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiTaskinstRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiTaskinstRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_taskinst</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_taskinst</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_taskinst</code> table reference
     */
    constructor() : this(DSL.name("act_hi_taskinst"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(
        ACT_IDX_HI_TASK_INST_END,
        ACT_IDX_HI_TASK_INST_PROC_DEF_KEY,
        ACT_IDX_HI_TASK_INST_RM_TIME,
        ACT_IDX_HI_TASK_INST_START,
        ACT_IDX_HI_TASK_INST_TENANT_ID,
        ACT_IDX_HI_TASKINST_PROCINST,
        ACT_IDX_HI_TASKINST_ROOT_PI,
        ACT_IDX_HI_TASKINSTID_PROCINST
    )

    override fun getPrimaryKey(): UniqueKey<ActHiTaskinstRecord> = ACT_HI_TASKINST_PKEY
    override fun `as`(alias: String): ActHiTaskinst = ActHiTaskinst(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiTaskinst = ActHiTaskinst(alias, this)
    override fun `as`(alias: Table<*>): ActHiTaskinst = ActHiTaskinst(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiTaskinst = ActHiTaskinst(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiTaskinst = ActHiTaskinst(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiTaskinst = ActHiTaskinst(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiTaskinst =
        ActHiTaskinst(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiTaskinst = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiTaskinst = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiTaskinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiTaskinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiTaskinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiTaskinst =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiTaskinst =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiTaskinst = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiTaskinst = where(DSL.notExists(select))
}
