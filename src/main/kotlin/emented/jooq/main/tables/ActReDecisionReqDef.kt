/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_DEC_REQ_DEF_TENANT_ID
import emented.jooq.main.keys.ACT_RE_DECISION_DEF__ACT_FK_DEC_REQ
import emented.jooq.main.keys.ACT_RE_DECISION_REQ_DEF_PKEY
import emented.jooq.main.tables.ActReDecisionDef.ActReDecisionDefPath
import emented.jooq.main.tables.records.ActReDecisionReqDefRecord
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
open class ActReDecisionReqDef(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActReDecisionReqDefRecord>?,
    parentPath: InverseForeignKey<out Record, ActReDecisionReqDefRecord>?,
    aliased: Table<ActReDecisionReqDefRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActReDecisionReqDefRecord>(
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
         * The reference instance of <code>public.act_re_decision_req_def</code>
         */
        val ACT_RE_DECISION_REQ_DEF: ActReDecisionReqDef = ActReDecisionReqDef()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActReDecisionReqDefRecord> = ActReDecisionReqDefRecord::class.java

    /**
     * The column <code>public.act_re_decision_req_def.id_</code>.
     */
    val ID_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.rev_</code>.
     */
    val REV_: TableField<ActReDecisionReqDefRecord, Int?> = createField(DSL.name("rev_"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.act_re_decision_req_def.category_</code>.
     */
    val CATEGORY_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("category_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.name_</code>.
     */
    val NAME_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.key_</code>.
     */
    val KEY_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("key_"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.version_</code>.
     */
    val VERSION_: TableField<ActReDecisionReqDefRecord, Int?> =
        createField(DSL.name("version_"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.deployment_id_</code>.
     */
    val DEPLOYMENT_ID_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("deployment_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.resource_name_</code>.
     */
    val RESOURCE_NAME_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("resource_name_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column
     * <code>public.act_re_decision_req_def.dgrm_resource_name_</code>.
     */
    val DGRM_RESOURCE_NAME_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("dgrm_resource_name_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_re_decision_req_def.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActReDecisionReqDefRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    private constructor(alias: Name, aliased: Table<ActReDecisionReqDefRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActReDecisionReqDefRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActReDecisionReqDefRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_re_decision_req_def</code> table
     * reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_re_decision_req_def</code> table
     * reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_re_decision_req_def</code> table reference
     */
    constructor() : this(DSL.name("act_re_decision_req_def"), null)

    constructor(
        path: Table<out Record>,
        childPath: ForeignKey<out Record, ActReDecisionReqDefRecord>?,
        parentPath: InverseForeignKey<out Record, ActReDecisionReqDefRecord>?
    ) : this(
        Internal.createPathAlias(path, childPath, parentPath),
        path,
        childPath,
        parentPath,
        ACT_RE_DECISION_REQ_DEF,
        null,
        null
    )

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class ActReDecisionReqDefPath : ActReDecisionReqDef, Path<ActReDecisionReqDefRecord> {
        constructor(
            path: Table<out Record>,
            childPath: ForeignKey<out Record, ActReDecisionReqDefRecord>?,
            parentPath: InverseForeignKey<out Record, ActReDecisionReqDefRecord>?
        ) : super(path, childPath, parentPath)

        private constructor(alias: Name, aliased: Table<ActReDecisionReqDefRecord>) : super(alias, aliased)

        override fun `as`(alias: String): ActReDecisionReqDefPath = ActReDecisionReqDefPath(DSL.name(alias), this)
        override fun `as`(alias: Name): ActReDecisionReqDefPath = ActReDecisionReqDefPath(alias, this)
        override fun `as`(alias: Table<*>): ActReDecisionReqDefPath = ActReDecisionReqDefPath(alias.qualifiedName, this)
    }

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(ACT_IDX_DEC_REQ_DEF_TENANT_ID)
    override fun getPrimaryKey(): UniqueKey<ActReDecisionReqDefRecord> = ACT_RE_DECISION_REQ_DEF_PKEY

    private lateinit var _actReDecisionDef: ActReDecisionDefPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.act_re_decision_def</code> table
     */
    fun actReDecisionDef(): ActReDecisionDefPath {
        if (!this::_actReDecisionDef.isInitialized)
            _actReDecisionDef = ActReDecisionDefPath(this, null, ACT_RE_DECISION_DEF__ACT_FK_DEC_REQ.inverseKey)

        return _actReDecisionDef
    }

    val actReDecisionDef: ActReDecisionDefPath
        get(): ActReDecisionDefPath = actReDecisionDef()

    override fun `as`(alias: String): ActReDecisionReqDef = ActReDecisionReqDef(DSL.name(alias), this)
    override fun `as`(alias: Name): ActReDecisionReqDef = ActReDecisionReqDef(alias, this)
    override fun `as`(alias: Table<*>): ActReDecisionReqDef = ActReDecisionReqDef(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActReDecisionReqDef = ActReDecisionReqDef(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActReDecisionReqDef = ActReDecisionReqDef(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActReDecisionReqDef = ActReDecisionReqDef(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActReDecisionReqDef =
        ActReDecisionReqDef(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActReDecisionReqDef = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActReDecisionReqDef = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActReDecisionReqDef = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActReDecisionReqDef = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActReDecisionReqDef = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActReDecisionReqDef =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActReDecisionReqDef =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActReDecisionReqDef = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActReDecisionReqDef = where(DSL.notExists(select))
}
