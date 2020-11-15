package com.laibold.myburger.persistence.repository

import com.laibold.myburger.model.Burger

interface BurgerDaoInterface {
    fun insert(burger: Burger)

    fun getAll(): MutableList<Burger>

    fun getByIndex(index: Int): Burger?

    fun getByName(name: String): Burger?

    fun count(): Int
}