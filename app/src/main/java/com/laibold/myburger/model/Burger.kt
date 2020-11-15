package com.laibold.myburger.model

import com.laibold.myburger.model.ingredient.Ingredient

data class Burger(var name: String, var ingredients: List<Ingredient>) {
    var state = false
}