package com.laibold.myburger.service

import android.content.Context
import com.laibold.myburger.model.Burger
import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType
import com.laibold.myburger.persistence.raw.JsonReader
import com.laibold.myburger.persistence.raw.RawReader
import com.laibold.myburger.persistence.repository.BurgerDao
import com.laibold.myburger.persistence.repository.BurgerDaoInterface
import com.laibold.myburger.persistence.repository.IngredientDao
import com.laibold.myburger.persistence.repository.IngredientDaoInterface
import kotlin.random.Random

class BurgerService(context: Context) {
    private val reader: RawReader = JsonReader(context)

    private val burgerDao: BurgerDaoInterface = BurgerDao
    private val ingredientDao: IngredientDaoInterface = IngredientDao

    fun add(burger: Burger) {
        burgerDao.insert(burger)
    }

    fun addAll(burgers: List<Burger>) {
        for (burger in burgers) {
            burgerDao.insert(burger)
        }
    }

    fun getAll(): MutableList<Burger> {
        return burgerDao.getAll()
    }

    fun getAllIngredients(): MutableList<Ingredient> {
        return ingredientDao.getAll()
    }

    fun importIngredients() {
        val ingredientList = reader.readIngredients("ingredients_de.json").toList()
        for (ingredient in ingredientList) {
            ingredientDao.insert(ingredient)
        }
    }

    fun getRandomBurger(): Burger {
        val ingredients = mutableListOf<Ingredient>()
        val buns = ingredientDao.getByIngredientType(IngredientType.BUN)
        val patties = ingredientDao.getByIngredientType(IngredientType.PATTY)
        val salads = ingredientDao.getByIngredientType(IngredientType.SALAD)
        val vegetables = ingredientDao.getByIngredientType(IngredientType.VEGETABLE)
        val sauces = ingredientDao.getByIngredientType(IngredientType.SAUCE)

        ingredients.addAll(getRandomIngredient(buns, 1))
        ingredients.addAll(getRandomIngredient(patties, 1))
        ingredients.addAll(getRandomIngredient(salads, Random.nextInt(1, 2)))
        ingredients.addAll(getRandomIngredient(vegetables, Random.nextInt(1, 3)))
        ingredients.addAll(getRandomIngredient(sauces, Random.nextInt(1, 2)))

        return Burger("Burger of the week", ingredients)
    }

    private fun getRandomIngredient(
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