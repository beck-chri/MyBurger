package com.laibold.myburger.model

import com.laibold.myburger.model.ingredient.Ingredient

data class Burger(var name: String, var ingredients: MutableList<Ingredient>) {
    var energy = 0
    var fat = 0
    var carbs = 0
    var protein = 0

    fun getDietType(): DietType {
        for (ingredient in ingredients) {
            if (ingredient.dietType == DietType.VEGGIE) {
                return DietType.VEGGIE
            }
        }
        return DietType.VEGAN
    }

    fun getPrice(): Int {
        var price = 0
        for (ingredient in ingredients) {
            price += ingredient.price
        }
        return price
    }

    fun addIngredient(ingredient: Ingredient) {
        ingredients.add(ingredient)
    }

    fun getIngredientsSize(): Int {
        return ingredients.size
    }

    fun getIngredientString(): String {
        return ingredients.joinToString(", ") { it.name }
    }

}
