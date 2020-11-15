package com.laibold.myburger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laibold.myburger.persistence.repository.IngredientImporter
import com.laibold.myburger.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        IngredientImporter.importIngredients(applicationContext)

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}