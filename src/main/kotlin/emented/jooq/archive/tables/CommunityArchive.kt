/*
 * This file is generated by jOOQ.
 */
package emented.jooq.archive.tables


import emented.jooq.archive.Public
import emented.jooq.archive.keys.COMMUNITY_ARCHIVE_ADDRESS_KEY
import emented.jooq.archive.keys.COMMUNITY_ARCHIVE_PKEY
import emented.jooq.archive.tables.records.CommunityArchiveRecord

import java.time.OffsetDateTime

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
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
open class CommunityArchive(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, CommunityArchiveRecord>?,
    parentPath: InverseForeignKey<out Record, CommunityArchiveRecord>?,
    aliased: Table<CommunityArchiveRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<CommunityArchiveRecord>(
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
         * The reference instance of <code>public.community_archive</code>
         */
        val COMMUNITY_ARCHIVE: CommunityArchive = CommunityArchive()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<CommunityArchiveRecord> = CommunityArchiveRecord::class.java

    /**
     * The column <code>public.community_archive.id</code>.
     */
    val ID: TableField<CommunityArchiveRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.community_archive.name</code>.
     */
    val NAME: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.address</code>.
     */
    val ADDRESS: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("address"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.language</code>.
     */
    val LANGUAGE: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("language"), SQLDataType.VARCHAR(2).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.description</code>.
     */
    val DESCRIPTION: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("description"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.is_for_children</code>.
     */
    val IS_FOR_CHILDREN: TableField<CommunityArchiveRecord, Boolean?> = createField(DSL.name("is_for_children"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community_archive.category_name</code>.
     */
    val CATEGORY_NAME: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("category_name"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.user_id</code>.
     */
    val USER_ID: TableField<CommunityArchiveRecord, Long?> = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_archive.is_blocked</code>.
     */
    val IS_BLOCKED: TableField<CommunityArchiveRecord, Boolean?> = createField(DSL.name("is_blocked"), SQLDataType.BOOLEAN.nullable(false), this, "")

    /**
     * The column <code>public.community_archive.interest_rate</code>.
     */
    val INTEREST_RATE: TableField<CommunityArchiveRecord, Long?> = createField(DSL.name("interest_rate"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.community_archive.moderation_result</code>.
     */
    val MODERATION_RESULT: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("moderation_result"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.moderation_message</code>.
     */
    val MODERATION_MESSAGE: TableField<CommunityArchiveRecord, String?> = createField(DSL.name("moderation_message"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.community_archive.creation_ts</code>.
     */
    val CREATION_TS: TableField<CommunityArchiveRecord, OffsetDateTime?> = createField(DSL.name("creation_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.update_ts</code>.
     */
    val UPDATE_TS: TableField<CommunityArchiveRecord, OffsetDateTime?> = createField(DSL.name("update_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    /**
     * The column <code>public.community_archive.archivation_ts</code>.
     */
    val ARCHIVATION_TS: TableField<CommunityArchiveRecord, OffsetDateTime?> = createField(DSL.name("archivation_ts"), SQLDataType.TIMESTAMPWITHTIMEZONE(6).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<CommunityArchiveRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<CommunityArchiveRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<CommunityArchiveRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.community_archive</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.community_archive</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.community_archive</code> table reference
     */
    constructor(): this(DSL.name("community_archive"), null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<CommunityArchiveRecord, Long?> = super.getIdentity() as Identity<CommunityArchiveRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<CommunityArchiveRecord> = COMMUNITY_ARCHIVE_PKEY
    override fun getUniqueKeys(): List<UniqueKey<CommunityArchiveRecord>> = listOf(COMMUNITY_ARCHIVE_ADDRESS_KEY)
    override fun `as`(alias: String): CommunityArchive = CommunityArchive(DSL.name(alias), this)
    override fun `as`(alias: Name): CommunityArchive = CommunityArchive(alias, this)
    override fun `as`(alias: Table<*>): CommunityArchive = CommunityArchive(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): CommunityArchive = CommunityArchive(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): CommunityArchive = CommunityArchive(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): CommunityArchive = CommunityArchive(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): CommunityArchive = CommunityArchive(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): CommunityArchive = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): CommunityArchive = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): CommunityArchive = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): CommunityArchive = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): CommunityArchive = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): CommunityArchive = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): CommunityArchive = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): CommunityArchive = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): CommunityArchive = where(DSL.notExists(select))
}
