package emented.dao.impl

import emented.dao.CategoryDao
import emented.jooq.tables.references.CATEGORY
import emented.model.domain.Category
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

@Repository
class CategoryDaoImpl(
    private val dslContext: DSLContext,
) : CategoryDao {
    override fun getCategories(): List<Category> {
        return dslContext.select(selectFields)
            .from(CATEGORY)
            .fetch(CategoryDaoImpl::mapCategory)
    }

    companion object {
        val selectFields = setOf(
            CATEGORY.ID,
            CATEGORY.NAME,
        )

        fun mapCategory(record: Record): Category {
            return Category(
                id = record.get(CATEGORY.ID),
                name = record.get(CATEGORY.NAME)!!,
            )
        }
    }
}
