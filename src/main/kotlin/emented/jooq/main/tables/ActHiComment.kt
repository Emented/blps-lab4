/*
 * This file is generated by jOOQ.
 */
package emented.jooq.main.tables

import emented.jooq.main.Public
import emented.jooq.main.indexes.ACT_IDX_HI_COMMENT_PROCINST
import emented.jooq.main.indexes.ACT_IDX_HI_COMMENT_RM_TIME
import emented.jooq.main.indexes.ACT_IDX_HI_COMMENT_ROOT_PI
import emented.jooq.main.indexes.ACT_IDX_HI_COMMENT_TASK
import emented.jooq.main.keys.ACT_HI_COMMENT_PKEY
import emented.jooq.main.tables.records.ActHiCommentRecord
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
open class ActHiComment(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, ActHiCommentRecord>?,
    parentPath: InverseForeignKey<out Record, ActHiCommentRecord>?,
    aliased: Table<ActHiCommentRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
) : TableImpl<ActHiCommentRecord>(
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
         * The reference instance of <code>public.act_hi_comment</code>
         */
        val ACT_HI_COMMENT: ActHiComment = ActHiComment()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<ActHiCommentRecord> = ActHiCommentRecord::class.java

    /**
     * The column <code>public.act_hi_comment.id_</code>.
     */
    val ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("id_"), SQLDataType.VARCHAR(64).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_comment.type_</code>.
     */
    val TYPE_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("type_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_comment.time_</code>.
     */
    val TIME_: TableField<ActHiCommentRecord, LocalDateTime?> =
        createField(DSL.name("time_"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "")

    /**
     * The column <code>public.act_hi_comment.user_id_</code>.
     */
    val USER_ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("user_id_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_comment.task_id_</code>.
     */
    val TASK_ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("task_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_comment.root_proc_inst_id_</code>.
     */
    val ROOT_PROC_INST_ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("root_proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_comment.proc_inst_id_</code>.
     */
    val PROC_INST_ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("proc_inst_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_comment.action_</code>.
     */
    val ACTION_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("action_"), SQLDataType.VARCHAR(255), this, "")

    /**
     * The column <code>public.act_hi_comment.message_</code>.
     */
    val MESSAGE_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("message_"), SQLDataType.VARCHAR(4000), this, "")

    /**
     * The column <code>public.act_hi_comment.full_msg_</code>.
     */
    val FULL_MSG_: TableField<ActHiCommentRecord, ByteArray?> =
        createField(DSL.name("full_msg_"), SQLDataType.BLOB, this, "")

    /**
     * The column <code>public.act_hi_comment.tenant_id_</code>.
     */
    val TENANT_ID_: TableField<ActHiCommentRecord, String?> =
        createField(DSL.name("tenant_id_"), SQLDataType.VARCHAR(64), this, "")

    /**
     * The column <code>public.act_hi_comment.removal_time_</code>.
     */
    val REMOVAL_TIME_: TableField<ActHiCommentRecord, LocalDateTime?> =
        createField(DSL.name("removal_time_"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<ActHiCommentRecord>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiCommentRecord>?, parameters: Array<Field<*>?>?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        parameters,
        null
    )

    private constructor(alias: Name, aliased: Table<ActHiCommentRecord>?, where: Condition?) : this(
        alias,
        null,
        null,
        null,
        aliased,
        null,
        where
    )

    /**
     * Create an aliased <code>public.act_hi_comment</code> table reference
     */
    constructor(alias: String) : this(DSL.name(alias))

    /**
     * Create an aliased <code>public.act_hi_comment</code> table reference
     */
    constructor(alias: Name) : this(alias, null)

    /**
     * Create a <code>public.act_hi_comment</code> table reference
     */
    constructor() : this(DSL.name("act_hi_comment"), null)

    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIndexes(): List<Index> = listOf(
        ACT_IDX_HI_COMMENT_PROCINST,
        ACT_IDX_HI_COMMENT_RM_TIME,
        ACT_IDX_HI_COMMENT_ROOT_PI,
        ACT_IDX_HI_COMMENT_TASK
    )

    override fun getPrimaryKey(): UniqueKey<ActHiCommentRecord> = ACT_HI_COMMENT_PKEY
    override fun `as`(alias: String): ActHiComment = ActHiComment(DSL.name(alias), this)
    override fun `as`(alias: Name): ActHiComment = ActHiComment(alias, this)
    override fun `as`(alias: Table<*>): ActHiComment = ActHiComment(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): ActHiComment = ActHiComment(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): ActHiComment = ActHiComment(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): ActHiComment = ActHiComment(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): ActHiComment =
        ActHiComment(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): ActHiComment = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): ActHiComment = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): ActHiComment = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(condition: SQL): ActHiComment = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String): ActHiComment = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg binds: Any?): ActHiComment =
        where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL
    override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): ActHiComment =
        where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): ActHiComment = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): ActHiComment = where(DSL.notExists(select))
}