package com.example.sunbelttest.base

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*


fun clickView(id: Int) {
    onView(withId(id))
        .perform(click())
        .check(matches(isDisplayed()))
}

fun clickView(text: String) {
    onView(withText(text))
        .perform(click())
        .check(matches(isDisplayed()))
}

fun clickInRecyclerView(text: String, recyclerViewId: Int) {
    onView(withId(recyclerViewId))
        .perform(
            RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(withText(text)), click()
            )
        )
}

fun waitViewShown(id: Int) {
    val idlingResource: IdlingResource = ViewShownIdlingResource(withId(id))
    try {
        IdlingRegistry.getInstance().register(idlingResource)
        onView(withId(id)).check(matches(isDisplayed()))
    } finally {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}

fun assertExist(text: String) {
    onView(withText(text)).check(matches(withText(text)))
}

fun assertExist(id: Int) {
    onView(withId(id)).check(matches(withId(id)))
}