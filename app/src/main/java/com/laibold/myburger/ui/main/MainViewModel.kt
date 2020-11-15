package com.laibold.myburger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laibold.myburger.model.Burger
import com.laibold.myburger.service.BurgerService
import java.text.DecimalFormat

class MainViewModel : ViewModel() {
    private var service: BurgerService = BurgerService()

    private val _randomBurger: MutableLiveData<Burger> = MutableLiveData()
    val randomBurger: LiveData<Burger>
        get() = _randomBurger

    init {
        _randomBurger.value = service.getRandomBurger()
    }

    fun createRandomBurger() {
        _randomBurger.value = service.getRandomBurger()
    }

    fun getRandomBurgerName(): String {
        val burger = randomBurger.value
        if (burger?.name != null) {
            return burger.name
        }
        return "Burger of the Week"
    }

    fun getRandomBurgerIngredientCount(): Int {
        val burger = randomBurger.value
        if (burger != null) {
            return burger.getIngredientsSize()
        }
        return 0
    }

    fun getRandomBurgerPrice(): String {
        val burger = randomBurger.value
        if (burger != null) {
            val df = DecimalFormat("0,00") //TODO("internationalisieren)
            return df.format(burger.getPrice()) + " €"
        }
        return ""
    }

    fun getRandomBurgerIngredients(): String {
        val burger = randomBurger.value
        if (burger != null) {
            return burger.ingredients.joinToString(", ") { it.name }
        }
        return ""
    }

}
