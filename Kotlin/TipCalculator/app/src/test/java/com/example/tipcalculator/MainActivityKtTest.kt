package com.example.tipcalculator

import org.junit.Assert.*
import java.text.NumberFormat

class MainActivityKtTest {

    @org.junit.Test
    fun test_1() {
        val tip=10.00
        val tipPercent=20.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(2)
        val actualTip = tipCalculator(tip, tipPercent = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }
    @org.junit.Test
    fun test_2() {
        val tip=0.00
        val tipPercent=20.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(0)
        val actualTip = tipCalculator(tip, tipPercent = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }
    @org.junit.Test
    fun test_3() {
        val tip=-10.00
        val tipPercent=20.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(0)
        val actualTip = tipCalculator(tip, tipPercent = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }
    @org.junit.Test
    fun test_4() {
        val tip=100.00
        val tipPercent=15.00
        val expectedTip= NumberFormat.getCurrencyInstance().format(15)
        val actualTip = tipCalculator(tip, tipPercent = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }


}