/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_IN_CLAUSE
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_IN_INST
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_IN_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_DEC_IN_ROOT_PI
import emented.jooq.main.keys.ACT_HI_DEC_IN_PKEY
import emented.jooq.main.tables.records.ActHiDecInRecord
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
open class ActHiDecIn(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiDecInRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiDecInRecord>?,
    aliased: Table<ActHiDecInRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiDecInRecord>(
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
         * The reference instance of <code>public.act_hi_dec_in</code>
         */
        val ACT_HI_DEC_IN: ActHiDecIn = ActHiDecIn()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiDecInRecord> = ActHiDecInRecord::class.java

    /**
     * The column <code>public.act_hi_dec_in.id_</code>.
     */
    val ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_dec_in.dec_inst_id_</code>.
     */
    val DEC_INST_ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("dec_inst_id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_dec_in.clause_id_</code>.
     */
    val CLAUSE_ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("clause_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_in.clause_name_</code>.
     */
    val CLAUSE_NAME_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("clause_name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_dec_in.var_type_</code>.
     */
    val VAR_TYPE_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("var_type_"), SQLDataType.VARCHAR(100), this, "")

    /**
     * The column <code>public.act_hi_dec_in.bytearray_id_</code>.
     */
    val BYTEARRAY_ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("bytearray_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_in.double_</code>.
     */
    val DOUBLE_: TableField<ActHiDecInRecord, Double?> = createField(DSL.name("double_"), SQLDataType.DOUBLE, this, "")

    /**
     * The column <code>public.act_hi_dec_in.long_</code>.
     */
    val LONG_: TableField<ActHiDecInRecord, Long?> = createField(DSL.name("long_"), SQLDataType.BIGINT, this, "")

    /**
     * The column <code>public.act_hi_dec_in.text_</code>.
     */
    val TEXT_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("text_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_dec_in.text2_</code>.
     */
    val TEXT2_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("text2_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_dec_in.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_in.create_time_</code>.
     */
    val CREATE_TIME_: TableField<ActHiDecInRecord, LocalDateTime?> =
        createField(DSL.name("create_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.act_hi_dec_in.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiDecInRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_dec_in.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiDecInRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<ActHiDecInRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiDecInRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiDecInRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_dec_in</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_dec_in</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_dec_in</code> table reference
     */
    constructor() : this(DSL.name("act_hi_dec_in"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> =
        listOf(ACT_IDX_HI_DEC_IN_CLAUSE, ACT_IDX_HI_DEC_IN_INST, ACT_IDX_HI_DEC_IN_RM_TIME, ACT_IDX_HI_DEC_IN_ROOT_PI)

    override fun getPrimaryKey(): UniqueKey<ActHiDecInRecord> = ACT_HI_DEC_IN_PKEY
    override fun `as`(alias: String): ActHiDecIn = ActHiDecIn(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiDecIn = ActHiDecIn(alias, this)
    override fun `as`(alias: Table<*>): ActHiDecIn = ActHiDecIn(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiDecIn = ActHiDecIn(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiDecIn = ActHiDecIn(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiDecIn = ActHiDecIn(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiDecIn =
        ActHiDecIn(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiDecIn = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiDecIn = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiDecIn = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiDecIn = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiDecIn = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiDecIn =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiDecIn =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiDecIn = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiDecIn = where(DSL.notExists(select))
}
