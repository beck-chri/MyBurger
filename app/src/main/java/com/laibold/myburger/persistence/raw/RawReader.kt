package com.laibold.myburger.persistence.raw

import com.laibold.myburger.model.ingredient.Ingredient

interface RawReader {
    fun readIngredients(fileName: String): MutableList<Ingredient>
}