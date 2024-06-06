/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_OUT_INST
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_OUT_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_OUT_ROOT_PI
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_OUT_RULE
import emented.jooq.main.keys.ACT_HI_DEC_OUT_PKEY
import emented.jooq.main.tables.records.ActHiDecOutRecord
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
open class ActHiDecOut(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiDecOutRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiDecOutRecord>?,
    aliased: Table<ActHiDecOutRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiDecOutRecord>(
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
         * The reference instance of <code>public.act_hi_dec_out</code>
         */
        val ACT_HI_DEC_OUT: ActHiDecOut = ActHiDecOut()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiDecOutRecord> = ActHiDecOutRecord::class.java

    /**
     * The column <code>public.act_hi_dec_out.id_</code>.
     */
    val ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_dec_out.dec_inst_id_</code>.
     */
    val DEC_INST_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("dec_inst_id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_dec_out.clause_id_</code>.
     */
    val CLAUSE_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("clause_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_out.clause_name_</code>.
     */
    val CLAUSE_NAME_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("clause_name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_dec_out.rule_id_</code>.
     */
    val RULE_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("rule_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_out.rule_order_</code>.
     */
    val RULE_ORDER_: TableField<ActHiDecOutRecord, Int?> =
        createField(DSL.name("rule_order_"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.act_hi_dec_out.var_name_</code>.
     */
    val VAR_NAME_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("var_name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_dec_out.var_type_</code>.
     */
    val VAR_TYPE_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("var_type_"), SQLDataType.VARCHAR(100), this, "")

    /**
     * The column <code>public.act_hi_dec_out.bytearray_id_</code>.
     */
    val BYTEARRAY_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("bytearray_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_out.double_</code>.
     */
    val DOUBLE_: TableField<ActHiDecOutRecord, Double?> = createField(DSL.name("double_"), SQLDataType.DOUBLE, this, "")

    /**
     * The column <code>public.act_hi_dec_out.long_</code>.
     */
    val LONG_: TableField<ActHiDecOutRecord, Long?> = createField(DSL.name("long_"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.act_hi_dec_out.text_</code>.
     */
    val TEXT_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("text_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_dec_out.text2_</code>.
     */
    val TEXT2_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("text2_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_dec_out.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_out.create_time_</code>.
     */
    val CREATE_TIME_: TableField<ActHiDecOutRecord, LocalDateTime?> =
        createField(DSL.name("create_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_dec_out.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiDecOutRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_out.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiDecOutRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<ActHiDecOutRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiDecOutRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiDecOutRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_dec_out</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_dec_out</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_dec_out</code> table reference
     */
    constructor() : this(DSL.name("act_hi_dec_out"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> =
        listOf(ACT_IDX_HI_DEC_OUT_INST, ACT_IDX_HI_DEC_OUT_RM_TIME, ACT_IDX_HI_DEC_OUT_ROOT_PI, ACT_IDX_HI_DEC_OUT_RULE)

    override fun getPrimaryKey(): UniqueKey<ActHiDecOutRecord> = ACT_HI_DEC_OUT_PKEY
    override fun `as`(alias: String): ActHiDecOut = ActHiDecOut(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiDecOut = ActHiDecOut(alias, this)
    override fun `as`(alias: Table<*>): ActHiDecOut = ActHiDecOut(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiDecOut = ActHiDecOut(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiDecOut = ActHiDecOut(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiDecOut = ActHiDecOut(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiDecOut =
        ActHiDecOut(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiDecOut = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiDecOut = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiDecOut = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiDecOut = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiDecOut = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiDecOut =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiDecOut =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiDecOut = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiDecOut = where(DSL.notExists(select))
}
