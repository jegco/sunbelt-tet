package com.example.sunbelttest

import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.sunbelttest.base.assertExist
import com.example.sunbelttest.base.waitViewShown
import com.example.sunbelttest.splash.SplashActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(
    AndroidJUnit4::class
)
class MovieListTest {

    @Rule
    @JvmField var mActivityTestRule = ActivityTestRule(
        SplashActivity::class.java
    )

    @Test
    fun loadList() {
        assertExist(R.id.loadingList)
        waitViewShown(R.id.movieList)
        assertExist("Mulan")
        swipeDown()
        assertExist("Legacy of lies")
    }
}