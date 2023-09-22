package com.shine.foodfleet.presentation.data

import com.shine.foodfleet.R
import com.shine.foodfleet.presentation.model.Category
import java.util.Locale

interface CategoryDataSource {
    fun getCategory(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategory(): List<Category> {
        return listOf(
            Category(
                R.drawable.ic_rice,
                "Rice"
            ),
            Category(
                R.drawable.burger,
                "Burger"
            ),
            Category(
                R.drawable.ic_snack,
                "Snack"
            ),
            Category(
                R.drawable.drink,
                "Drink"
            ),
        )
    }


}
