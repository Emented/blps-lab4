/*
 * This file is generated by jOOQ.
 */
package emented.jooq.tables


import emented.jooq.Public
import emented.jooq.keys.ROLE_NAME_KEY
import emented.jooq.keys.ROLE_PKEY
import emented.jooq.keys.ROLE_USER_RELATION__FK_ROLE_USER_RELATION_ROLE_ID
import emented.jooq.tables.RoleUserRelation.RoleUserRelationPath
import emented.jooq.tables.User.UserPath
import emented.jooq.tables.records.RoleRecord

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
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
open class Role(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, RoleRecord>?,
    parentPath: InverseForeignKey<out Record, RoleRecord>?,
    aliased: Table<RoleRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<RoleRecord>(
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
         * The reference instance of <code>public.role</code>
         */
        val ROLE: Role = Role()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<RoleRecord> = RoleRecord::class.java

    /**
     * The column <code>public.role.id</code>.
     */
    val ID: TableField<RoleRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.role.name</code>.
     */
    val NAME: TableField<RoleRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<RoleRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<RoleRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<RoleRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.role</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.role</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.role</code> table reference
     */
    constructor(): this(DSL.name("role"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, RoleRecord>?, parentPath: InverseForeignKey<out Record, RoleRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, ROLE, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class RolePath : Role, Path<RoleRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, RoleRecord>?, parentPath: InverseForeignKey<out Record, RoleRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<RoleRecord>): super(alias, aliased)
        override fun `as`(alias: String): RolePath = RolePath(DSL.name(alias), this)
        override fun `as`(alias: Name): RolePath = RolePath(alias, this)
        override fun `as`(alias: Table<*>): RolePath = RolePath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<RoleRecord, Long?> = super.getIdentity() as Identity<RoleRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<RoleRecord> = ROLE_PKEY
    override fun getUniqueKeys(): List<UniqueKey<RoleRecord>> = listOf(ROLE_NAME_KEY)

    private lateinit var _roleUserRelation: RoleUserRelationPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.role_user_relation</code> table
     */
    fun roleUserRelation(): RoleUserRelationPath {
        if (!this::_roleUserRelation.isInitialized)
            _roleUserRelation = RoleUserRelationPath(this, null, ROLE_USER_RELATION__FK_ROLE_USER_RELATION_ROLE_ID.inverseKey)

        return _roleUserRelation;
    }

    val roleUserRelation: RoleUserRelationPath
        get(): RoleUserRelationPath = roleUserRelation()

    /**
     * Get the implicit many-to-many join path to the <code>public.user</code>
     * table
     */
    val user: UserPath
        get(): UserPath = roleUserRelation().user()
    override fun `as`(alias: String): Role = Role(DSL.name(alias), this)
    override fun `as`(alias: Name): Role = Role(alias, this)
    override fun `as`(alias: Table<*>): Role = Role(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Role = Role(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Role = Role(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Role = Role(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Role = Role(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Role = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Role = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Role = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Role = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Role = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Role = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Role = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Role = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Role = where(DSL.notExists(select))
}
