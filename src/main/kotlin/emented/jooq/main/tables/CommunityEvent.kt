/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.keys.COMMUNITY_EVENT_ADDRESS_KEY
import emented.jooq.main.keys.COMMUNITY_EVENT_PKEY
import emented.jooq.main.keys.COMMUNITY_EVENT__COMMUNITY_EVENT_CATEGORY_ID_FKEY
import emented.jooq.main.tables.Category.CategoryPath
import emented.jooq.main.tables.records.CommunityEventRecord
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
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CommunityEvent(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, CommunityEventRecord>?,
    parentPath: InverseForeignKey<out Record, CommunityEventRecord>?,
    aliased: Table<CommunityEventRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<CommunityEventRecord>(
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
         * The reference instance of <code>public.community_event</code>
         */
        val COMMUNITY_EVENT: CommunityEvent = CommunityEvent()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<CommunityEventRecord> = CommunityEventRecord::class.java

    /**
     * The column <code>public.community_event.id</code>.
     */
    val ID: TableField<CommunityEventRecord, Long?> =
        createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.community_event.community_id</code>.
     */
    val COMMUNITY_ID: TableField<CommunityEventRecord, Long?> =
        createField(DSL.name("community_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_event.name</code>.
     */
    val NAME: TableField<CommunityEventRecord, String?> =
        createField(DSL.name("name"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_event.address</code>.
     */
    val ADDRESS: TableField<CommunityEventRecord, String?> =
        createField(DSL.name("address"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_event.language</code>.
     */
    val LANGUAGE: TableField<CommunityEventRecord, String?> =
        createField(DSL.name("language"), SQLDataType.VARCHAR(2).nullable(false), this, "")

    /**
     * The column <code>public.community_event.description</code>.
     */
    val DESCRIPTION: TableField<CommunityEventRecord, String?> =
        createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.community_event.is_for_children</code>.
     */
    val IS_FOR_CHILDREN: TableField<CommunityEventRecord, Boolean?> =
        createField(DSL.name("is_for_children"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community_event.category_id</code>.
     */
    val CATEGORY_ID: TableField<CommunityEventRecord, Long?> =
        createField(DSL.name("category_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_event.user_id</code>.
     */
    val USER_ID: TableField<CommunityEventRecord, Long?> =
        createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_event.is_blocked</code>.
     */
    val IS_BLOCKED: TableField<CommunityEventRecord, Boolean?> =
        createField(DSL.name("is_blocked"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community_event.interest_rate</code>.
     */
    val INTEREST_RATE: TableField<CommunityEventRecord, Long?> =
        createField(DSL.name("interest_rate"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_event.creation_ts</code>.
     */
    val CREATION_TS: TableField<CommunityEventRecord, OffsetDateTime?> =
        createField(DSL.name("creation_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.community_event.event_type</code>.
     */
    val EVENT_TYPE: TableField<CommunityEventRecord, String?> =
        createField(DSL.name("event_type"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_event.is_sent</code>.
     */
    val IS_SENT: TableField<CommunityEventRecord, Boolean?> =
        createField(DSL.name("is_sent"), SQLDataType.BOOLEAN.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<CommunityEventRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<CommunityEventRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<CommunityEventRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.community_event</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.community_event</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.community_event</code> table reference
     */
    constructor() : this(DSL.name("community_event"), null)

    constructor(
        path: Table<out Record>,
        childPath: ForeignKey<out Record, CommunityEventRecord>?,
        parentPath: InverseForeignKey<out Record, CommunityEventRecord>?
    ) : this(
        Internal.createPathAlias(path, childPath, parentPath),
        path,
        childPath,
        parentPath,
        COMMUNITY_EVENT,
        null,
        null
    )

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class CommunityEventPath : CommunityEvent, Path<CommunityEventRecord> {
        constructor(
            path: Table<out Record>,
            childPath: ForeignKey<out Record, CommunityEventRecord>?,
            parentPath: InverseForeignKey<out Record, CommunityEventRecord>?
        ) : super(path, childPath, parentPath)

        private constructor(alias: Name, aliased: Table<CommunityEventRecord>) : super(alias, aliased)

        override fun `as`(alias: String): CommunityEventPath = CommunityEventPath(DSL.name(alias), this)
        override fun `as`(alias: Name): CommunityEventPath = CommunityEventPath(alias, this)
        override fun `as`(alias: Table<*>): CommunityEventPath = CommunityEventPath(alias.qualifiedName, this)
    }

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<CommunityEventRecord, Long?> =
        super.getIdentity() as Identity<CommunityEventRecord, Long?>

    override fun getPrimaryKey(): UniqueKey<CommunityEventRecord> = COMMUNITY_EVENT_PKEY
    override fun getUniqueKeys(): List<UniqueKey<CommunityEventRecord>> = listOf(COMMUNITY_EVENT_ADDRESS_KEY)
    override fun getReferences(): List<ForeignKey<CommunityEventRecord, *>> =
        listOf(COMMUNITY_EVENT__COMMUNITY_EVENT_CATEGORY_ID_FKEY)

    private lateinit var _category: CategoryPath

    /**
     * Get the implicit join path to the <code>public.category</code> table.
     */
    fun category(): CategoryPath {
        if (!this::_category.isInitialized)
            _category = CategoryPath(this, COMMUNITY_EVENT__COMMUNITY_EVENT_CATEGORY_ID_FKEY, null)

        return _category
    }

    val category: CategoryPath
        get(): CategoryPath = category()

    override fun `as`(alias: String): CommunityEvent = CommunityEvent(DSL.name(alias), this)
    override fun `as`(alias: Name): CommunityEvent = CommunityEvent(alias, this)
    override fun `as`(alias: Table<*>): CommunityEvent = CommunityEvent(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): CommunityEvent = CommunityEvent(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): CommunityEvent = CommunityEvent(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): CommunityEvent = CommunityEvent(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): CommunityEvent =
        CommunityEvent(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): CommunityEvent = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): CommunityEvent = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): CommunityEvent = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): CommunityEvent = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): CommunityEvent = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): CommunityEvent =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): CommunityEvent =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): CommunityEvent = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): CommunityEvent = where(DSL.notExists(select))
}
