package com.laibold.myburger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laibold.myburger.model.Burger
import com.laibold.myburger.service.BurgerService

class MainViewModel : ViewModel() {
    private var service: BurgerService = BurgerService()

    private val _randomBurger: MutableLiveData<Burger> = MutableLiveData()
    val randomBurger: LiveData<Burger>
        get() = _randomBurger

    init {
        createRandomBurger()
    }

    fun createRandomBurger() {
        _randomBurger.value = service.getRandomBurger()
    }

    fun getIngredientsHeadline(ingredientsStr: String, dietTypeStr: String): String {
        var ingredientsHeadline = ingredientsStr.format(randomBurger.value?.getIngredientsSize())
        ingredientsHeadline += " ($dietTypeStr)"
        return ingredientsHeadline
    }

}
