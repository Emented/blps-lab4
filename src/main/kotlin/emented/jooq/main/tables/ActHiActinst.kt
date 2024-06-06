/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_ACTINST_ROOT_PI
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_COMP
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_END
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_PROCINST
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_PROC_DEF_KEY
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_START_END
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_STATS
import emented.jooq.main.indexes.ACT_IDX_HI_ACT_INST_TENANT_ID
import emented.jooq.main.indexes.ACT_IDX_HI_AI_PDEFID_END_TIME
import emented.jooq.main.keys.ACT_HI_ACTINST_PKEY
import emented.jooq.main.tables.records.ActHiActinstRecord
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
open class ActHiActinst(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiActinstRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiActinstRecord>?,
    aliased: Table<ActHiActinstRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiActinstRecord>(
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
         * The reference instance of <code>public.act_hi_actinst</code>
         */
        val ACT_HI_ACTINST: ActHiActinst = ActHiActinst()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiActinstRecord> = ActHiActinstRecord::class.java

    /**
     * The column <code>public.act_hi_actinst.id_</code>.
     */
    val ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.parent_act_inst_id_</code>.
     */
    val PARENT_ACT_INST_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("parent_act_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.proc_def_key_</code>.
     */
    val PROC_DEF_KEY_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("proc_def_key_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_actinst.proc_def_id_</code>.
     */
    val PROC_DEF_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("proc_def_id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.proc_inst_id_</code>.
     */
    val PROC_INST_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("proc_inst_id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.execution_id_</code>.
     */
    val EXECUTION_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("execution_id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.act_id_</code>.
     */
    val ACT_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("act_id_"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.task_id_</code>.
     */
    val TASK_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("task_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.call_proc_inst_id_</code>.
     */
    val CALL_PROC_INST_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("call_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.call_case_inst_id_</code>.
     */
    val CALL_CASE_INST_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("call_case_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.act_name_</code>.
     */
    val ACT_NAME_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("act_name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_actinst.act_type_</code>.
     */
    val ACT_TYPE_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("act_type_"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.assignee_</code>.
     */
    val ASSIGNEE_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("assignee_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_actinst.start_time_</code>.
     */
    val START_TIME_: TableField<ActHiActinstRecord, LocalDateTime?> =
        createField(DSL.name("start_time_"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_actinst.end_time_</code>.
     */
    val END_TIME_: TableField<ActHiActinstRecord, LocalDateTime?> =
        createField(DSL.name("end_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_actinst.duration_</code>.
     */
    val DURATION_: TableField<ActHiActinstRecord, Long?> =
        createField(DSL.name("duration_"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.act_hi_actinst.act_inst_state_</code>.
     */
    val ACT_INST_STATE_: TableField<ActHiActinstRecord, Int?> =
        createField(DSL.name("act_inst_state_"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.act_hi_actinst.sequence_counter_</code>.
     */
    val SEQUENCE_COUNTER_: TableField<ActHiActinstRecord, Long?> =
        createField(DSL.name("sequence_counter_"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.act_hi_actinst.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiActinstRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_actinst.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiActinstRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<ActHiActinstRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiActinstRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiActinstRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_actinst</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_actinst</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_actinst</code> table reference
     */
    constructor() : this(DSL.name("act_hi_actinst"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(
        ACT_IDX_HI_ACT_INST_COMP,
        ACT_IDX_HI_ACT_INST_END,
        ACT_IDX_HI_ACT_INST_PROC_DEF_KEY,
        ACT_IDX_HI_ACT_INST_PROCINST,
        ACT_IDX_HI_ACT_INST_RM_TIME,
        ACT_IDX_HI_ACT_INST_START_END,
        ACT_IDX_HI_ACT_INST_STATS,
        ACT_IDX_HI_ACT_INST_TENANT_ID,
        ACT_IDX_HI_ACTINST_ROOT_PI,
        ACT_IDX_HI_AI_PDEFID_END_TIME
    )

    override fun getPrimaryKey(): UniqueKey<ActHiActinstRecord> = ACT_HI_ACTINST_PKEY
    override fun `as`(alias: String): ActHiActinst = ActHiActinst(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiActinst = ActHiActinst(alias, this)
    override fun `as`(alias: Table<*>): ActHiActinst = ActHiActinst(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiActinst = ActHiActinst(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiActinst = ActHiActinst(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiActinst = ActHiActinst(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiActinst =
        ActHiActinst(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiActinst = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiActinst = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiActinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiActinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiActinst = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiActinst =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiActinst =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiActinst = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiActinst = where(DSL.notExists(select))
}
