package com.example.tipcalculator

import org.junit.Assert.*
import java.text.NumberFormat

class MainActivityKtTest {

    @org.junit.Test
    fun tipCalculator() {
        val tip=10.00
        val tipPercent=20.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(2)
        val actualTip = tipCalculator(tip, tipPercent = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }
}