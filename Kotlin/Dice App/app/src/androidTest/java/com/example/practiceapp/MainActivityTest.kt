package com.example.practiceapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun setImage() {
        Espresso.onView(ViewMatchers.withId(R.id.diceBtn)).perform(ViewActions.click())
    }
}