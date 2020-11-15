package com.laibold.myburger.persistence.repository

import com.laibold.myburger.model.Burger
import com.laibold.myburger.model.mock.BurgersMock

object BurgerDao : BurgerDaoInterface {
    private val burgerList = mutableListOf<Burger>()

    /**
     * Mocking data
     */
    init {
        burgerList.addAll(BurgersMock.get())
    }

    override fun insert(burger: Burger) {
        burgerList.add(burger)
    }

    override fun getAll(): MutableList<Burger> {
        return burgerList
    }

    override fun getByIndex(index: Int): Burger? {
        if (index >= 0 && index < burgerList.size) {
            return burgerList[index]
        }
        return null
    }

    override fun getByName(name: String): Burger? {
        return burgerList.find { it.name == name }
    }

    override fun count(): Int {
        return burgerList.size
    }
}