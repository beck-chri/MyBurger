package com.laibold.myburger.persistence.raw

import android.content.Context
import android.util.Log
import com.laibold.myburger.model.DietType
import com.laibold.myburger.model.ingredient.Ingredient
import com.laibold.myburger.model.ingredient.IngredientType
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*

class JsonReader(private val context: Context) : RawReader {
    private val numberKey = "number"
    private val nameKey = "name"
    private val priceKey = "price"
    private val dietTypeKey = "diet_type"
    private var langIndex = 1 //1 for english names, 0 for german

    init {
        val locale = context.resources.configuration.locales[0]
        if (locale == Locale.GERMANY) {
            langIndex = 0
        }
    }

    override fun readIngredients(fileName: String): MutableList<Ingredient> {
        val jsonString = getJsonDataFromAsset(context, fileName)
        val ingredientList = mutableListOf<Ingredient>()

        if (jsonString != null) {
            val jFileObject = JSONObject(jsonString)

            for (value in IngredientType.values()) {
                val jArray = jFileObject.getJSONArray(value.toString())
                for (i in 0 until jArray.length()) {
                    val ingredientObject = jArray.getJSONObject(i)

                    try {
                        val ingredient = getIngredientFromJsonObject(ingredientObject, value)
                        ingredientList.add(ingredient)
                    } catch (e: JSONException) {
                        Log.i("Exception Parsing JSON:", e.message!!)
                    } catch (e: ClassCastException) {
                        Log.i("Exception Casting JSON:", e.message!!)
                    } catch (e: IllegalArgumentException) {
                        Log.i("Exception getting Enum constant from JSON:", e.message!!)
                    }
                }
            }
        }

        return ingredientList
    }

    private fun getIngredientFromJsonObject(jObject: JSONObject, type: IngredientType): Ingredient {
        try {
            val number = jObject.get(numberKey) as Int

            val names: JSONArray = jObject.getJSONArray(nameKey)
            val name = names[langIndex] as String

            val price = jObject.get(priceKey) as Int
            val dietType: DietType = DietType.valueOf(jObject.get(dietTypeKey) as String)

            return Ingredient(number, type, name, price, dietType)
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}