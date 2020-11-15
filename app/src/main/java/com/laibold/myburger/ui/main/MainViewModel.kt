package com.laibold.myburger.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laibold.myburger.model.Burger

class MainViewModel : ViewModel() {
    private val _burgers: MutableLiveData<MutableList<Burger>> = MutableLiveData()
    val burgers: LiveData<MutableList<Burger>>
        get() = _burgers

    private val _randomBurger: MutableLiveData<Burger> = MutableLiveData()
    val randomBurger: LiveData<Burger>
        get() = _randomBurger

    fun setBurgers(burgers: MutableList<Burger>) {
        this._burgers.value = burgers
    }

    fun setRandomBurger(burger: Burger) {
        this._randomBurger.value = burger
    }
}
