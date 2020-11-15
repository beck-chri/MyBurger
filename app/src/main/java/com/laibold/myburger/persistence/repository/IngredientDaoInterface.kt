package com.laibold.myburger.persistence.repository

import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType

interface IngredientDaoInterface {
    fun insert(ingredient: Ingredient)

    fun getAll(): MutableList<Ingredient>

    fun getByIndex(index: Int): Ingredient?

    fun getByName(name: String): Ingredient?

    fun getByIngredientType(type: IngredientType): List<Ingredient>

    fun count(): Int
}