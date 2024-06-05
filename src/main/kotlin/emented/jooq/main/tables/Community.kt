/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables


import emented.jooq.main.Public
import emented.jooq.main.keys.COMMENT__COMMENT_COMMUNITY_ID_FKEY
import emented.jooq.main.keys.COMMUNITY_ADDRESS_KEY
import emented.jooq.main.keys.COMMUNITY_PKEY
import emented.jooq.main.keys.COMMUNITY__COMMUNITY_CATEGORY_ID_FKEY
import emented.jooq.main.keys.COMMUNITY__COMMUNITY_USER_ID_FKEY
import emented.jooq.main.tables.Category.CategoryPath
import emented.jooq.main.tables.Comment.CommentPath
import emented.jooq.main.tables.User.UserPath
import emented.jooq.main.tables.records.CommunityRecord

import java.time.OffsetDateTime

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
open class Community(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, CommunityRecord>?,
    parentPath: InverseForeignKey<out Record, CommunityRecord>?,
    aliased: Table<CommunityRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<CommunityRecord>(
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
         * The reference instance of <code>public.community</code>
         */
        val COMMUNITY: Community = Community()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<CommunityRecord> = CommunityRecord::class.java

    /**
     * The column <code>public.community.id</code>.
     */
    val ID: TableField<CommunityRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.community.name</code>.
     */
    val NAME: TableField<CommunityRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community.address</code>.
     */
    val ADDRESS: TableField<CommunityRecord, String?> = createField(DSL.name("address"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community.language</code>.
     */
    val LANGUAGE: TableField<CommunityRecord, String?> = createField(DSL.name("language"), SQLDataType.VARCHAR(2).nullable(false), this, "")

    /**
     * The column <code>public.community.description</code>.
     */
    val DESCRIPTION: TableField<CommunityRecord, String?> = createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.community.is_for_children</code>.
     */
    val IS_FOR_CHILDREN: TableField<CommunityRecord, Boolean?> = createField(DSL.name("is_for_children"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community.category_id</code>.
     */
    val CATEGORY_ID: TableField<CommunityRecord, Long?> = createField(DSL.name("category_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community.user_id</code>.
     */
    val USER_ID: TableField<CommunityRecord, Long?> = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community.is_blocked</code>.
     */
    val IS_BLOCKED: TableField<CommunityRecord, Boolean?> = createField(DSL.name("is_blocked"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community.interest_rate</code>.
     */
    val INTEREST_RATE: TableField<CommunityRecord, Long?> = createField(DSL.name("interest_rate"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community.moderation_result</code>.
     */
    val MODERATION_RESULT: TableField<CommunityRecord, String?> = createField(DSL.name("moderation_result"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community.moderation_message</code>.
     */
    val MODERATION_MESSAGE: TableField<CommunityRecord, String?> = createField(DSL.name("moderation_message"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.community.creation_ts</code>.
     */
    val CREATION_TS: TableField<CommunityRecord, OffsetDateTime?> = createField(DSL.name("creation_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.community.update_ts</code>.
     */
    val UPDATE_TS: TableField<CommunityRecord, OffsetDateTime?> = createField(DSL.name("update_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<CommunityRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<CommunityRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<CommunityRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.community</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.community</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.community</code> table reference
     */
    constructor(): this(DSL.name("community"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, CommunityRecord>?, parentPath: InverseForeignKey<out Record, CommunityRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, COMMUNITY, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class CommunityPath : Community, Path<CommunityRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, CommunityRecord>?, parentPath: InverseForeignKey<out Record, CommunityRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<CommunityRecord>): super(alias, aliased)
        override fun `as`(alias: String): CommunityPath = CommunityPath(DSL.name(alias), this)
        override fun `as`(alias: Name): CommunityPath = CommunityPath(alias, this)
        override fun `as`(alias: Table<*>): CommunityPath = CommunityPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<CommunityRecord, Long?> = super.getIdentity() as Identity<CommunityRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<CommunityRecord> = COMMUNITY_PKEY
    override fun getUniqueKeys(): List<UniqueKey<CommunityRecord>> = listOf(COMMUNITY_ADDRESS_KEY)
    override fun getReferences(): List<ForeignKey<CommunityRecord, *>> = listOf(COMMUNITY__COMMUNITY_CATEGORY_ID_FKEY, COMMUNITY__COMMUNITY_USER_ID_FKEY)

    private lateinit var _category: CategoryPath

    /**
     * Get the implicit join path to the <code>public.category</code> table.
     */
    fun category(): CategoryPath {
        if (!this::_category.isInitialized)
            _category = CategoryPath(this, COMMUNITY__COMMUNITY_CATEGORY_ID_FKEY, null)

        return _category;
    }

    val category: CategoryPath
        get(): CategoryPath = category()

    private lateinit var _user: UserPath

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    fun user(): UserPath {
        if (!this::_user.isInitialized)
            _user = UserPath(this, COMMUNITY__COMMUNITY_USER_ID_FKEY, null)

        return _user;
    }

    val user: UserPath
        get(): UserPath = user()

    private lateinit var _comment: CommentPath

    /**
     * Get the implicit to-many join path to the <code>public.comment</code>
     * table
     */
    fun comment(): CommentPath {
        if (!this::_comment.isInitialized)
            _comment = CommentPath(this, null, COMMENT__COMMENT_COMMUNITY_ID_FKEY.inverseKey)

        return _comment;
    }

    val comment: CommentPath
        get(): CommentPath = comment()
    override fun `as`(alias: String): Community = Community(DSL.name(alias), this)
    override fun `as`(alias: Name): Community = Community(alias, this)
    override fun `as`(alias: Table<*>): Community = Community(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Community = Community(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Community = Community(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Community = Community(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Community = Community(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Community = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Community = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Community = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Community = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Community = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Community = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Community = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Community = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Community = where(DSL.notExists(select))
}