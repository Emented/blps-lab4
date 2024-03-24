package emented.dao

import emented.model.domain.Category

interface CategoryDao {
    fun getCategories(): List<Category>
}
