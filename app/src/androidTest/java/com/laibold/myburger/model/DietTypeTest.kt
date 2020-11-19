package com.laibold.myburger.model

import android.content.Context
import android.os.LocaleList
import androidx.test.platform.app.InstrumentationRegistry
import com.laibold.myburger.R
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class DietTypeTest {
    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    
    @Test
    fun getStringValue() {
        val veganStrId = DietType.VEGAN.stringId
        val veganString: String = appContext.resources.getString(veganStrId)
        assertEquals(appContext.resources.getString(R.string.vegan), veganString)

        val veggieStrId = DietType.VEGGIE.stringId
        val veggieString: String = appContext.resources.getString(veggieStrId)
        assertEquals(appContext.resources.getString(R.string.veggie), veggieString)
    }
}
