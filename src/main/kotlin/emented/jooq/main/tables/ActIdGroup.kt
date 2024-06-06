/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.keys.ACT_ID_GROUP_PKEY
import emented.jooq.main.keys.ACT_ID_MEMBERSHIP__ACT_FK_MEMB_GROUP
import emented.jooq.main.keys.ACT_ID_TENANT_MEMBER__ACT_FK_TENANT_MEMB_GROUP
import emented.jooq.main.tables.ActIdMembership.ActIdMembershipPath
import emented.jooq.main.tables.ActIdTenant.ActIdTenantPath
import emented.jooq.main.tables.ActIdTenantMember.ActIdTenantMemberPath
import emented.jooq.main.tables.ActIdUser.ActIdUserPath
import emented.jooq.main.tables.records.ActIdGroupRecord
import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
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
open class ActIdGroup(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActIdGroupRecord>?,
    parentPath: InverseForeignKey<out Record, ActIdGroupRecord>?,
    aliased: Table<ActIdGroupRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActIdGroupRecord>(
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
         * The reference instance of <code>public.act_id_group</code>
         */
        val ACT_ID_GROUP: ActIdGroup = ActIdGroup()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActIdGroupRecord> = ActIdGroupRecord::class.java

    /**
     * The column <code>public.act_id_group.id_</code>.
     */
    val ID_: TableField<ActIdGroupRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_id_group.rev_</code>.
     */
    val REV_: TableField<ActIdGroupRecord, Int?> = createField(DSL.name("rev_"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.act_id_group.name_</code>.
     */
    val NAME_: TableField<ActIdGroupRecord, String?> =
        createField(DSL.name("name_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_id_group.type_</code>.
     */
    val TYPE_: TableField<ActIdGroupRecord, String?> =
        createField(DSL.name("type_"), SQLDataType.VARCHAR(255), this, "")

    private constructor(alias: Name, aliased: Table<ActIdGroupRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActIdGroupRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActIdGroupRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_id_group</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_id_group</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_id_group</code> table reference
     */
    constructor() : this(DSL.name("act_id_group"), null)

    constructor(
        path: Table<out Record>,
        childPath: ForeignKey<out Record, ActIdGroupRecord>?,
        parentPath: InverseForeignKey<out Record, ActIdGroupRecord>?
    ) : this(
        Internal.createPathAlias(path, childPath, parentPath),
        path,
        childPath,
        parentPath,
        ACT_ID_GROUP,
        null,
        null
    )

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class ActIdGroupPath : ActIdGroup, Path<ActIdGroupRecord> {
        constructor(
            path: Table<out Record>,
            childPath: ForeignKey<out Record, ActIdGroupRecord>?,
            parentPath: InverseForeignKey<out Record, ActIdGroupRecord>?
        ) : super(path, childPath, parentPath)

        private constructor(alias: Name, aliased: Table<ActIdGroupRecord>) : super(alias, aliased)

        override fun `as`(alias: String): ActIdGroupPath = ActIdGroupPath(DSL.name(alias), this)
        override fun `as`(alias: Name): ActIdGroupPath = ActIdGroupPath(alias, this)
        override fun `as`(alias: Table<*>): ActIdGroupPath = ActIdGroupPath(alias.qualifiedName, this)
    }

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<ActIdGroupRecord> = ACT_ID_GROUP_PKEY

    private lateinit var _actIdMembership: ActIdMembershipPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.act_id_membership</code> table
     */
    fun actIdMembership(): ActIdMembershipPath {
        if (!this::_actIdMembership.isInitialized)
            _actIdMembership = ActIdMembershipPath(this, null, ACT_ID_MEMBERSHIP__ACT_FK_MEMB_GROUP.inverseKey)

        return _actIdMembership
    }

    val actIdMembership: ActIdMembershipPath
        get(): ActIdMembershipPath = actIdMembership()

    private lateinit var _actIdTenantMember: ActIdTenantMemberPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.act_id_tenant_member</code> table
     */
    fun actIdTenantMember(): ActIdTenantMemberPath {
        if (!this::_actIdTenantMember.isInitialized)
            _actIdTenantMember =
                ActIdTenantMemberPath(this, null, ACT_ID_TENANT_MEMBER__ACT_FK_TENANT_MEMB_GROUP.inverseKey)

        return _actIdTenantMember
    }

    val actIdTenantMember: ActIdTenantMemberPath
        get(): ActIdTenantMemberPath = actIdTenantMember()

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.act_id_user</code> table
     */
    val actIdUser: ActIdUserPath
        get(): ActIdUserPath = actIdMembership().actIdUser()

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.act_id_tenant</code> table
     */
    val actIdTenant: ActIdTenantPath
        get(): ActIdTenantPath = actIdTenantMember().actIdTenant()

    override fun `as`(alias: String): ActIdGroup = ActIdGroup(DSL.name(alias), this)
    override fun `as`(alias: Name): ActIdGroup = ActIdGroup(alias, this)
    override fun `as`(alias: Table<*>): ActIdGroup = ActIdGroup(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActIdGroup = ActIdGroup(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActIdGroup = ActIdGroup(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActIdGroup = ActIdGroup(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActIdGroup =
        ActIdGroup(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActIdGroup = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActIdGroup = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActIdGroup = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActIdGroup = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActIdGroup = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActIdGroup =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActIdGroup =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActIdGroup = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActIdGroup = where(DSL.notExists(select))
}