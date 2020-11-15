package com.laibold.myburger.persistence.repository.ingredient

import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType

object IngredientDao : IngredientDaoInterface {
    private val ingredientList = mutableListOf<Ingredient>()

    override fun insert(ingredient: Ingredient) {
        ingredientList.add(ingredient)
    }

    override fun getAll(): MutableList<Ingredient> {
        return ingredientList
    }

    override fun getByIndex(index: Int): Ingredient? {
        if (index >= 0 && index < ingredientList.size) {
            return ingredientList[index]
        }
        return null
    }

    override fun getByName(name: String): Ingredient? {
        return ingredientList.find { it.name == name }
    }

    override fun getByIngredientType(type: IngredientType): List<Ingredient> {
        val returnList = mutableListOf<Ingredient>()

        for (ingredient in ingredientList) {
            if (ingredient.ingredientType == type) {
                returnList.add(ingredient)
            }
        }

        return returnList
    }

    override fun count(): Int {
        return ingredientList.size
    }
}