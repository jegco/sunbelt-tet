package com.example.sunbelttest.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sunbelttest.MainActivity
import com.example.sunbelttest.base.BaseActivity
import dagger.android.support.DaggerAppCompatActivity


class SplashActivity : BaseActivity() {
    private var splashLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}