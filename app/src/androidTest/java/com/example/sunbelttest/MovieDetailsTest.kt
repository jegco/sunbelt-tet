package com.example.sunbelttest

import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.sunbelttest.base.assertExist
import com.example.sunbelttest.base.clickInRecyclerView
import com.example.sunbelttest.base.waitViewShown
import com.example.sunbelttest.splash.SplashActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(
    AndroidJUnit4::class
)
class MovieDetailsTest {

    @Rule
    @JvmField var mActivityTestRule = ActivityTestRule(
        SplashActivity::class.java
    )

    @Test
    fun loadDetails() {
        assertExist(R.id.loadingList)
        waitViewShown(R.id.movieList)
        assertExist("Mulan")
        clickInRecyclerView("Mulan", R.id.movieList)
        assertExist(R.id.loadingDetails)
        waitViewShown(R.id.detailsContainer)
        assertExist("Spoken languages: en")
        assertExist("Trailers")
    }
}