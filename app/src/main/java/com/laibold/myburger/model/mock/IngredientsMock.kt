package com.laibold.myburger.model.mock

import com.laibold.myburger.model.DietType
import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType

class IngredientsMock {

    companion object {
        fun get(): MutableList<Ingredient> {
            return mutableListOf(
                Ingredient(0, IngredientType.BUN, "bun1", 10, DietType.VEGAN),
                Ingredient(0, IngredientType.BUN, "bun2", 20, DietType.VEGGIE),
                Ingredient(0, IngredientType.PATTY, "patty1", 30, DietType.VEGAN),
                Ingredient(0, IngredientType.PATTY, "patty2", 40, DietType.VEGGIE),
                Ingredient(0, IngredientType.PATTY, "patty3", 50, DietType.VEGAN),
                Ingredient(0, IngredientType.SALAD, "salad1", 10, DietType.VEGGIE),
                Ingredient(0, IngredientType.SALAD, "salad2", 15, DietType.VEGAN),
                Ingredient(0, IngredientType.VEGETABLE, "vegetable1", 11, DietType.VEGAN),
                Ingredient(0, IngredientType.VEGETABLE, "vegetable2", 21, DietType.VEGGIE),
                Ingredient(0, IngredientType.VEGETABLE, "vegetable3", 31, DietType.VEGAN),
                Ingredient(0, IngredientType.SAUCE, "sauce1", 25, DietType.VEGAN),
                Ingredient(0, IngredientType.SAUCE, "sauce2", 25, DietType.VEGGIE),
                Ingredient(0, IngredientType.SAUCE, "sauce3", 35, DietType.VEGAN),
            )
        }
    }

}