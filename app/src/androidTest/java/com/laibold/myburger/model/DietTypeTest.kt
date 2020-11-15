package com.laibold.myburger.model

import android.R
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.security.AccessController.getContext
import java.util.*


class DietTypeTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    /**
     * Run with default locale configuration
     */
    @Test
    fun getStringValue() {
        val veganStrId = DietType.VEGAN.stringId
        val veganString: String = appContext.resources.getString(veganStrId)
        assertEquals(veganString, "Vegan")

        val veggieStrId = DietType.VEGGIE.stringId
        val veggieString: String = appContext.resources.getString(veggieStrId)
        assertEquals(veggieString, "Veggie")
    }
}
