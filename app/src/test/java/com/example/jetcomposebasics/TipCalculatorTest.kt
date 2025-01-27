package com.example.jetcomposebasics

import com.example.jetcomposebasics.tipcalculator.calculateTip
import org.junit.Test
import org.junit.Rule
//import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}

class TipUITest {

//    @get:Rule
//    val composeTestRule = createComposeRule()


    @Test
    fun calculate_20_percent_tip() {
//        composeTestRule.setContent {
//            JetComposeBasicsTheme() {
//                TipTimeLayout()
//            }
//        }
    }
}