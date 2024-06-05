package emented.dao.impl

import emented.dao.CategoryDao
import emented.jooq.main.tables.references.CATEGORY
import emented.model.domain.Category
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository

@Repository
class CategoryDaoImpl(
    private val mainDslContext: DSLContext,
) : CategoryDao {
    override fun getCategories(): List<Category> {
        return mainDslContext.select(selectFields)
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
