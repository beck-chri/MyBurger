package com.laibold.myburger.service

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.laibold.myburger.model.mock.IngredientsMock
import com.laibold.myburger.persistence.repository.IngredientImporter
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class BurgerServiceTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private lateinit var burgerService: BurgerService
    private lateinit var ingredientService: IngredientService

    @Before
    fun init() {
        burgerService = BurgerService()
        ingredientService = IngredientService()
        ingredientService.addAll(IngredientsMock.get())
    }

    @Test
    fun getRandomBurger() {
        val burger = burgerService.getRandomBurger()
        assertNotNull(burger)
        assertFalse(burger.ingredients.isEmpty())
        assertTrue(burger.ingredients.size >= 5)
    }

}
