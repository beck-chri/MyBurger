package com.laibold.myburger.model

import com.laibold.myburger.model.ingredient.Ingredient

data class Burger(var name: String, var ingredients: MutableList<Ingredient>) {

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

}
