package com.laibold.myburger.model.ingredient

import com.laibold.myburger.model.DietType

data class Ingredient(
    var number: Int,
    var ingredientType: IngredientType,
    var name: String,
    var price: Int,
    var dietType: DietType
) {

}
