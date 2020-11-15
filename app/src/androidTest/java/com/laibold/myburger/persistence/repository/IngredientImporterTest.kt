package com.laibold.myburger.persistence.repository

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.laibold.myburger.service.IngredientService
import org.junit.Assert.*
import org.junit.Test

class IngredientImporterTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private val service = IngredientService()

    @Test
    fun importIngredients() {
        IngredientImporter.importIngredients(appContext)

        var list = service.getAll()
        assert(list.isNotEmpty())
        val count = list.size

        // call import again, it should not run twice
        IngredientImporter.importIngredients(appContext)
        val newCount = list.size
        list = service.getAll()
        assertEquals(count, newCount)
    }
}
