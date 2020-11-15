package com.laibold.myburger.persistence.repository

import android.content.Context
import com.laibold.myburger.persistence.raw.JsonReader
import com.laibold.myburger.service.IngredientService

object IngredientImporter {
    private const val FILENAME = "ingredients.json" //TODO("to properties")
    private var importComplete = false

    fun importIngredients(context: Context) {
        val reader = JsonReader(context)
        val service = IngredientService()

        if (!importComplete) {
            val ingredientList = reader.readIngredients(FILENAME).toList()
            for (ingredient in ingredientList) {
                service.add(ingredient)
            }
        }
        importComplete = true
    }
}
