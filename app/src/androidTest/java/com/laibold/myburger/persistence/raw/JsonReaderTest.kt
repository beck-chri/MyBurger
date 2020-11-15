package com.laibold.myburger.persistence.raw

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.laibold.myburger.model.DietType
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JsonReaderTest {

    @Test
    fun readIngredients() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val jsonReader = JsonReader(appContext)

        val list = jsonReader.readIngredients("ingredients_test.json")

        assertSame(list.size, 5)
        assertSame(list[0].number, 1)
        assertEquals(list[0].name, "veggie_bun")
        assertSame(list[0].price, 2)
        assertSame(list[0].dietType, DietType.VEGGIE)
        assertSame(list[2].dietType, DietType.VEGAN)
    }
}