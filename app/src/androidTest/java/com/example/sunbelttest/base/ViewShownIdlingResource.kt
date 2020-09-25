package com.example.sunbelttest.base

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.ViewFinder
import org.hamcrest.Matcher
import java.lang.reflect.Field


class ViewShownIdlingResource(private val viewMatcher: Matcher<View>) :
    IdlingResource {
    private var resourceCallback: IdlingResource.ResourceCallback? = null
    override fun isIdleNow(): Boolean {
        val view = getView(viewMatcher)
        val idle = view == null || view.isShown
        if (idle && resourceCallback != null) {
            resourceCallback!!.onTransitionToIdle()
        }
        return idle
    }

    override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    override fun getName(): String {
        return this.toString() + viewMatcher.toString()
    }

    companion object {
        private val TAG = ViewShownIdlingResource::class.java.simpleName
        private fun getView(viewMatcher: Matcher<View>): View? {
            return try {
                val viewInteraction = onView(viewMatcher)
                val finderField: Field = viewInteraction.javaClass.getDeclaredField("viewFinder")
                finderField.setAccessible(true)
                val finder = finderField.get(viewInteraction) as ViewFinder
                finder.view
            } catch (e: Exception) {
                null
            }
        }
    }
}