package com.laibold.myburger.service

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class BurgerServiceTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun getRandomBurger() {
        val service = BurgerService(appContext)
        service.importIngredients()
        val burger = service.getRandomBurger()

        assertNotNull(burger)
    }

    @Test
    fun importIngredients() {
        val service = BurgerService(appContext)
        service.importIngredients()
        val list = service.getAllIngredients()
        assert(list.isNotEmpty())
    }

}