package com.laibold.myburger.model

import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class BurgerTest {
    lateinit var ingredients: MutableList<Ingredient>

    @Before
    fun init() {
        ingredients = mutableListOf(
            Ingredient(0, IngredientType.BUN, "", 1, DietType.VEGAN),
            Ingredient(0, IngredientType.PATTY, "", 100, DietType.VEGAN),
            Ingredient(0, IngredientType.VEGETABLE, "", 50, DietType.VEGAN),
            Ingredient(0, IngredientType.SAUCE, "", 16, DietType.VEGAN)
        )
    }

    @Test
    fun getPriceTest() {
        val burger = Burger("", ingredients)

        assertEquals(burger.getPrice(), 167)
    }

    @Test
    fun getDietTypeTest() {
        val burger = Burger("", ingredients)
        assertSame(burger.getDietType(), DietType.VEGAN)

        burger.addIngredient(
            Ingredient(0, IngredientType.SAUCE, "", 16, DietType.VEGGIE)
        )

        assertSame(burger.getDietType(), DietType.VEGGIE)
    }
}