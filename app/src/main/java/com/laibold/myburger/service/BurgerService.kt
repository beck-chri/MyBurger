package com.laibold.myburger.service

import com.laibold.myburger.model.Burger
import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType
import com.laibold.myburger.persistence.repository.burger.BurgerDao
import com.laibold.myburger.persistence.repository.burger.BurgerDaoInterface
import com.laibold.myburger.persistence.repository.ingredient.IngredientDao
import com.laibold.myburger.persistence.repository.ingredient.IngredientDaoInterface
import kotlin.random.Random

class BurgerService() {
    private val burgerDao: BurgerDaoInterface = BurgerDao
    private val ingredientDao: IngredientDaoInterface = IngredientDao

    private val ingredientService = IngredientService()

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

    fun getRandomBurger(): Burger {
        val ingredients = mutableListOf<Ingredient>()
        val buns = ingredientDao.getByIngredientType(IngredientType.BUN)
        val patties = ingredientDao.getByIngredientType(IngredientType.PATTY)
        val salads = ingredientDao.getByIngredientType(IngredientType.SALAD)
        val vegetables = ingredientDao.getByIngredientType(IngredientType.VEGETABLE)
        val sauces = ingredientDao.getByIngredientType(IngredientType.SAUCE)

        val s = ingredientService

        ingredients.addAll(s.getRandomIngredient(buns, 1))
        ingredients.addAll(s.getRandomIngredient(patties, 1))
        ingredients.addAll(s.getRandomIngredient(salads, Random.nextInt(1, 2)))
        ingredients.addAll(s.getRandomIngredient(vegetables, Random.nextInt(1, 3)))
        ingredients.addAll(s.getRandomIngredient(sauces, Random.nextInt(1, 2)))

        val burger = Burger("", ingredients)

        burger.energy = Random.nextInt(200, 601)
        burger.fat = Random.nextInt(3, 21)
        burger.carbs = Random.nextInt(30, 81)
        burger.protein = Random.nextInt(4, 21)

        return burger
    }

}
