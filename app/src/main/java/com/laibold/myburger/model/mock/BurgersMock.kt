package com.laibold.myburger.model.mock

import com.laibold.myburger.model.Burger

class BurgersMock {

    companion object {
        fun get(): MutableList<Burger> {
            return mutableListOf(
                Burger("Tofu-Burger", mutableListOf()),
                Burger("Kichererbsen-Burger", mutableListOf()),
                Burger("Spinat-Burger", mutableListOf()),
                Burger("Tempeh-Burger", mutableListOf())
            )
        }
    }

}