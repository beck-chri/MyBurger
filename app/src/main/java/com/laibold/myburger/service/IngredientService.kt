package com.laibold.myburger.service

import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.persistence.repository.ingredient.IngredientDao
import com.laibold.myburger.persistence.repository.ingredient.IngredientDaoInterface
import kotlin.random.Random

class IngredientService {
    private val ingredientDao: IngredientDaoInterface = IngredientDao

    fun add(ingredient: Ingredient) {
        ingredientDao.insert(ingredient)
    }

    fun addAll(ingredients: MutableList<Ingredient>) {
        for (ingredient in ingredients) {
            ingredientDao.insert(ingredient)
        }
    }

    fun getAll(): MutableList<Ingredient> {
        return ingredientDao.getAll()
    }

    fun getRandomIngredient(
        list: List<Ingredient>,
        number: Int
    ): MutableList<Ingredient> {
        val returnList = mutableListOf<Ingredient>()
        val copiedList = list.toMutableList()
        for (i in 0 until number) {
            if (copiedList.isEmpty()) {
                break;
            }
            val index = Random.nextInt(copiedList.size)
            returnList.add(copiedList[index])
            copiedList.removeAt(index)
        }
        
        return returnList
    }
}