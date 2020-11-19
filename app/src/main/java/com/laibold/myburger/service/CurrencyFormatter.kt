package com.laibold.myburger.service

import java.text.NumberFormat

object CurrencyFormatter {

    fun format(price: Int): String {
        val mCurrencyFormat = NumberFormat.getCurrencyInstance()
        return mCurrencyFormat.format(price.toDouble() / 100)
    }

}
