package com.laibold.myburger.model.mock

import com.laibold.myburger.model.Burger

class BurgersMock() {

    companion object {
        fun get(): MutableList<Burger> {
            return mutableListOf(
                Burger("Tofu-Burger", listOf()),
                Burger("Kichererbsen-Burger", listOf()),
                Burger("Spinat-Burger", listOf()),
                Burger("Tempeh-Burger", listOf())
            )
        }
    }

}